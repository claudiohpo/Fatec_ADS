import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private final Connection conn;

    public Estacionamento() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/estacionamento", "root", "root");
    }

    public void registrarEntrada(Veiculo veiculo) throws SQLException {
        String sql = "INSERT INTO veiculos (marca, modelo, cor, placa, nomeMotorista, horarioEntrada, fotoVeiculo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, veiculo.getMarca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setString(3, veiculo.getCor());
            stmt.setString(4, veiculo.getPlaca());
            stmt.setString(5, veiculo.getNomeMotorista());
            stmt.setTimestamp(6, veiculo.getHorarioEntrada());
            stmt.setBytes(7, veiculo.getFotoVeiculo());

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

                Veiculo veiculo = new Veiculo(rs.getString("marca"), rs.getString("modelo"), rs.getString("cor"), placa, rs.getString("nomeMotorista"), horaEntrada, rs.getBytes("fotoVeiculo"));
                veiculo.setId(id);
                veiculo.setHorarioSaida(horaSaida);

                long horas = veiculo.calculoPermanencia();
                double custo = calcularCobranca(horas);
                veiculo.setValorTotal(custo);

                String atualizaVeiculo = "UPDATE veiculos SET horarioSaida = ?, valorTotal = ? WHERE id = ?";
                try (PreparedStatement updateStmt = conn.prepareStatement(atualizaVeiculo)) {
                    updateStmt.setTimestamp(1, horaSaida);
                    updateStmt.setDouble(2, custo);
                    updateStmt.setInt(3, id);
                    updateStmt.executeUpdate();
                }
                return veiculo;

//                Veiculo ticket = new Veiculo( veiculo, horaEntrada, horaSaida, custo);
//
//                String insereTicket = "INSERT INTO controle (id_veiculo, horaEntrada, horaSaida, valorTotal) VALUES (?, ? , ?, ?)";
//                try (PreparedStatement ticketStmt = conn.prepareStatement(insereTicket)) {
//                    ticketStmt.setInt(1, id);
//                    ticketStmt.setTimestamp(2, horaEntrada);
//                    ticketStmt.setTimestamp(3, horaSaida);
//                    ticketStmt.setDouble(4, custo);
//                    ticketStmt.executeUpdate();
//                }
//
//                return ticket;
            } else {
                System.out.println("Veículo não encontrado ou já saiu.");
                return null;
            }
        }
    }

    private double calcularCobranca(long duracaoMilissegundos) {
        double valorPorHora = 5.0; // Valor fixo por hora
        long duracaoMinutos = duracaoMilissegundos / (60 * 1000);

        if (duracaoMinutos <5){
            return 0;
        }

        long horasCobradas = (duracaoMinutos + 59) / 60;

        return horasCobradas * valorPorHora;
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
                veiculos.add(veiculo);
            }
        }
        return veiculos;
    }
}