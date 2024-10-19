package Atividades_18_Outubro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Carta {
    private String cor;
    private int numero;

    public Carta(String cor, int numero) {
        this.cor = cor;
        this.numero = numero;
    }

    public String getCor() {
        return cor;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return cor + " " + numero;
    }
}

public class JogoCartas {
    private List<Carta> baralho;
    private List<Carta> mesa;
    private List<List<Carta>> maosJogadores;
    private int numeroJogadores;

    public JogoCartas(int numeroJogadores) {
        this.numeroJogadores = numeroJogadores;
        this.baralho = new ArrayList<>();
        this.mesa = new ArrayList<>();
        this.maosJogadores = new ArrayList<>();
        inicializarBaralho();
    }

    private void inicializarBaralho() {
        String[] cores = {"Vermelho", "Azul", "Verde", "Amarelo"};
        for (String cor : cores) {
            for (int numero = 0; numero <= 9; numero++) {
                baralho.add(new Carta(cor, numero));
            }
        }
    }

    public void embaralhar() {
        Collections.shuffle(baralho);
        System.out.println("Baralho embaralhado.");
    }

    public void distribuirCartas() {
        for (int i = 0; i < numeroJogadores; i++) {
            List<Carta> mao = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                mao.add(baralho.remove(0));
            }
            maosJogadores.add(mao);
        }
        mesa.add(baralho.remove(0));
        System.out.println("Cartas distribuídas aos jogadores.");
    }

    public void exibirMaosJogadores() {
        for (int i = 0; i < numeroJogadores; i++) {
            System.out.println("Jogador " + (i + 1) + ": " + maosJogadores.get(i));
        }
    }

    public void exibirCartaMesa() {
        System.out.println("Carta na mesa: " + mesa.get(mesa.size() - 1));
    }

    public void jogar(int jogador) {
        List<Carta> mao = maosJogadores.get(jogador);
        Carta cartaNaMesa = mesa.get(mesa.size() - 1);
        boolean jogou = false;

        for (Carta carta : mao) {
            if (carta.getCor().equals(cartaNaMesa.getCor()) || carta.getNumero() == cartaNaMesa.getNumero()) {
                mesa.add(carta);
                mao.remove(carta);
                System.out.println("Jogador " + (jogador + 1) + " jogou: " + carta);
                jogou = true;
                break;
            }
        }

        if (!jogou) {
            System.out.println("Jogador " + (jogador + 1) + " não tinha carta compatível e comprou uma carta.");
            mao.add(baralho.remove(0));
        }
    }

    public boolean verificarVencedor() {
        for (int i = 0; i < numeroJogadores; i++) {
            if (maosJogadores.get(i).isEmpty()) {
                System.out.println("Jogador " + (i + 1) + " venceu!");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JogoCartas jogo = new JogoCartas(3);

        jogo.embaralhar();
        jogo.distribuirCartas();
        jogo.exibirMaosJogadores();
        jogo.exibirCartaMesa();

        int turno = 0;
        while (!jogo.verificarVencedor()) {
            System.out.println("\nTurno do Jogador " + (turno + 1));
            jogo.jogar(turno);
            jogo.exibirCartaMesa();
            turno = (turno + 1) % 3;
        }
    }
}