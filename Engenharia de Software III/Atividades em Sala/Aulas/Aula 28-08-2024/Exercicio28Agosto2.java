public class Exercicio28Agosto2{
	
	public static void main(String[] args) {
		
		double raio = 3.4;
		final double PI = 3.14159;
		
		double area = PI * raio *raio;
		System.out.println(area);
		raio = 10;
		area = PI * raio * raio;
		System.out.println("Área = "+ area + "m²");
				
		
		double CarroNovo = 85000.00;
		double entrada = CarroNovo * 0.3 ;
		
		
		double parcela = (CarroNovo - entrada) / 12 * 1.25 ;
		
		
		
		System.out.println("O Valor de cada parcela será de: R$" + parcela);
	}
}