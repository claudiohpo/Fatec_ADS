package Sistema;

public class Frete {
    private int id;
    private String tipoFrete;
    private double valorFrete;

    public Frete(int id, String tipoFrete) {
        this.id = id;
        this.tipoFrete = tipoFrete;
    }

    public double calcularFrete(Endereco endereco) {
        
        valorFrete = tipoFrete.equals("express") ? 30.0 : 15.0;
        return valorFrete;
    }

   
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTipoFrete() { return tipoFrete; }
    public void setTipoFrete(String tipoFrete) { this.tipoFrete = tipoFrete; }

    public double getValorFrete() { return valorFrete; }
}
