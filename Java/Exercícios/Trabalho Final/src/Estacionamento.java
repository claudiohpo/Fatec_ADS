import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Estacionamento extends Component {
    private final Connection conn;

    public Estacionamento() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/estacionamento", "root", "root");
    }

    public void registrarEntrada(Veiculo veiculo) throws SQLException {

        String sql = "INSERT INTO veiculos (marca, modelo, cor, placa, nomeMotorista, horarioEntrada, fotoVeiculo, valorHora) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            System.out.println("Foto 1: " + Arrays.toString(veiculo.getFotoVeiculo()));
            stmt.setString(1, veiculo.getMarca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setString(3, veiculo.getCor());
            stmt.setString(4, veiculo.getPlaca());
            stmt.setString(5, veiculo.getNomeMotorista());
            stmt.setTimestamp(6, veiculo.getHorarioEntrada());
            stmt.setBytes(7, veiculo.getFotoVeiculo());
            stmt.setDouble(8, veiculo.getValorHora());


            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                int idGerado = rs.getInt(1);
                System.out.println("ID Registrado: " + idGerado);
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    veiculo.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public Veiculo registrarSaida(String placa, Timestamp horaSaida) throws SQLException {
        String buscaVeiculo = "SELECT * FROM veiculos WHERE placa = ? AND horarioSaida IS NULL";
        try (PreparedStatement stmt = conn.prepareStatement(buscaVeiculo)) {
            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                Timestamp horaEntrada = rs.getTimestamp("horarioEntrada");

                Veiculo veiculo = new Veiculo(rs.getString("marca"), rs.getString("modelo"),
                        rs.getString("cor"), placa, rs.getString("nomeMotorista"),
                        horaEntrada, rs.getBytes("fotoVeiculo"));
                veiculo.setId(id);
                veiculo.setHorarioSaida(horaSaida);

                // Aqui, buscamos o valorHora diretamente da tabela
                double valorHora = rs.getDouble("valorHora");

                if (valorHora <= 0) {
                    System.out.println("Valor por hora inválido. Utilizando valor padrão.");
                    valorHora = 5.0;  // Defina um valor padrão ou exiba um erro, se necessário
                }

                // Agora, calculamos a cobrança com o valorHora que foi buscado do banco
                long horas = veiculo.calculoPermanencia();
                double custo = calcularCobranca(horas, valorHora);

                veiculo.setValorTotal(custo);

                String atualizaVeiculo = "UPDATE veiculos SET horarioSaida = ?, valorTotal = ? WHERE id = ?";
                try (PreparedStatement updateStmt = conn.prepareStatement(atualizaVeiculo)) {
                    updateStmt.setTimestamp(1, horaSaida);
                    updateStmt.setDouble(2, custo);
                    updateStmt.setInt(3, id);
                    updateStmt.executeUpdate();
                }
                return veiculo;

            } else {
                System.out.println("Veículo não encontrado ou já saiu.");
                return null;
            }
        }
    }

//    private double calcularCobranca(long duracaoMilissegundos) {
//        double valorPorHora = 5.0; // Valor fixo por hora
//        long duracaoMinutos = duracaoMilissegundos / (60 * 1000);
//
//        if (duracaoMinutos <5){
//            return 0;
//        }
//
//        long horasCobradas = (duracaoMinutos + 59) / 60;
//
//        return horasCobradas * valorPorHora;
//    }

    private double calcularCobranca(long duracaoMilissegundos, double valorHora) {
        if (valorHora <= 0) {
            // Caso o valorHora seja inválido, retornamos 0 ou algum valor de erro
            return 0;
        }

        long duracaoMinutos = duracaoMilissegundos / (60 * 1000);
        if (duracaoMinutos < 5) {
            return 0;
        }

        long horasCobradas = (duracaoMinutos + 59) / 60;
        return horasCobradas * valorHora;
    }



    public List<Veiculo> consultarVeiculos() throws SQLException{
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM veiculos where horarioSaida IS NULL";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){

            while(rs.next()) {
                Veiculo veiculo = new Veiculo(
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("cor"),
                        rs.getString("placa"),
                        rs.getString("nomeMotorista"),
                        rs.getTimestamp("horarioEntrada"),
                        rs.getBytes("fotoVeiculo"));

                veiculo.setId(rs.getInt("id"));
                veiculo.setValorTotal(rs.getDouble("valorTotal"));
                veiculos.add(veiculo);

            }
        }
        return veiculos;
    }

    public List<Veiculo> consultarVeiculosHistorico() throws SQLException{
        List<Veiculo> veiculos = new ArrayList<>();
        //String sql = "SELECT v.*, c.valorTotal FROM veiculos v LEFT JOIN controle c ON v.id = c.id_veiculo";
        String sql = "SELECT * FROM veiculos";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){

            while(rs.next()) {
                Veiculo veiculo = new Veiculo(
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("cor"),
                        rs.getString("placa"),
                        rs.getString("nomeMotorista"),
                        rs.getTimestamp("horarioEntrada"),
                        rs.getTimestamp("horarioSaida"),
                        rs.getBytes("fotoVeiculo"));

                veiculo.setId(rs.getInt("id"));
                veiculo.setValorTotal(rs.getDouble("valorTotal"));
                veiculo.setValorHora(rs.getDouble("valorHora"));
                veiculos.add(veiculo);
            }
        }
        return veiculos;
    }

    public void atualizarVeiculo(int id, Veiculo veiculo) throws SQLException{
        String sql = "UPDATE veiculos SET marca = ?, modelo = ?, cor = ?, placa = ?, nomeMotorista = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)){

            logConsoleSQL(id,veiculo);

            stmt.setString(1, veiculo.getMarca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setString(3, veiculo.getCor());
            stmt.setString(4, veiculo.getPlaca());
            stmt.setString(5, veiculo.getNomeMotorista());
            stmt.setInt(6, id);

            int linhaAtualizada = stmt.executeUpdate();

//            if(linhaAtualizada > 0){
//                System.out.println("Veiculo atualizado com sucesso!"); //Console
//            }else {
//                System.out.println("Nenhuma alteração realizada!"); //Console
//            }
        }
    }

    public void logConsoleSQL(int id, Veiculo veiculo) throws SQLException{
        //Método criado para testes de SQL em console
        String sql = "SELECT * FROM veiculos";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            System.out.println("Atualizando veículo ID: " + id);
            System.out.println("Marca: " + veiculo.getMarca());
            System.out.println("Modelo: " + veiculo.getModelo());
            System.out.println("Cor: " + veiculo.getCor());
            System.out.println("Placa: " + veiculo.getPlaca());
            System.out.println("Nome do Motorista: " + veiculo.getNomeMotorista());
            System.out.println("Foto: " + Arrays.toString(veiculo.getFotoVeiculo()));
            System.out.println("Valor p Hora: " + veiculo.getValorHora());
        }
    }

    public boolean placaDuplicada(String placa) throws SQLException{
        String sql = "SELECT COUNT(*) FROM veiculos WHERE placa = ? AND horarioSaida is NULL";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, placa);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    public void excluirVeiculo(int id) throws SQLException{
        String sql = "DELETE FROM veiculos WHERE id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public Double getUltimoValorHora() throws SQLException {
        String sql = "SELECT valorHora FROM veiculos ORDER BY id DESC LIMIT 1";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getDouble("valorHora");
            }
        }
        return 5.0;  // Valor padrão caso não encontre nenhum valor
    }

    public Double getValorHoraPorPlaca(String placa) throws SQLException {
        String sql = "SELECT valorHora FROM veiculos WHERE placa = ? LIMIT 1";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, placa);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("valorHora");
                }
            }
        }
        return null; // Retorna null se o valorHora não for encontrado
    }




}