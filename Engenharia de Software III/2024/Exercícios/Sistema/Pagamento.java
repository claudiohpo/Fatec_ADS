package Sistema;

public class Pagamento {
    private int id;
    private String meioDePagamento;

    public Pagamento(int id, String meioDePagamento) {
        this.id = id;
        this.meioDePagamento = meioDePagamento;
    }

    public boolean processarPagamento() {
        
        return true;
    }

   
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMeioDePagamento() { return meioDePagamento; }
    public void setMeioDePagamento(String meioDePagamento) { this.meioDePagamento = meioDePagamento; }
}
