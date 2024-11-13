import javax.swing.*;
import java.sql.SQLException;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        new TelaInicial();

        try{
            Estacionamento estacionamento = new Estacionamento();
        }catch (InputMismatchException e){
            System.out.println("Erro: Entrada Inválida! Por favor insira um número.");
            //JOptionPane.showMessageDialog( "Horário de entrada: " + horarioEntrada +"\nEntrada registrada com sucesso!");
        }catch (SQLException e){
            System.out.println("Erro de SQL: " + e.getMessage());
        }catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}



////Código SQL
//CREATE TABLE IF NOT EXISTS `estacionamento`.`veiculos` (
//        `id` INT NOT NULL AUTO_INCREMENT,
//  `marca` VARCHAR(50) NULL DEFAULT NULL,
//  `modelo` VARCHAR(100) NULL DEFAULT NULL,
//  `cor` VARCHAR(45) NULL DEFAULT NULL,
//  `placa` VARCHAR(7) NULL DEFAULT NULL,
//  `nomeMotorista` VARCHAR(100) NULL DEFAULT NULL,
//  `horarioEntrada` VARCHAR(30) NULL DEFAULT NULL,
//  `horarioSaida` VARCHAR(30) NULL DEFAULT NULL,
//  `valorTotal` FLOAT NULL DEFAULT NULL,
//  `fotoVeiculo` MEDIUMBLOB NULL DEFAULT NULL,
//PRIMARY KEY (`id`),
//UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
//ENGINE = InnoDB
//        AUTO_INCREMENT = 48
//DEFAULT CHARACTER SET = utf8mb4
//        COLLATE = utf8mb4_0900_ai_ci





/*import java.sql.SQLException;
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
                System.out.println("4 - Histórico de Veículos");
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

                            Veiculo ticket = estacionamento.registrarSaida(placaSaida, horarioSaida);

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
                                System.out.println("------------------------------------------------------------------------------------------------------");
                                System.out.printf("| %-3s %-15s %-15s %-10s %-10s %-20s %-19s |%n", "ID", "Marca", "Modelo", "Cor", "Placa", "Motorista", "Hora de Entrada");
                                System.out.println("------------------------------------------------------------------------------------------------------");

                                SimpleDateFormat formatoSimples = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                                for (Veiculo veiculo1: veiculosEstacionados) {
                                    String dataFormatada = formatoSimples.format(veiculo1.getHorarioEntrada());
                                    System.out.printf("| %-3s %-15s %-15s %-10s %-10s %-20s %-19s |%n",
                                            veiculo1.getId(),
                                            veiculo1.getMarca(),
                                            veiculo1.getModelo(),
                                            veiculo1.getCor(),
                                            veiculo1.getPlaca(),
                                            veiculo1.getNomeMotorista(),
                                            dataFormatada);
                                }
                                System.out.println("------------------------------------------------------------------------------------------------------");
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

                                    String dataFormatadaSaida;
                                    if (veiculo2.getHorarioSaida() != null) {
                                        dataFormatadaSaida = formatoSimples.format(veiculo2.getHorarioSaida());
                                    } else {
                                        dataFormatadaSaida = "";
                                    }


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
    }
}*/