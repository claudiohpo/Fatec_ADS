package Aulas;

import java.util.Scanner;

public class EntradaDados {

	public static void main(String[] args) {
		
		System.out.print("Bom");
		System.out.print(" dia!\n\n");
		
	System.out.println("Bom");
	System.out.println("dia!");
		
	System.out.printf("Megasena: %d %d %d %d %d %d %n", 
			1, 2, 3, 4, 5, 6);
		System.out.printf("Salário: %.1f%n", 1234.5678);
	System.out.printf("Nome: %s%n", "João");
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Digite o seu nome: ");
		String nome = entrada.nextLine();
		
		System.out.print("Digite o seu sobrenome: ");
		String sobrenome = entrada.nextLine();

		System.out.print("Digite a sua idade: ");
		int idade = entrada.nextInt();
		
		System.out.printf("%s %s tem %d anos.%n", nome, sobrenome, idade);
		
		entrada.close();
		
		
		
		// Esclarecimento sobre os métodos nextInt e nextDouble

//Passando para esclarecer uma particularidade dos métodos nextInt() e nextDouble().
		//Ambos os métodos têm a mesma particularidade, mas vou explicá-la através do nextInt()
		//com o exemplo abaixo.

    Scanner teclado = new Scanner(System.in);
     
        System.out.println("Qual a sua idade?");
       int idade2 = teclado.nextInt();
      System.out.println("Qual o seu nome?");
      String nome2 = teclado.nextLine();
     System.out.println("Qual o seu sobrenome?");
     String sobrenome2 = teclado.nextLine();
     
     teclado.close();

// À primeira vista, parece que está tudo bem com este código. Mas quando o rodamos, o que é impresso no console (contendo os inputs) é o seguinte:

//    Qual a sua idade? 25
//    Qual o seu nome? Qual o seu sobrenome? Silva

//Isso acontece por causa da maneira como o nextInt() faz a leitura dos valores.

//Esse método faz a leitura de um único número, por exemplo, 58 ou 958. Mas quando digitamos os inputs, além do valor que deve ser lido, também apertamos enter, o que gera um caracter "\n" no buffer de entrada (fila de coisas que devem ser lidas), que é uma representação do enter.

//Então, o que acontece é: "Qual a sua idade?" é impresso, digitamos o valor e apertamos enter. Quando fazemos isso, o buffer de entrada fica com o conteúdo "25\n", e quando o nextInt() faz a leitura, ele lê apenas o 25, deixando o "\n" para trás. Depois disso, "Qual o seu nome?" é impresso, e o método nextLine() vai ler tudo que estiver no buffer de entrada até encontrar um "\n". Como o nextInt() deixou um "\n" para trás, é esse o valor que o nextLine() lê. Isso conclui a leitura e a próxima linha de código, que é "Qual o seu sobrenome?", é impressa.

//Para resolver esse problema, precisamos "pegar" o "\n" que o nextInt() não lê. Isso pode ser feito colocando um comando nextLine() depois do nextInt(), de modo que o código abaixo vai funcionar da maneira como queríamos.

  //  Scanner teclado2 = new Scanner(System.in);
     
 //       System.out.println("Qual a sua idade?");
 //       int idade3 = teclado2.nextInt();
  //      teclado2.nextLine(); //lê o "\\\\n" que o teclado.nextInt() deixa para trás.
   //     System.out.println("Qual o seu nome?");
   //     String nome3 = teclado2.nextLine();
   //     System.out.println("Qual o seu sobrenome?");
    //    String sobrenome3 = teclado2.nextLine();
     
     //   teclado2.close();
	}
}
