package Aulas;

import java.util.Scanner;

public class NomeIdade {

	public static void main(String[] args) {

		int ano;
		
		Scanner user = new Scanner(System.in);
		
		System.out.println("*** ADIVINHAR ANO DO NASCIMENTO ***\n");
		System.out.print("\nDigite o seu nome: ");
		String nome = user.nextLine();
		
		System.out.print("\nDigite a sua idade atual: ");
		int idade = user.nextInt();
		user.nextLine(); 
		
		
		System.out.print("\nVocê já fez aniversário esse ano?(s/n): ");
		String aniversario = user.nextLine();
		
		if(aniversario.equals("s")) {
			ano = 2024 - idade;
			System.out.println("\n\n" + nome + ", você nasceu em :" + ano + ".");
		}
		else {
			if(aniversario.equals("n")) {
				ano = 2024 - idade -1;
				System.out.println("\n\n" + nome + ", você nasceu em :" + ano + ".");
			}
			else {
				System.out.println("\nVocê deve digitar 's' ou 'n' somente.");
			}	
		}
		user.close();
	}
}
