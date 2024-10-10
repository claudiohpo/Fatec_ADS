public class Dependente {
    private String nome;
    private Parentesco parentesco;

    public Dependente(String nome, Parentesco parentesco) {
        this.nome = nome;
        this.parentesco = parentesco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Parentesco getParentesco() {
        return parentesco;
    }

    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
    }
}

