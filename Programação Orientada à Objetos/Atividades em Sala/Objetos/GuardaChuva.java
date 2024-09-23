package Tarefas;

public class GuardaChuva{
	
	String material;
	String cor;
	double tamanho;
	
		public static void main(String[] args) {
			GuardaChuva Guarda = new GuardaChuva();
			Guarda.material = "Nylon";
			Guarda.cor = "Azul";
			Guarda.tamanho = 0.78;
		
			System.out.println("Material do Abajur: " + Guarda.material);
			System.out.println("Cor: " + Guarda.cor);
			System.out.println("Peso: " + Guarda.tamanho + "cm");
		}					
}