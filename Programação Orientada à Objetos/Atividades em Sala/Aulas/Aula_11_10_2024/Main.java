package Aula_11_10_2024;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int op = 0;

        try {
            System.out.print("Escolha um nome para seu bichinho: ");
            String nome = teclado.nextLine();

            System.out.print("Informe a classe do bichinho: ");
            String classe = teclado.nextLine();

            System.out.print("Informe a família do bichinho: ");
            String familia = teclado.nextLine();

            Animais a1 = new Animais(nome, classe, familia);
            System.out.println(a1.nasceu());

            while (op != 4) {
                System.out.println("Escolha uma das opções: \n" +
                        ("1 - Comer\n") + ("2 - Correr\n") +
                        ("3 - Dormir\n") + ("4 - Morrer\n") + ("5 - Status"));
                op = teclado.nextInt();

                switch (op) {
                    case 1:
                        System.out.println(a1.comer());
                        break;
                    case 2:
                        System.out.println(a1.correr());
                        break;
                    case 3:
                        System.out.println(a1.dormir());
                        break;
                    case 4:
                        System.out.println(a1.morrer());
                        break;
                    case 5:
                        System.out.println(a1.status());
                        break;
                    default:
                        System.out.println("Opção Inválida, tente novamente!");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            teclado.close();
        }
    }
}
