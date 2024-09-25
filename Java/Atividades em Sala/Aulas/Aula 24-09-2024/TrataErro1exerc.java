import java.util.Scanner;

public class TrataErro1exerc {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try{
            System.out.print("Digite um valor inteiro..:");
            String entrada1 = s.next();
            System.out.print("Digite um valor inteiro..:");
            String entrada2 = s.next();

            System.out.println(entrada1 + " concatenando " + entrada2 );
        } catch (Exception ex) {
            System.out.println("ERRO - Valor digitado nao e um numero inteiro!");
        }
    }
}

