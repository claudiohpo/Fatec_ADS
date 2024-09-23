package Sistema;

public class GarantiaEstendida {
    private int id;
    private Produto produto;
    private double valor;

    public GarantiaEstendida(int id, Produto produto, double valor) {
        this.id = id;
        this.produto = produto;
        this.valor = valor;
    }

    public double calcularCreditoGarantia() {
        return valor * 0.01;
    }

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
}
