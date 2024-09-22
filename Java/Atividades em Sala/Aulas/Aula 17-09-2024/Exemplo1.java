package Aula1709;

public class Exemplo1{
	public static void main(String args[]) {

		String frase = null;
		String novaFrase = null;
		try 
		{
			novaFrase = frase.toUpperCase();
		}
		catch(NullPointerException e) //captura da possível exceção
		{ 
		
			//Tratamento da exceção
			System.out.println("A frase inicial está nula, para solucionar tal problema, foi lhe atribuido um valor dafault.");
			frase = "Frase vazia";
			novaFrase = frase.toUpperCase();
		}
			System.out.println("Frase antiga: "+ frase);
			System.out.println("Frase nova: " + novaFrase);
	}
}