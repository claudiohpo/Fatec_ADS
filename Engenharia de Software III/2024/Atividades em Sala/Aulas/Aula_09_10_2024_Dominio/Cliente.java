import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private char genero;
    private double credito;
    private Endereco endereco;
    private List<Dependente>dependentes;

    public Cliente(String nome, String cpf, char genero, double credito, Endereco endereco, List<Dependente> dependentes) {
        this.nome = nome;
        this.cpf = cpf;
        this.genero = genero;
        this.credito = credito;
        this.endereco = endereco;
        this.dependentes = dependentes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }
}
