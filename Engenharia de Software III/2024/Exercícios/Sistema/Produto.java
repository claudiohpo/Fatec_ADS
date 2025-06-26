package Sistema;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private String categoria;
    private boolean temGarantiaEstendida;

    public Produto(int id, String nome, double preco, String categoria, boolean temGarantiaEstendida) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.temGarantiaEstendida = temGarantiaEstendida;
    }

    public double calcularPrecoComGarantia() {
        
        return temGarantiaEstendida ? preco * 1.1 : preco;
    }

   
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public boolean isTemGarantiaEstendida() { return temGarantiaEstendida; }
    public void setTemGarantiaEstendida(boolean temGarantiaEstendida) { this.temGarantiaEstendida = temGarantiaEstendida; }
}
