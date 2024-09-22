package ImpostoDeRenda;

import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner menu = new Scanner(System.in);
		
		System.out.println("Bem vindo ao Sistema de Cálculo de Imposto de Renda!\n\n");
		while (true) {
			
			System.out.println("Pressione o número correspondente para navegar no menu:");
			System.out.println("1 - Visualizar a tabela atual de Imposto de Renda");
			System.out.println("2 - Calcular o Valor de Desconto do Imposto de Renda");
			System.out.println("3 - Sair");
			
			
			int opcao = menu.nextInt();

			switch (opcao) {
			case 1:
				Tabela.MostrarTabela();
				break;
			
			case 2:
				Calculo.MostrarDados();
				break;
				
			case 3:
				System.out.println("Saindo...");
				menu.close();
				System.exit(0);
				break;
				
			default:
				System.out.println("Opção Inválida. Tente novamente.");
			}
		}
	}
}