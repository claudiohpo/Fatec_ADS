import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        try{
            Estacionamento estacionamento = new Estacionamento();
            int opcao;

            System.out.println("*** Estacionamento Oliver's Pine ***\n");

            while (true){
                System.out.println("Menu:");
                System.out.println("1 - Registrar Entrada de Veículos");
                System.out.println("2 - Registrar Saída de Veículos");
                System.out.println("3 - Consultar Veículos Estacionados");
                System.out.println("4 - Histórico de Véiculos");
                System.out.println("5 - Sair");
                System.out.print("\nEscolha uma opção: ");
                try{
                    opcao = teclado.nextInt();
                    teclado.nextLine();

                    switch(opcao){
                        case 1:
                            System.out.println("\n--- Registro de Entrada de Veículo ---");
                            System.out.print("Marca: ");
                            String marca = teclado.nextLine();

                            System.out.print("Modelo: ");
                            String modelo = teclado.nextLine();

                            System.out.print("Cor: ");
                            String cor = teclado.nextLine();

                            System.out.print("Placa: ");
                            String placa = teclado.nextLine();
                            placa = placa.replace("-","");
                            placa = placa.toUpperCase();

                            System.out.print("Nome do motorista: ");
                            String nomeMotorista = teclado.nextLine();

                            Timestamp horarioEntrada = new Timestamp(System.currentTimeMillis());

                            Veiculo veiculo = new Veiculo(marca, modelo, cor, placa, nomeMotorista, horarioEntrada, null);
                            System.out.println("Horário de entrada: " + horarioEntrada); //apagar depois
                            estacionamento.registrarEntrada(veiculo);
                            System.out.println("Entrada registrada com sucesso!");

                            break;

                        case 2:
                            System.out.println("\n--- Registro de Saída de Veículo ---");
                            System.out.print("Placa do veículo: ");
                            String placaSaida = teclado.nextLine();

                            placaSaida = placaSaida.replace("-","");

                            Timestamp horarioSaida = new Timestamp(System.currentTimeMillis());
                            Controle ticket = estacionamento.registrarSaida(placaSaida, horarioSaida);

                            if (ticket != null) {
                                System.out.println("Saída registrada com sucesso!");
                                System.out.println("Custo total: " + ticket.getValorTotal());
//                            } else {
//                                System.out.println("Veículo não encontrado.");
                            }
                            break;

                        case 3:
                            System.out.println("\n--- Consulta de Veículos Estacionados ---\n");
                            List<Veiculo> veiculosEstacionados = estacionamento.consultarVeiculos();

                            if (veiculosEstacionados.isEmpty()) {
                                System.out.println("Não há veículos no estacionamento.");
                            } else {
                                System.out.println("Veículos no estacionamento:");
                                System.out.println("-------------------------------------------------------------------------------------------------");
                                System.out.printf("%-3s %-15s %-15s %-10s %-10s %-20s %-20s%n", "ID", "Marca", "Modelo", "Cor", "Placa", "Motorista", "Hora de Entrada");
                                System.out.println("-------------------------------------------------------------------------------------------------");

                                SimpleDateFormat formatoSimples = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                                for (Veiculo veiculo1: veiculosEstacionados) {
                                    String dataFormatada = formatoSimples.format(veiculo1.getHorarioEntrada());
                                    System.out.printf("%-3s %-15s %-15s %-10s %-10s %-20s %-20s%n",
                                            veiculo1.getId(),
                                            veiculo1.getMarca(),
                                            veiculo1.getModelo(),
                                            veiculo1.getCor(),
                                            veiculo1.getPlaca(),
                                            veiculo1.getNomeMotorista(),
                                            dataFormatada);
                                }
                            }
                            break;

                        case 4:
                            System.out.println("\n--- Histórico de Veículos ---\n");
                            List<Veiculo> veiculosHistorico = estacionamento.consultarVeiculosHistorico();

                            if (veiculosHistorico.isEmpty()) {
                                System.out.println("Não há histórico de veículos no Sistema.");
                            } else {
                                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
                                System.out.printf("| %-3s %-15s %-15s %-10s %-10s %-20s %-20s %-20s %-12s |%n", "ID", "Marca", "Modelo", "Cor", "Placa", "Motorista", "Hora de Entrada", "Hora de Sáida", "Valor");
                                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");

                                SimpleDateFormat formatoSimples = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                                for (Veiculo veiculo2: veiculosHistorico) {
                                    String dataFormatadaEntrada = formatoSimples.format(veiculo2.getHorarioEntrada());
                                    String dataFormatadaSaida = formatoSimples.format(veiculo2.getHorarioSaida());

                                    //double valorTotal = Controle.getValorTotal();
                                    System.out.printf("| %-3s %-15s %-15s %-10s %-10s %-20s %-20s %-20s R$ %-9.2f |%n", //%-8s -> colocar no final coluna valor R$%-8.2f
                                            veiculo2.getId(),
                                            veiculo2.getMarca(),
                                            veiculo2.getModelo(),
                                            veiculo2.getCor(),
                                            veiculo2.getPlaca(),
                                            veiculo2.getNomeMotorista(),
                                            dataFormatadaEntrada,
                                            dataFormatadaSaida,
                                            veiculo2.getValorTotal());
                                }
                                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("\n\n");
                            }
                            break;

                        case 5:
                            System.out.println("Saindo...");
                            teclado.close();
                            System.exit(0);

                        default:
                            System.out.println("Opção Inválida. Tente novamente.");
                            break;
                    }

                } catch (InputMismatchException e){
                    System.out.println("Erro: Entrada Inválida! Por favor insira um número.");
                    teclado.nextLine();
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de SQL: " + e.getMessage());
        }catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }



//        try {
//            Estacionamento estacionamento = new Estacionamento();
//
//
//            Veiculo veiculo = new Veiculo(04, "Volkswagem", "Fusca", "Preto", "CVU0878", "João", new Timestamp(System.currentTimeMillis()), null);
//            estacionamento.registrarEntrada(veiculo);
//
//
//            Controle ticket = estacionamento.registrarSaida("CVU0878", new Timestamp(System.currentTimeMillis() + 2 * 60 * 60 * 1000)); // 2 horas
//            if (ticket != null) {
//                System.out.println("Custo total: " + ticket.getValorTotal());
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}

/* - Criação de programa para entrada e saída de veículos em um estacionamento;

- Um usuário qualquer deverá entrar no estacionamento e ter a sua placa cadastrada. Ela deverá conter: Modelo do
veiculo, cor , placa, nome do motorista, horário de entrada, horário de saida, e foto do veiculo;

- O sistema deverá controlar o período de permanência, emitindo o tíquete correspondente ao número de horas que o
veiculo permanecer no estacionamento;

- O sistema devera cobrar o estacionamento por hora;*/