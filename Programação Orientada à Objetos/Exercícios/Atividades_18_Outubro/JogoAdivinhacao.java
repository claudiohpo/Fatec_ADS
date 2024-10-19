package Atividades_18_Outubro;

import java.util.Random;

class JogoAdivinhacao {
    private int numeroGerado;
    private Random random;

    public JogoAdivinhacao() {
        random = new Random();
        numeroGerado = random.nextInt(100) + 1;
    }

    public String fazerPalpite(int palpite) {
        if (palpite < numeroGerado) {
            return "O palpite é menor.";
        } else if (palpite > numeroGerado) {
            return "O palpite é maior.";
        } else {
            return "Parabéns! Você acertou!";
        }
    }

    public int getNumeroGerado() {
        return numeroGerado;
    }

    public static void main(String[] args) {
        JogoAdivinhacao jogo = new JogoAdivinhacao();
        System.out.println("Número gerado (para teste): " + jogo.getNumeroGerado());
        System.out.println(jogo.fazerPalpite(50));
        System.out.println(jogo.fazerPalpite(75));

        //Exemplo só pra mostrar como é a resposta quando acerta o numero
        System.out.println(jogo.fazerPalpite(jogo.getNumeroGerado()));
    }
}