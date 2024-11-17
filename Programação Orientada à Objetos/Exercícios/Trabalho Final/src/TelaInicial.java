import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame {
    private JLabel lbl_titulo;
    private JTextField txt_numCNAE;
    private JButton btn_pesquisar;
    private JPanel Inicial;
    private JLabel lbl_retorno;

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
                String numCNAE = txt_numCNAE.getText().trim();
                try{
                    Cnae cnae = CnaeEngine.consultarCnae(numCNAE);
                    lbl_retorno.setText("Atividade: " + cnae.getDescricao());
                }catch (Exception ex){
                    lbl_retorno.setText("Erro ao consultar CNAE: " + ex.getMessage());
                }
            }
        });


    }
}
