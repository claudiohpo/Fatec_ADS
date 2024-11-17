import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame {
    private JLabel lbl_titulo;
    private JTextField txt_numCNAE;
    private JButton btn_pesquisar;
    private JPanel Inicial;
    private JLabel lbl_subClasse;
    private JLabel lbl_secao;
    private JLabel lbl_divisao;
    private JLabel lbl_grupo;
    private JLabel lbl_classe;
    private JLabel lbl_secaoCod;
    private JLabel lbl_divisaoCod;
    private JLabel lbl_grupoCod;
    private JLabel lbl_classeCod;
    private JLabel lbl_subClasseCod;
    private JLabel lbl_atividades;

    public TelaInicial() {

        setTitle("Consulta CNAE");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(Inicial);

        btn_pesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Limitação para entrada de somente numeros, desprezando qualquer outro caracter inserido
                String numCNAE = txt_numCNAE.getText().replaceAll("[^0-9]","");
                try{
                    Cnae cnae = CnaeEngine.consultarCnae(numCNAE);

                    lbl_atividades.setText("<html>" + cnae.getAtividades()  + "</html>");

                    lbl_secao.setText("<html>" + cnae.getDescricaoSecao() + "</html>");
                    lbl_secaoCod.setText(cnae.getCodigoSecao());

                    lbl_divisao.setText("<html>" + cnae.getDescricaoDivisao() + "</html>");
                    lbl_divisaoCod.setText(cnae.getCodigoDivisao());

                    lbl_grupo.setText("<html>" + cnae.getDescricaoGrupo() + "</html>");
                    lbl_grupoCod.setText(cnae.getCodigoGrupo());

                    lbl_classe.setText("<html>" + cnae.getDescricaoClasse() + "</html>");
                    lbl_classeCod.setText(cnae.getCodigoClasse());

                    lbl_subClasse.setText("<html>" + cnae.getDescricaoSubclasse() + "</html>");
                    lbl_subClasseCod.setText(cnae.getCodigoSubclasse());

                }catch (Exception ex){
                    lbl_subClasse.setText("Erro ao consultar CNAE: " + ex.getMessage());
                }
            }
        });
    }
}