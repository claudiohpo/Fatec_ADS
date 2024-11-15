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

            stmt.setString(1, veiculo.getMarca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setString(3, veiculo.getCor());
            stmt.setString(4, veiculo.getPlaca());
            stmt.setString(5, veiculo.getNomeMotorista());
            stmt.setTimestamp(6, veiculo.getHorarioEntrada());
            stmt.setBytes(7, veiculo.getFotoVeiculo());
            stmt.setDouble(8, veiculo.getValorHora());
            stmt.executeUpdate();

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

                double valorHora = rs.getDouble("valorHora");

                if (valorHora <= 0) {

                    valorHora = 5.0;
                }

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
                return null;
            }
        }
    }

    private double calcularCobranca(long duracaoMilissegundos, double valorHora) {
        if (valorHora <= 0) {
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

            stmt.setString(1, veiculo.getMarca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setString(3, veiculo.getCor());
            stmt.setString(4, veiculo.getPlaca());
            stmt.setString(5, veiculo.getNomeMotorista());
            stmt.setInt(6, id);

            int linhaAtualizada = stmt.executeUpdate();
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
        return 5.0;
    }
}