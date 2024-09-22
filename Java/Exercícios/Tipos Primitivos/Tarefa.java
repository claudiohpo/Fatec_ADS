import java.util.Scanner;

public class Tarefa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Informações de funcionários
        // Tipos Numéricos inteiros
        System.out.print("Informe quanto tempo em anos que está na empresa: ");
        byte anosdeEmpresa = scanner.nextByte();

        System.out.print("Informe a quantidade de voos realizados: ");
        short numerodeVoos = scanner.nextShort();

        System.out.print("Informe o ID do funcionário: ");
        int id = scanner.nextInt();

        System.out.print("Informe a quantidade de pontos acumulados: ");
        long pontosAcumulados = scanner.nextLong();

        // Tipos Numéricos reais
        System.out.print("Informe o salário base: ");
        float salario = scanner.nextFloat();

        System.out.print("Informe o valor de vendas acumuladas: ");
        double vendasAcumuladas = scanner.nextDouble();

        System.out.print("O funcionário está de férias (true/false)? ");
        boolean ferias = scanner.nextBoolean();

        System.out.print("Digite o status do funcionário (A para ativo, I para inativo): ");
        char a = scanner.next().charAt(0); 

        // Dias de Empresa
        System.out.println("Dias de empresa: " + (anosdeEmpresa * 365));

        // Número de viagens
        System.out.println("Número de viagens por ano: " + (numerodeVoos / 2));

        // Pontos Acumulados
        System.out.println("Pontos por vendas: " + (pontosAcumulados / vendasAcumuladas));

        // Quanto ganha
        System.out.println(id + " ganha --> R$" + salario);
        System.out.println(id + " de Férias? " + ferias);
        System.out.println(id + " Qual Status? " + a);

        scanner.close();
    }
}
