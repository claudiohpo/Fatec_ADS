import javax.swing.*;

public class Ajuda extends JFrame {
    private JPanel Ajuda;
    private JButton btn_ok;
    private JLabel lbl_descricao;

    public Ajuda(){

        setTitle("Ajuda");
        setSize(380, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(Ajuda);

        String textoAjuda = "<html><div style='text-align: center;'>Este sistema de busca permite:<br><br>" +
                "Pesquisar códigos de atividades econômicas na CNAE.<br><br>" +
                "O usuário pode encontrar, a partir da digitação do código da subclasses CNAE (7 dígitos) e " +
                "obter sua Classe, Grupo, Divisão e Seção, bem como suas descrições.</div></html>";

        lbl_descricao.setText(textoAjuda);

        btn_ok.addActionListener(e -> dispose());
    }
}