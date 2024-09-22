/* APROVEITANDO A ESTRUTURA DO PRIMEIRO PROGRAMA, 
 * FAÇA UM LOOP DO TIPO WHILE, QUE MANTENHA O USUARIO 
 * NO PROGRAMA ATÉ ELE DIGITAR FLUMINENSE*/

package Aula0309;

import java.util.Scanner;

public class Exercicio3{
	public static void main(String[] args) {
		
		Scanner campeao = new Scanner(System.in);
		String time="";
		
	   while (!time.equalsIgnoreCase("Fluminense")) 
	    {
		   System.out.println("Informe o nome do time campeão da Libertadores 2023: ");
		   time = campeao.nextLine();
	    }
	   System.out.println("Sim, você está certo, o Fluminense Informe o nome do time campeão da Libertadores 2023!");
	   campeao.close();
	}
}