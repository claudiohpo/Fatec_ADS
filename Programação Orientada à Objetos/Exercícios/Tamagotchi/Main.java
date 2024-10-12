package Tamagotchi;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            String nome = JOptionPane.showInputDialog(null, "Escolha um nome para seu bichinho:", "Nome do Bichinho", JOptionPane.QUESTION_MESSAGE);
            if (nome == null || nome.trim().isEmpty()) {
                throw new IllegalArgumentException("Nome não pode ser vazio.");
            }

            String classe = JOptionPane.showInputDialog(null, "Informe a classe do bichinho:", "Classe do Bichinho", JOptionPane.QUESTION_MESSAGE);
            if (classe == null || classe.trim().isEmpty()) {
                throw new IllegalArgumentException("Classe não pode ser vazia.");
            }

            String familia = JOptionPane.showInputDialog(null, "Informe a família do bichinho:", "Família do Bichinho", JOptionPane.QUESTION_MESSAGE);
            if (familia == null || familia.trim().isEmpty()) {
                throw new IllegalArgumentException("Família não pode ser vazia.");
            }

            Animais animal = new Animais(nome, classe, familia);
            new Tela(animal);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
}
