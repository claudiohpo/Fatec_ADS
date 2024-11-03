import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        try {
            Estacionamento estacionamento = new Estacionamento();

            // Exemplo de registro de entrada
            Veiculo veiculo = new Veiculo(04, "Volkswagem", "Fusca", "Preto", "CVU0878", "João", new Timestamp(System.currentTimeMillis()), null);
            estacionamento.registrarEntrada(veiculo);

            // Exemplo de registro de saída
            Controle ticket = estacionamento.registrarSaida("CVU0878", new Timestamp(System.currentTimeMillis() + 2 * 60 * 60 * 1000)); // 2 horas depois
            if (ticket != null) {
                System.out.println("Custo total: " + ticket.getValorTotal());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


/*public class Main {
    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);

        System.out.println("*** Estacionamento Oliver`s Pine ***\n\n");

        while(true){
            System.out.println("Pressione o número correspondente para navegar no menu:");
            System.out.println("1 - Entrada de Veículo");
            System.out.println("2 - Saída de Veículo");
            System.out.println("3 - Consulta de Veículos Estacionados");
            System.out.println("4 - Sair");

            int opcao = menu.nextInt();

            switch (opcao) {
                case 1:
                    //Controle.MostrarTabela();
                    break;

                case 2:
                    //Calculo.MostrarDados();
                    break;

                case 3:
                    System.out.println("Saindo...");
                    menu.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção Inválida. Tente novamente.");
        }
    }
}

/* - Criação de programa para entrada e saída de veículos em um estacionamento;

- Um usuário qualquer deverá entrar no estacionamento e ter a sua placa cadastrada. Ela deverá conter: Modelo do
veiculo, cor , placa, nome do motorista, horário de entrada, horário de saida, e foto do veiculo;

- O sistema deverá controlar o período de permanência, emitindo o tíquete correspondente ao número de horas que o
veiculo permanecer no estacionamento;

- O sistema devera cobrar o estacionamento por hora;*/