import javax.swing.*;
import java.awt.*;
public class TestaContainer
{
    public static void main (String args[ ])
    {
        int i;
        JFrame janela = new JFrame("Aula de Orientação a Objetos");
        janela.setBounds(50, 100, 400, 150); // Seta posição e tamanho
        janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        FlowLayout flow = new FlowLayout(); // Define o layout do
        Container caixa = janela.getContentPane(); // Define o tamanho
        caixa.setLayout(flow); // Seta layout do container
        for (i=1; i<=6; i++)
            caixa.add(new JButton("Botão " + i)); // Adiciona um botão
        janela.setVisible(true); // Exibe a janela
    }
}