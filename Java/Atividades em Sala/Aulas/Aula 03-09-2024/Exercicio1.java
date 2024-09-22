/* CRIAR UM PROGRAMA QUE VERIFIQUE SE A PALAVRA PALMEIRAS FOI ESCRITA VIA TECLADO.
 * CASO POSITIVO IMPRIMIR NA TELA LAMENTO, VOCÊ ESTÁ ENGANADO, O PALMEIRAS NÃO FOI 
 * CAMPEÃO DA LIBERTADORES 2023, TENTE NOVAMENTE. SE A PALAVRA ESCRITA FOR FLUMINENSE,
 * ESCREVA, SIM, VOCÊ ESTÁ CERTO, O FLUMINENSE FOI O CAMPEÃO DA LIBERTADORES 2023 (USE COMANDO IF)*/

package Aula0309;

import java.util.Scanner;

public class Exercicio1{
	public static void main(String[] args) {
		Scanner campeao = new Scanner(System.in);
		
		System.out.println("Informe o nome do time campeão da Libertadores 2023: ");
	    String time = campeao.nextLine();
	    
	    if (time.equalsIgnoreCase("Palmeiras")) 
	    {
	    	System.out.println("Lamento, você está enganado, o Palmeiras não foi campeão da Libertadores 2023, tente novamente. ");
	    }
	    else if( time.equalsIgnoreCase("Fluminense"))
	    {
	    	System.out.println("Sim, você está certo, o Fluminense Informe o nome do time campeão da Libertadores 2023!");
	    }
	    else 
	    {
	    	System.out.println("Esse time ai nem tava na libertadores!");
	    }
	    campeao.close();
	}
}