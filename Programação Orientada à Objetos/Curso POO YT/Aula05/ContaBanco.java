package Aula05;

public class ContaBanco {

    public void estadoAtual(){
        System.out.println("---------------------------");
        System.out.println("Conta: " + this.getConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: R$" + this.getSaldo());
        System.out.println("Status: " + this.getStatus());
        System.out.println("---------------------------");
    }

    //Atributos
    public int conta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    //Construtor - Método Especial
    public ContaBanco() {
        this.saldo = 0;
        this.status = false;
    }

    //Getters e Setters
    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //Métodos Personalizados
    public void abrirConta(String T){
        this.setTipo(T);
        this.setStatus(true);

        if(T == "CC"){
            //this.saldo = 50; //diretamente no atributo
            this.setSaldo(50); //Utilizando o método
        }else if(T == "CP"){
            this.setSaldo(150);
        }
        System.out.println(dono + ", Conta aberta com sucesso!");
    }

    public void fecharConta(){
        if (this.getSaldo() > 0){
            System.out.println(dono + ", Conta com dinheiro, não pode ser encerrada!");
        } else if (this.getSaldo() < 0){
            System.out.println(dono + ", Conta em débito, não pode ser encerrada!");
        }else{
            this.setStatus(false); //ou Status = false;
            System.out.println(dono + ", Conta encerrada com sucesso!");
        }
    }

    public void depositar(float valor){
        if (this.getStatus() == true) { //ou if (getStatus == true) ou (getStatus)
            //this.saldo = this.saldo + valor; // ou setSaldo(getSaldo() + valor);
            this.setSaldo(this.getSaldo() + valor); //trabalhando diretamente com os métodos especiais
            System.out.println("Depósito realizado com sucesso na conta de " + dono);
        }else{
            System.out.println(dono + ", Impossível depositar em uma conta fechada!");
        }
    }

    public void sacar(float valor){
        if (this.getStatus() == true){ //Pode ser também: "if (this.getStatus()){}
            if (this.getSaldo() >= valor){
                this.setSaldo(this.getSaldo() - valor);
                System.out.println("Saque de R$ " + valor + " efetuado com sucesso na conta de " + dono);
            }else{
                System.out.println(dono + ", Saldo Insuficiente para o saque");
            }
        }else{
            System.out.println(dono + ", Impossível sacar");
        }
    }

    public void pagarMensal(){
        int v = 0;
        if (this.getTipo() == "CC"){
            v = 12;
        }else if(this.getTipo() == "CP"){
            v = 20;
        }
        if (this.getStatus() == true){
            if(this.getSaldo() > v){
                this.setSaldo(getSaldo() - v);
                System.out.println("Mensalidade debitada com Sucesso na conta de " + dono);
            }else{
                System.out.println(dono + ", Saldo insuficiente!");
            }
        }else{
            System.out.println(dono + ", Impossível pagar!");
        }
    }

}