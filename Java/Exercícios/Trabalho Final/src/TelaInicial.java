import javax.swing.*;
import java.sql.SQLException;

public class TelaInicial extends JFrame {

    private JPanel Inicial;
    private JButton btn_incluir;
    private JButton btn_alterar;
    private JButton btn_saida;
    private JButton btn_historico;
    private JLabel lbl_Titulo;


    public TelaInicial() {

        setTitle("Tela Inicial");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(Inicial);

        btn_incluir.addActionListener(e -> {
            IncluirVeiculo incluirVeiculo = null;
            try {
                incluirVeiculo = new IncluirVeiculo();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            incluirVeiculo.setVisible(true);
        });

        btn_saida.addActionListener(e -> {
            SaidaVeiculo saidaVeiculo = null;
            try{
                saidaVeiculo = new SaidaVeiculo();
            }catch (SQLException ex){
                throw new RuntimeException(ex);
            }
            saidaVeiculo.setVisible(true);
        });

        btn_alterar.addActionListener(e -> {
            EditarVeiculo editarVeiculo = null;
            try{
                editarVeiculo = new EditarVeiculo();
            }catch (SQLException ex){
                throw new RuntimeException(ex);
            }
            editarVeiculo.setVisible(true);
        });

        btn_historico.addActionListener(e -> {
            HistoricoVeiculo historicoVeiculo = null;
            try{
                historicoVeiculo = new HistoricoVeiculo();
            }catch (SQLException ex){
                throw new RuntimeException(ex);
            }
            historicoVeiculo.setVisible(true);
        });
    }
}
