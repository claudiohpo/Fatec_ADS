package Aulas;

public class Salario{
	
	public static void main(String[] args) {
	
	String nome1 = "Maricota";
	int anos1 = 10;
	float salario1 = 5000;
	
	String nome2 = "Dorgival";
	int anos2 = 3;
	float salario2 = 1420;
	
	String nome3 = "Amarilys";
	int anos3 = 5;
	float salario3 = 1900;

	double salarioFinal1 = calcularSalarioFinal(anos1, salario1);
	double salarioFinal2 = calcularSalarioFinal(anos2, salario2);
	double salarioFinal3 = calcularSalarioFinal(anos3, salario3);	
	
	double bonus1 = calcularBonus(anos1, salario1);
	double bonus2 = calcularBonus(anos2, salario2);
	double bonus3 = calcularBonus(anos3, salario3);

	System.out.printf("%s, com %d anos de empresa, terá um salário final de: R$ %.2f e um bonus de R$ %.2f%n\n", nome1, anos1, salarioFinal1, bonus1);
    System.out.printf("%s, com %d anos de empresa, terá um salário final de: R$ %.2f e um bonus de R$ %.2f%n\n", nome2, anos2, salarioFinal2, bonus2);
    System.out.printf("%s, com %d anos de empresa, terá um salário final de: R$ %.2f e um bonus de R$ %.2f%n\n", nome3, anos3, salarioFinal3, bonus3);
	}
	
	public static double calcularSalarioFinal(int anos, double salario) {
		int aumentoQuinquenal = (anos / 5) * 5;
		double salarioFinal = salario + (salario * aumentoQuinquenal / 100);
				
		return salarioFinal;
	}
	
	public static double calcularBonus(int anos, double salario) {
		int Quinquenio = (anos / 5);
		double bonus = Quinquenio * salario;
		
		return bonus;
	}
}
