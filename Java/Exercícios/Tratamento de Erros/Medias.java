import java.util.InputMismatchException;
import java.util.Scanner;

public class Medias{
	public static void main(String args[]) {
		float media = 0;
		
        try {
        	Scanner scanner = new Scanner(System.in);
    		
    		System.out.print("Digite a primeira nota: ");
            float nota1 = scanner.nextFloat();
            
            System.out.print("Digite a segunda nota: ");
            float nota2 = scanner.nextFloat();
        	media = (nota1 + nota2) /2;
        }
        catch(InputMismatchException e){
        	System.out.println("Favor digitar um valor numérico!");
        	System.out.println("Código do erro: " + e.getMessage());
		}catch(ArithmeticException e) {
			System.out.println("Erro de cálculo, operação não permitida!");
			System.out.println("Código do erro: " + e.getMessage());
		}finally {
			System.out.print("A média é: " + media);
		}
	}
}	