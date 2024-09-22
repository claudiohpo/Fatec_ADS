/*
Neste trabalho, vocês deverão criar um programa em Java que use de HERANÇA para 
a passagem de parâmetros. É um sistema que calcula pontos para um programa de fidelidade de viagens. 
Neste programa de fidelidade, o passageiro ganha pontos de acordo com o meio de transporte que ele 
usa e o tipo de acomodação.
 
Logo, temos:

Modal			Standart	Luxo 
Aereo			1000		2500
Rodoviario		500			1000
Ferroviario		2500		5000

Os dados que devem constar do passageiro são:
Codigo viagem, Nome, CPF, Data de Nascimento, Data da Viagem, Modal, Tipo (Standart ou Luxo).
O programa deverá calcular quantos pontos o usuario acumulou durante 1 ano e apresentar na tela.
*/

//package Viagem; //Ativar para usar no Eclipse

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe o nome do Passageiro: ");
        String nome = entrada.nextLine();

        System.out.println("Informe o numero do CPF: ");
        String cpf = entrada.nextLine();

        System.out.println("Informe a data de nascimento: ");
        String dataNasc = entrada.nextLine();

        System.out.println("Informe a data da viagem: ");
        String dataViagem = entrada.nextLine();

        System.out.println("Escolha o tipo de viagem (1- Aéreo; 2- Rodoviário; 3- Ferroviário)");
        int tipoModal = entrada.nextInt();

        System.out.println("Escolha a categoria (1- Standart; 2- Luxo)");
        int tipoCategoria = entrada.nextInt();

        Passageiro passageiro = new Passageiro(nome, cpf, dataNasc, dataViagem, tipoModal, tipoCategoria);
        Fidelidade fidelidade = new Fidelidade();
        int pontos = fidelidade.calcularPontos(passageiro);

        System.out.println("O passageiro " + passageiro.getNome() + " acumulou " + pontos * 12 + " pontos em 1 ano.");

        entrada.close();
    }
}

class Passageiro{
    
    private String nome;
    private String cpf;
    private String dataNasc;
    private String dataViagem;
    private int modal;
    private int categoria;

    public Passageiro( String nome, String cpf, String dataNasc, String dataViagem, int modal, int categoria) {
       
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.dataViagem = dataViagem;
        this.modal = modal;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public int getModal() {
        return modal;
    }

    public int getCategoria() {
        return categoria;
    }
}

class Modal{
    public int calcularPontos(int categoria, int pontosStd, int pontosLuxo) {
        if (categoria == 1) {
            return pontosStd;
        } else {
            return pontosLuxo;
        }
    }

    public int calcularPontos(int categoria) {
        return 0;
    }
}

class Aereo extends Modal{
    private int pontosStd = 1000;
    private int pontosLuxo = 2500;

    public int calcularPontos(int categoria) {
        return super.calcularPontos(categoria, pontosStd, pontosLuxo);
    }
}

class Rodoviario extends Modal{
    private int pontosStd = 500;
    private int pontosLuxo = 1000;

    public int calcularPontos(int categoria) {
        return super.calcularPontos(categoria, pontosStd, pontosLuxo);
    }
}

class Ferroviario extends Modal{
    private int pontosStd = 2500;
    private int pontosLuxo = 5000;

    public int calcularPontos(int categoria) {
        return super.calcularPontos(categoria, pontosStd, pontosLuxo);
    }
}

class Fidelidade{
    public int calcularPontos(Passageiro passageiro) {
        Modal modal;
        switch (passageiro.getModal()) {
            case 1:
                modal = new Aereo();
                break;
            case 2:
                modal = new Rodoviario();
                break;
            case 3:
                modal = new Ferroviario();
                break;
            default:
                System.out.println("Opção Inválida");
                return 0;
        }
        return modal.calcularPontos(passageiro.getCategoria());
    }
}