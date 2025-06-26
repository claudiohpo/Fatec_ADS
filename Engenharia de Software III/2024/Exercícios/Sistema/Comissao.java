package Sistema;

public class Comissao {
    private int id;
    private int vendedorId;
    private double valorComissao;

    public Comissao(int id, int vendedorId) {
        this.id = id;
        this.vendedorId = vendedorId;
    }

    public double calcularComissao(double valorVenda, Produto produto) {
      
        double taxaComissao = produto.isTemGarantiaEstendida() ? 0.02 : 0.01;
        this.valorComissao = valorVenda * taxaComissao;
        return valorComissao;
    }

    
    public void setValorComissao(double valorComissao) {
        this.valorComissao = valorComissao;
    }

   
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getVendedorId() { return vendedorId; }
    public void setVendedorId(int vendedorId) { this.vendedorId = vendedorId; }

    public double getValorComissao() { return valorComissao; }
}

