import java.sql.Timestamp;

public class Veiculo {
    private int id;
    private String marca;
    private String modelo;
    private String cor;
    private String placa;
    private String nomeMotorista;
    private Timestamp horarioEntrada;
    private Timestamp horarioSaida;
    private byte[] fotoVeiculo;

    public Veiculo(int id, String marca, String modelo, String cor, String placa, String nomeMotorista, Timestamp horarioEntrada, byte[] fotoVeiculo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.nomeMotorista = nomeMotorista;
        this.horarioEntrada = horarioEntrada;
        this.fotoVeiculo = fotoVeiculo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNomeMotorista() {
        return nomeMotorista;
    }

    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
    }

    public Timestamp getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(Timestamp horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public Timestamp getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(Timestamp horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public byte[] getFotoVeiculo() {
        return fotoVeiculo;
    }

    public void setFotoVeiculo(byte[] fotoVeiculo) {
        this.fotoVeiculo = fotoVeiculo;
    }

    public long calculoPermanencia(){
        if(horarioSaida != null && horarioEntrada != null){
            long millisegundos = horarioSaida.getTime() - horarioEntrada.getTime();
            return millisegundos / (60*60*1000);
        }
        return 0;
    }
}
