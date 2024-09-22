package Aula1709;

import java.util.Scanner;

public class Texto{
	public static void main(String args[]) {
		 Scanner scanner = new Scanner(System.in);
	        String entrada = null;
	        boolean entradaValida = false;

	        while (!entradaValida) {
	            try {
	                System.out.print("Digite um texto em letras Maiúsculas: ");
	                entrada = scanner.nextLine();

	                if (entrada == null || entrada.isEmpty()) {
	                    throw new NullPointerException("Valor nulo ou vazio.");
	                }
	                if (entrada.equals(entrada.toUpperCase())) {
	                    System.out.println("Texto inserido corretamente: " + entrada);
	                    entradaValida = true;
	                } else {
	                    System.out.println("Por favor, insira o texto em MAIÚSCULAS.");
	                }
	            } catch (NullPointerException e) {
	                System.out.println("Erro!!! A entrada não pode ser nula ou vazia.");
	            }
	        }
	        scanner.close();
	}
}	