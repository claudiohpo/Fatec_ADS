import javax.swing.*;

public class Divisao {
    public static void main(String[] args) {

        JFrame janela = new JFrame("Divisão de 2 números");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(300, 200);
        janela.setLayout(null);
        janela.setLocationRelativeTo(null); //Centralizar na tela

        JLabel lbl_titulo = new JLabel("Informe 2 número para o cálculo!!!!");
        lbl_titulo.setBounds(40, 5, 200, 30);
        janela.add(lbl_titulo);

        JLabel lbl_valor1 = new JLabel("Digite o 1º núm:");
        lbl_valor1.setBounds(15, 40, 120, 30);
        janela.add(lbl_valor1);

        JTextField txt_valor1 = new JTextField();
        txt_valor1.setBounds(125, 40, 150, 30);
        janela.add(txt_valor1);

        JLabel lbl_valor2 = new JLabel("Digite o 2º núm:");
        lbl_valor2.setBounds(15, 80, 120, 30);
        janela.add(lbl_valor2);

        JTextField txt_valor2 = new JTextField();
        txt_valor2.setBounds(125, 80, 150, 30);
        janela.add(txt_valor2);

        JButton btn_calcular = new JButton("Calcular");
        btn_calcular.setBounds(95, 120, 100, 30);
        janela.add(btn_calcular);

        btn_calcular.addActionListener(e -> {
            float resultado = 0;
            try {
                float numero1 = Float.parseFloat(txt_valor1.getText());
                float numero2 = Float.parseFloat(txt_valor2.getText());

                if(numero2 == 0){
                    throw new ArithmeticException("Divisão por 0 (zero) não permitida!");
                }
                resultado = numero1 / numero2;

                JOptionPane.showMessageDialog(janela, "Resultado: " + resultado);
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(janela, "O valor inserido não é um número válido!");
                janela.setVisible(true);
            }
            catch (ArithmeticException ex){
                JOptionPane.showMessageDialog(janela, ex.getMessage());
                janela.setVisible(true);
            }
        });
        janela.setVisible(true);
    }
}