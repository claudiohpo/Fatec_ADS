import javax.swing.*;

public class Swing {
    public static void main(String[] args) {

        JFrame janela = new JFrame("Diferença de Valores");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(300, 200);
        janela.setLayout(null);
        janela.setLocationRelativeTo(null); //Centralizar na tela

        JLabel lbl_titulo = new JLabel("Diferença de Valores");
        lbl_titulo.setBounds(85, 5, 150, 30);
        janela.add(lbl_titulo);

        JLabel lbl_valor1 = new JLabel("Informe o 1º valor:");
        lbl_valor1.setBounds(15, 40, 120, 30);
        janela.add(lbl_valor1);

        JTextField txt_valor1 = new JTextField();
        txt_valor1.setBounds(125, 40, 150, 30);
        janela.add(txt_valor1);

        JLabel lbl_valor2 = new JLabel("Informe o 2º valor:");
        lbl_valor2.setBounds(15, 80, 120, 30);
        janela.add(lbl_valor2);

        JTextField txt_valor2 = new JTextField();
        txt_valor2.setBounds(125, 80, 150, 30);
        janela.add(txt_valor2);

        JButton btn_calcular = new JButton("Calcular");
        btn_calcular.setBounds(95, 120, 100, 30);
        janela.add(btn_calcular);

        btn_calcular.addActionListener(e -> {
            janela.setVisible(false);
            try {
                int numero1 = Integer.parseInt(txt_valor1.getText());
                int numero2 = Integer.parseInt(txt_valor2.getText());

                if ((numero1 - numero2 > (numero1 * 0.2)) || (numero2 - numero1 > (numero2 * 0.2))) {
                    JOptionPane.showMessageDialog(janela, """
                            A diferença entre valores é superior a 20%!

                                           Tente Novamente!""");
                    janela.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(janela, "Tudo bem com a diferença!");
                    txt_valor1.setText("");
                    txt_valor2.setText("");
                    janela.setVisible(true);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(janela, "O valor inserido não é um número inteiro!");
                janela.setVisible(true);
            }
        });
        janela.setVisible(true);
    }
}