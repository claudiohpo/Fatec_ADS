package Aula_27_09_2024.Exercico1;

public class PessoaF extends Cliente{
    private String CPF;
    private String dtNasc;
    private String estCivil;
    private String dtAbertConta;

    public PessoaF(String nome, int agencia, int conta, double saldo, String CPF, String dtNasc, String estCivil, String dtAbertConta) {
        super(nome, agencia, conta, saldo);
        this.CPF = CPF;
        this.dtNasc = dtNasc;
        this.estCivil = estCivil;
        this.dtAbertConta = dtAbertConta;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(String dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getEstCivil() {
        return estCivil;
    }

    public void setEstCivil(String estCivil) {
        this.estCivil = estCivil;
    }

    public String getDtAbertConta() {
        return dtAbertConta;
    }

    public void setDtAbertConta(String dtAbertConta) {
        this.dtAbertConta = dtAbertConta;
    }

    @Override
    public void exibir(){
        System.out.println("*** Pessoa Física ***");
        super.exibir();
        System.out.println("CPF: " + this.CPF);
        System.out.println("Data de Nascimento: " + this.dtNasc);
        System.out.println("Estado Civil: : " + this.estCivil);
        System.out.println("Cliente desde : " + this.dtAbertConta + "\n");
    }
}
