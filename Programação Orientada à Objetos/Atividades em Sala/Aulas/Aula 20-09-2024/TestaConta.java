package Aula2009;

public class TestaConta {
	public static void main(String[] args) {
		Conta c1 = new Conta();

		c1.titular = "Cláudio";
		c1.numero = 830178;
		c1.agencia = "0231";
		c1.saldo = 50.0;
		c1.dataDeAbertura = "25/10/2000";

		c1.depositar(100.0);
		System.out.println("Saldo atual: " + c1.saldo);
		System.out.println("rendimento mensal: " + c1.calcularRendimento());

		Conta c3 = new Conta();
		c3.titular = "Danilo";
		c3.saldo = 100;

		Conta c2 = new Conta();
		c2.titular = "Danilo";
		c2.saldo = 100;

		if (c1 == c2) {
			System.out.println("Iguais!");
		} else {
			System.out.println("Diferentes!");
		}

	}
}

class Conta {

	String titular;
	int numero;
	String agencia;
	double saldo;
	String dataDeAbertura;

	String recuperaDadosParaImpressao() {
		String dados = "Titular: " + this.titular;
		dados += "\nNúmero: " + this.numero;
		dados += "\nAgência: " + this.agencia;
		dados += "\nSaldo: R$" + this.saldo;
		dados += "\nData de abertura: " + this.dataDeAbertura;
		return dados;
	}

	void sacar(double valor) {
		
		if (valor > saldo) {
			System.out.println("Valor do saque é maior que seu saldo.");
			System.out.println("Valor do saque: " + valor);
			System.out.println("Saldo atual:" + saldo);
		}else {
			this.saldo -= valor;
		}
	}

	void depositar(double valor) {
		this.saldo += valor;
	}

	double calcularRendimento() {
		return this.saldo * 0.1;
	}

}
