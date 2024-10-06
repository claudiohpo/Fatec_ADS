package Aula_04_10_2024;

import java.util.Scanner;

public class TestaMidia {
    public static void main(String args[]) {

        // Cria um vetor de elementos que são objetos da classe Midia.
        Midia[] lista = new Midia[10];
        int opcao;

        // Preenchendo o vetor com CDs.
        for (int i = 0; i < 2; i++) {

            // Usuário escolhe se quer cadastrar CD ou DVD.
            System.out.printf("Digite 1 para CD e 2 para DVD");
            Scanner in = new Scanner(System.in);
            opcao = in.nextInt();
            if (1 == opcao) // Criar CD.
                lista[i] = new CD();
            else // Criar DVD.
                lista[i] = new DVD();
            lista[i].inserirDados(); // Inserir dados no objeto criado seja CD ou DVD.
        }
        // Imprimindo o conteudo de cada elemento do vetor de acordo com a
        // classe a que ele pertence (isto e, usando polimorfismo).
        for (int i = 0; i < 2; i++)
            lista[i].printDados();
    }
} // Fim classe TestaMidia.