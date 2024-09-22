package Tarefas;

public class Abajur{
	
	String material;
	String cor;
	int voltagem;
	double peso;
	
	
		public static void main(String[] args) {
			Abajur Ab1 = new Abajur();
			Ab1.material = "Porcelana";
			Ab1.cor = "Cinza";
			Ab1.voltagem = 220;
			Ab1.peso = 5;
			
			System.out.println("Material do Abajur: " + Ab1.material);
			System.out.println("Cor: " + Ab1.cor);
			System.out.println("Voltagem: " + Ab1.voltagem);
			System.out.println("Peso: " + Ab1.peso + "kg");
			
			
		}		
			
}