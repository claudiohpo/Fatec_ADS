package Aula_27_09_2024.Exercico1;

public class Cliente {
    private String nome;
    private int agencia;
    private int conta;
    private double saldo;

    public Cliente(String nome, int agencia, int conta, double saldo) {
        this.nome = nome;
        this.agencia = agencia;
        this.conta = conta;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void exibir(){
        System.out.println("Sr(a). " + this.nome);
        System.out.println("Agência: " + this.agencia);
        System.out.println("Conta: " + this.conta);
        System.out.println("Saldo na conta: " + this.saldo);
    }
}
