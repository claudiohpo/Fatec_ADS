package Aula_27_09_2024.Exercico1;

public class PessoaJ extends Cliente{
    private String CNPJ;
    private String responsavel;
    private String porte;
    private String dtAbertConta;

    public PessoaJ(String nome, int agencia, int conta, double saldo, String CNPJ, String responsavel, String porte, String dtAbertConta) {
        super(nome, agencia, conta, saldo);
        this.CNPJ = CNPJ;
        this.responsavel = responsavel;
        this.porte = porte;
        this.dtAbertConta = dtAbertConta;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getDtAbertConta() {
        return dtAbertConta;
    }

    public void setDtAbertConta(String dtAbertConta) {
        this.dtAbertConta = dtAbertConta;
    }

    @Override
    public void exibir(){
        System.out.println("*** Pessoa Jurídica ***");
        super.exibir();
        System.out.println("CNPJ: " + this.CNPJ);
        System.out.println("Proprietário/Representante Legal: " + this.responsavel);
        System.out.println("Porte: : " + this.porte);
        System.out.println("Cliente desde : " + this.dtAbertConta + "\n");
    }
}
