/*Dado a entrada de dois valores monetarios quaisquer, comparar os valores. Se a diferença entre estes valores for superior a 20% o programa deverá emitir um alerta. */

import java.util.*;
import java.util.Scanner;

public class ExercicioSala1 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        double numero1 = 0;
        double numero2 = 0;
        boolean validado = false;

        while (!validado) {
            try {
                
                System.out.print("Digite um valor:");
                numero1 = s.nextDouble();
                System.out.print("Digite um valor:");
                numero2 = s.nextDouble();

                if ((numero1 - numero2 > (numero1 * 0.2)) || (numero2 - numero1 > (numero2 * 0.2)) ) {
                    System.out.println("A diferença entre valores é superior a 20%!");
                    System.out.println("Tente novamente:\n");
                } else {
                    System.out.println("Tudo bem com a diferença!");
                    validado = true; 
                }

            } catch (InputMismatchException ex) {
                System.out.println("O valor inserido não é um número inteiro!");
            }
        }
        s.close();
    }
}