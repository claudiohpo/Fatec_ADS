package Sistema;

public class Cliente {
    private int id;
    private String nome;
    private String classificacao;
    private double credito;

    public Cliente(int id, String nome, String classificacao, double credito) {
        this.id = id;
        this.nome = nome;
        this.classificacao = classificacao;
        this.credito = credito;
    }

    public boolean ehClienteClassificado() {
        return !classificacao.equalsIgnoreCase("mal");
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getClassificacao() { return classificacao; }
    public void setClassificacao(String classificacao) { this.classificacao = classificacao; }

    public double getCredito() { return credito; }
    public void setCredito(double credito) { this.credito = credito; }
}
