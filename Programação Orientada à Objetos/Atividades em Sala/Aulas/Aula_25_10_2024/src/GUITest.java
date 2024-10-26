import javax.swing.*;

public class GUITest {
    // Objeto Janela
    public static void main (String args[])
    {
        JFrame janela = new JFrame("Título da janela");
        janela.setBounds(50, 100, 400, 150); // Seta posicao e tamanho
        janela.setDefaultCloseOperation( WindowConstants.
                DISPOSE_ON_CLOSE);
        janela.setVisible(true); // Exibe a janela
    }
}