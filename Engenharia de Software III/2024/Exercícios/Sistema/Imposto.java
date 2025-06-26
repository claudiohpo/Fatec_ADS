package Sistema;

public class Imposto {
    private int id;
    private String tipo; // COFINS, ICMS
    private double aliquota;
    private double valor;

    public Imposto(int id, String tipo, double aliquota) {
        this.id = id;
        this.tipo = tipo;
        this.aliquota = aliquota;
    }

    public double calcularImposto(double valorBase) {
        this.valor = valorBase * (aliquota / 100);
        return valor;
    }

 
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getAliquota() { return aliquota; }
    public void setAliquota(double aliquota) { this.aliquota = aliquota; }

    public double getValor() { return valor; }
}
