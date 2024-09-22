package Aula0309;

public class DoWhile{
	public static void main(String[] args) {
		int contadorDoces = 1;
		while (contadorDoces <= 3) 
		{
			System.out.println(contadorDoces);
			if (contadorDoces == 3) 
			{
				System.out.println("Não pode comer mais doces");
			}
			contadorDoces ++;
		}
	}
}