/*CRIAR UM PROGRAMA QUE COLETE O NOME DE 12 PESSOAS E AS IMPRIMA NA TELA. (USE O LOOP FOR)*/

package Aula0309;
 
import java.util.Scanner;

public class Exercicio2{
	public static void main(String[] args) {
		Scanner pessoas = new Scanner(System.in);
		
		for (int contador=1; contador<=12; contador++){
			System.out.println("Informe o " + contador + "º nome: ");
		    String nome = pessoas.nextLine();		
		    System.out.println("Bem vindo " + nome + "!!!!");
		}
		pessoas.close();
	}
}