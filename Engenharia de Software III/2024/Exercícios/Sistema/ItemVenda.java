package Sistema;

public class ItemVenda {
    private int id;
    private Produto produto;
    private int quantidade;
    private double valorTotalItem;

    public ItemVenda(int id, Produto produto, int quantidade) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotalItem = calcularValorTotal();
    }

    public double calcularValorTotal() {
        return produto.getPreco() * quantidade;
    }

   
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double getValorTotalItem() { return valorTotalItem; }
}

