import javax.swing.*;

public class Teste_swing {
    public static void main(String[] args) {
        // Criando o frame (janela)
        JFrame frame = new JFrame("Exemplo de Swing");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Usar layout nulo para posicionar os elementos manualmente


        // Criando um label (texto informativo)
        JLabel label = new JLabel("Digite algo:");
        label.setBounds(50, 50, 100, 30);
        frame.add(label);

        // Criando um campo de texto
        JTextField textField = new JTextField();
        textField.setBounds(150, 50, 150, 30);
        frame.add(textField);

        // Criando um botão
        JButton button = new JButton("Clique aqui!");
        button.setBounds(150, 100, 150, 30);
        frame.add(button);

        // Criando ação para o botão
        button.addActionListener(e -> {
            String texto = textField.getText();
            JOptionPane.showMessageDialog(frame, "Você digitou: " + texto);
        });

        // Tornando a janela visível
        frame.setVisible(true);
    }
}



