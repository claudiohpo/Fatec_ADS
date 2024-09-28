package Aula3008;

public class ContaCorrente {

      private int agencia;
      private int conta;
      private String titular;
      private String cpfTitular;
      private float saldo;

      public void imprimir() {
            System.out.println("Nome: " + titular);
            System.out.println("CPF: " + cpfTitular);
            System.out.println("Agência: " + agencia);
            System.out.println("Conta Corrente: " + conta);
            System.out.println("Saldo em conta: " + saldo);

      }

      public String getNome() {
            return titular;
      }
      public void setNome(String titular) {
            this.titular = titular;
      }
      public String getcpfTitular() {
            return cpfTitular;
      }
      public void setcpfTitular(String cpfTitular) {
            this.cpfTitular = cpfTitular;
      }
      public float getsaldo() {
            return saldo;
      }
      public void setsaldo(float saldo) {
            this.saldo = saldo;
      }
      public int getagencia() {
            return agencia;
      }
      public void setagencia(int agencia) {
            this.agencia = agencia;
      }
      public int getconta() {
            return conta;
      }
      public void setconta(int conta) {
            this.conta = conta;
      }

      public void main(String[] args) {

          ContaCorrente cliente1 = new ContaCorrente();
          cliente1.setNome("Cláudio");
          cliente1.setcpfTitular("11122233344");
          cliente1.setsaldo(9999);
          cliente1.setagencia(0111);
          cliente1.setconta(123456);
          cliente1.imprimir();

}

}