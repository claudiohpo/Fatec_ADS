package Polimorfismo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Veiculos[] lista = new Veiculos[10];
        int opcao,qtd;

        System.out.println("Informe a quantidade de veículos que deseja cadastrar:");
        qtd = in.nextInt();

        while (qtd <= 0){
            System.out.println("Valor informado não permitido.");
            System.out.println("Informe a quantidade de veículos que deseja cadastrar:");
            qtd = in.nextInt();
        }

        for (int i = 0; i < qtd; i++) {
            System.out.printf("Digite 1 para Moto, 2 para Carro e 0 para sair: ");
            opcao = in.nextInt();

            switch (opcao){
                case 1:
                    lista[i] = new Moto();
                    lista[i].inserirDados();
                    break;

                case 2:
                    lista[i] = new Carro();
                    lista[i].inserirDados();
                    break;

                case 0:
                    System.out.println("Obrigado por usar nosso sistema!!!\n\nAté mais!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção digitada é inválida, tente novamente:\n1 - Moto\n2 - Carro\n0 - Sair");
                    i--;
                    break;
            }
        }

        System.out.println("\nRelatório dos Veículos:");
        for (int i = 0; i < qtd; i++) {
            lista[i].printDados();
            System.out.printf("Preço ajustado: R$ %.2f\n\n\n",lista[i].getPreco());
        }
    }
}