import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame {

    private JPanel MainPanel;
    private JButton btn_7;
    private JButton btn_8;
    private JButton btn_9;
    private JButton btn_div;
    private JButton btn_sub;
    private JButton btn_soma;
    private JButton btn_igual;
    private JButton btn_multi;
    private JButton btn_limpar;
    private JButton btn_6;
    private JButton btn_5;
    private JButton btn_4;
    private JButton btn_1;
    private JButton btn_2;
    private JButton btn_3;
    private JButton btn_0;
    private JTextPane visor;

    private double numero1 = 0;
    private double numero2 = 0;
    private String operador = "";

    public Calculadora(){
        setContentPane(MainPanel);
        setTitle("Calculadora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,400);
        setLocationRelativeTo(null);
        setVisible(true);

        //Forma não simplificada das instruções dos botões numéricos
        /*btn_0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "0");
            }
        });

        btn_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "1");
            }
        });

        btn_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "2");
            }
        });

        btn_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "3");
            }
        });

        btn_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "4");
            }
        });

        btn_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "5");
            }
        });

        btn_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "6");
            }
        });

        btn_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "7");
            }
        });

        btn_8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "8");
            }
        });

        btn_9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visor.setText(visor.getText() + "9");
            }
        });*/

        //Forma simplificada das instruções dos botões numéricos
        btn_0.addActionListener(e -> visor.setText(visor.getText() + "0"));
        btn_1.addActionListener(e -> visor.setText(visor.getText() + "1"));
        btn_2.addActionListener(e -> visor.setText(visor.getText() + "2"));
        btn_3.addActionListener(e -> visor.setText(visor.getText() + "3"));
        btn_4.addActionListener(e -> visor.setText(visor.getText() + "4"));
        btn_5.addActionListener(e -> visor.setText(visor.getText() + "5"));
        btn_6.addActionListener(e -> visor.setText(visor.getText() + "6"));
        btn_7.addActionListener(e -> visor.setText(visor.getText() + "7"));
        btn_8.addActionListener(e -> visor.setText(visor.getText() + "8"));
        btn_9.addActionListener(e -> visor.setText(visor.getText() + "9"));

        btn_soma.addActionListener(e -> {
            numero1 = Double.parseDouble(visor.getText());
            operador = "+";
            visor.setText("");
        });

        btn_sub.addActionListener(e -> {
            numero1 = Double.parseDouble(visor.getText());
            operador = "-";
            visor.setText("");
        });

        btn_multi.addActionListener(e -> {
            numero1 = Double.parseDouble(visor.getText());
            operador = "*";
            visor.setText("");
        });

        btn_div.addActionListener(e -> {
            numero1 = Double.parseDouble(visor.getText());
            operador = "/";
            visor.setText("");
        });

        btn_limpar.addActionListener(e -> visor.setText(""));

        btn_igual.addActionListener(e -> {
            numero2 = Double.parseDouble(visor.getText());
            switch (operador) {
                case "+" -> visor.setText(String.valueOf(numero1 + numero2));
                case "-" -> visor.setText(String.valueOf(numero1 - numero2));
                case "*" -> visor.setText(String.valueOf(numero1 * numero2));
                case "/" -> visor.setText(numero2 != 0 ? String.valueOf(numero1 / numero2) : "Erro!!!  Divisão por Zero.");
                default -> visor.setText("Erro");
            }
        });
    }

    public static void main(String[] args){
        new Calculadora();
    }
}
