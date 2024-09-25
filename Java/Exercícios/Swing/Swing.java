import java.util.*;
import java.util.Scanner;
import java.awt.FlowLayout;
import javax.swing.*;

public class Swing {
    public static void main(String[] args) {

        JFrame janela = new JFrame("Diferença de Valores");
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setSize(600, 600);
        janela.setLayout(new FlowLayout());
        janela.setLocationRelativeTo(null); //Centralizar na tela

        JLabel valor1lbl = new JLabel("Informe um valor:");
        valor1lbl.setBounds(50,50,100,30);
        janela.add(valor1lbl);

        JTextField valor1txt = new JTextField();
        valor1txt.setBounds(150,50,150,30);
        janela.add(valor1txt);

        JButton botao = new JButton("Calcular");
        botao.setBounds(200,2100,150,30);
        janela.add(botao);

        botao.addActionListener(e -> {
            System.out.println("Evento ocorreu!!!");
        });

        janela.setVisible(true);
    }
        /*Scanner s = new Scanner(System.in);
        double numero1 = 0;
        double numero2 = 0;
        boolean validado = false;

        while (!validado) {
            try {
                
                System.out.print("Digite um valor:");
                numero1 = s.nextDouble();
                System.out.print("Digite um valor:");
                numero2 = s.nextDouble();

                if ((numero1 - numero2 > (numero1 * 0.2)) || (numero2 - numero1 > (numero2 * 0.2)) ) {
                    System.out.println("A diferença entre valores é superior a 20%!");
                    System.out.println("Tente novamente:\n");
                } else {
                    System.out.println("Tudo bem com a diferença!");
                    validado = true; 
                }

            } catch (InputMismatchException ex) {
                System.out.println("O valor inserido não é um número inteiro!");
            }
        }
        s.close();
    }*/
}