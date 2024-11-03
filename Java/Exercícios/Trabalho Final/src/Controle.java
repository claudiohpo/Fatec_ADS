import java.sql.Timestamp;

public class Controle {
    private int id;
    private Veiculo veiculo;
    private Timestamp horaEntrada;
    private Timestamp horaSaida;
    private double valorTotal;

    public Controle(int id, Veiculo veiculo, Timestamp horaEntrada, Timestamp horaSaida, double valorTotal) {
        this.id = id;
        this.veiculo = veiculo;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.valorTotal = valorTotal;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}
