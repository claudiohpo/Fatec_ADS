import java.sql.*;

public class Estacionamento {
    private Connection conn;

    public Estacionamento() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/estacionamento", "root", "root");
    }

    public void registrarEntrada(Veiculo veiculo) throws SQLException {
        String sql = "INSERT INTO veiculos (id, marca, modelo, cor, placa, nomeMotorista, horarioEntrada, fotoVeiculo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, String.valueOf(veiculo.getId()));
            stmt.setString(2, veiculo.getMarca());
            stmt.setString(3, veiculo.getModelo());
            stmt.setString(4, veiculo.getCor());
            stmt.setString(5, veiculo.getPlaca());
            stmt.setString(6, veiculo.getNomeMotorista());
            stmt.setTimestamp(7, veiculo.getHorarioEntrada());
            stmt.setBytes(8, veiculo.getFotoVeiculo());

            stmt.executeUpdate();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    veiculo.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public Controle registrarSaida(String placa, Timestamp horaSaida) throws SQLException {
        String buscaVeiculo = "SELECT * FROM veiculos WHERE placa = ? AND horarioSaida IS NULL";
        try (PreparedStatement stmt = conn.prepareStatement(buscaVeiculo)) {
            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                Timestamp horaEntrada = rs.getTimestamp("horarioEntrada");

                Veiculo veiculo = new Veiculo(rs.getInt("id"), rs.getString("marca"), rs.getString("modelo"), rs.getString("cor"), placa, rs.getString("nomeMotorista"), horaEntrada, rs.getBytes("fotoVeiculo"));
                veiculo.setId(id);
                veiculo.setHorarioSaida(horaSaida);

                long horas = veiculo.calculoPermanencia();
                double custo = calcularCobranca(horas);

                String atualizaVeiculo = "UPDATE veiculos SET horarioSaida = ? WHERE id = ?";
                try (PreparedStatement updateStmt = conn.prepareStatement(atualizaVeiculo)) {
                    updateStmt.setTimestamp(1, horaSaida);
                    updateStmt.setInt(2, id);
                    updateStmt.executeUpdate();
                }

                Controle ticket = new Controle(id, veiculo, horaEntrada, horaSaida, custo);

                String insereTicket = "INSERT INTO controle (id, horaEntrada, horaSaida, valorTotal) VALUES (?, ?, ?, ?)";
                try (PreparedStatement ticketStmt = conn.prepareStatement(insereTicket)) {
                    ticketStmt.setInt(1, id);
                    //ticketStmt.setString(2, String.valueOf(veiculo));
                    ticketStmt.setTimestamp(2, horaEntrada);
                    ticketStmt.setTimestamp(3, horaSaida);
                    ticketStmt.setDouble(4, custo);
                    ticketStmt.executeUpdate();
                }

                return ticket;
            } else {
                System.out.println("Veículo não encontrado ou já saiu.");
                return null;
            }
        }
    }

    private double calcularCobranca(long horas) {
        double valorPorHora = 5.0; // Valor fixo por hora
        return horas * valorPorHora;
    }
}