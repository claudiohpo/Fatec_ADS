package Aulas;

import java.util.Scanner;

public class Conversor {

	public static void main(String[] args) {

		double milhas;
		
		Scanner medida = new Scanner(System.in);
		
		System.out.println("*** CONVERSOR DE MEDIDAS - KM > MILHAS ***\n");
		System.out.print("Digite a quantidade de quilometros: ");
		Double km = medida.nextDouble();
		
		milhas = km * 0.6214;
		
		System.out.printf(km + " quilometros são equivalentes a %.3f milhas.",milhas);
		
		medida.close();
	}
}
