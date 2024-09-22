package Tarefas;

public class Cachorro{
	
	 String nome="Spyke";
	 String raca="Preto";
	 int idade=11;
	 double peso=20.5;
	
	
		public void latir() {
			System.out.println("O " + nome + " está latindo a manhã toda!");
		}
		
		public void comendo() {
			System.out.println("Ontem o " + nome + " comeu muito, hoje pesei ele, e ele está com " + peso + "kg.");
		}
		
		public void ficha() {
			System.out.println("Nome: " + nome);
			System.out.println("Raça: " + raca);
			System.out.println("Idade: " + idade);
			System.out.println("Peso: " + peso);
		}
}