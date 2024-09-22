//23 de Agosto de 2024

public class Circulo{
	
	public static void main(String[] args) {
		
		//definindo as propriedades
		double pi=3.14159265358979323846;
		double raio=3.4;
		
		//Calculando os métodos
		double circunferencia = raio * 2 * pi;
		
		//System.out.println("\nA Circunferência é: " + circunferencia);
		
		System.out.printf("\nA Circunferência do círculo é %.2fcm", circunferencia);
		
		double Calculararea = pi * raio * raio;
		System.out.printf("\nA Área do círculo é %.2fcm", Calculararea);
		
}
}