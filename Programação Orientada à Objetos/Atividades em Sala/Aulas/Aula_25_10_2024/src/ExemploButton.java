import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExemploButton extends JFrame {

    private JButton botao1, botao2, botao3, botao4;
    private Icon cafe = new ImageIcon("java.jpg");
    private String strIcone = "botão associado a uma imagem";
    private String strFinalizar = "Finalizar";
    private String strNovaJanela = "Abrir nova Janela";
    private String strEsconder = "Esconder botões";

    // Configura a GUI
    public ExemploButton() {
        super("Testando Botões");

        // Cria o container e atribui o layout
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        // Cria os botões
        botao1 = new JButton("Botão Java", cafe);
        botao1.setIcon(cafe);
        botao1.setToolTipText("Pressione o botão"); //Balao aparece ao passar o mouse em cima
        botao1.setActionCommand(strIcone);
        container.add(botao1);

        botao2 = new JButton(strFinalizar);
        botao2.setToolTipText("Finaliza o programa");
        container.add(botao2);

        botao3 = new JButton("Nova Janela");
        botao3.setToolTipText("Abrir Nova Janela");
        botao3.setActionCommand(strNovaJanela);
        container.add(botao3);

        botao4 = new JButton("Invisivel");
        botao4.setToolTipText("Esconder outros botões");
        botao4.setActionCommand(strEsconder);
        container.add(botao4);

        // Cria o objeto gestorBotoes (instância da classe interna   ButtonHandler)
        // para o uso no tratamento de eventos de botão
        GerenciadorBotoes gestorBotoes = new GerenciadorBotoes();
        botao1.addActionListener(gestorBotoes);
        botao2.addActionListener(gestorBotoes);
        botao3.addActionListener(gestorBotoes);
        botao4.addActionListener(gestorBotoes);

        setSize(545, 280);
        setVisible(true);
    }

    // Método principal
    public static void main(String args[]) {

        ExemploButton application = new ExemploButton();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Classe interna para tratamento de evento de botão
    private class GerenciadorBotoes implements ActionListener {
        // Método de manipulação do evento

        public void actionPerformed(ActionEvent event) {
            //Testa se o botão com a imagem foi pressionado
            if (event.getActionCommand().equalsIgnoreCase(strIcone)) {
                JOptionPane.showMessageDialog(null,"Você pressionou um " + event.getActionCommand());
            } else if (event.getActionCommand().equalsIgnoreCase(strNovaJanela)) {
                JOptionPane.showMessageDialog(null,"Criei uma nova Janela!");
            } else if (event.getActionCommand().equalsIgnoreCase(strEsconder)) {
                JOptionPane.showMessageDialog(null, "Botões Ocultos!" );
                botao1.setVisible(false);
                botao3.setVisible(false);
                botao4.setVisible(false);
            } //Testa se o botão "Finalizar" foi pressionado
            else if (event.getActionCommand().equalsIgnoreCase(strFinalizar)) {
                System.exit(0);
            }
        }
    } // fim da classe interna GerenciadorBotoes

} // fim da classe ExemploButton