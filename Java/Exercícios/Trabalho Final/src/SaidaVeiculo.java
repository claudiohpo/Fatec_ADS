import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

public class SaidaVeiculo extends JFrame {
    private JPanel Saida;
    private JTable table1;
    private JButton btn_cancelar;
    private JButton btn_saida;
    private JTextField txt_placa;
    private JLabel lbl_foto;
    private List<Veiculo> veiculos;

    public SaidaVeiculo() throws SQLException {
        setContentPane(Saida);
        setTitle("Incluir Veículo");
        setSize(900, 600);
        setLocationRelativeTo(null);
        preencherTabela();

        AjusteFoto.configurarSelecaoImagem(table1, lbl_foto,veiculos);

        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int linhaSelecionada = table1.getSelectedRow();
                    String placa = (String) table1.getValueAt(linhaSelecionada, 4);
                    txt_placa.setText(placa);
                }
            }
        });

        btn_cancelar.addActionListener(e ->{
            dispose();
        });

        btn_saida.addActionListener(e -> {
           String placa = txt_placa.getText().toUpperCase().replace("-","");

           if (placa.isEmpty() || placa.isBlank()) {
               JOptionPane.showMessageDialog(this, "Por favor, insira a placa do veículo.");
               return;
           }

           try{

               Timestamp timestamp = new Timestamp(System.currentTimeMillis());

               Estacionamento estacionamento = new Estacionamento();

               Veiculo veiculo = estacionamento.registrarSaida(placa, timestamp);

               if (veiculo != null) {
                   JOptionPane.showMessageDialog(this, "Saída registrada com sucesso!\nValor total: R$" + veiculo.getValorTotal());
                   preencherTabela();
               }else{
                   JOptionPane.showMessageDialog(this, "Veículo não encontrado ou já saiu.");
               }
           }catch(SQLException ex){
               JOptionPane.showMessageDialog(this, "Erro ao registrar a saída: " + ex.getMessage());
            }
        });
    }

    private void preencherTabela() throws SQLException{
        Estacionamento estacionamento = new Estacionamento();
        veiculos = estacionamento.consultarVeiculos();

        String[] colunas = {"ID","Marca", "Modelo", "Cor", "Placa", "Nome", "Horario de Entrada", "Foto"};
        Object[][] dados = new Object[veiculos.size()][colunas.length];

        SimpleDateFormat formatoSimples = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        for(int i = 0; i < veiculos.size(); i++){
            dados[i][0] = veiculos.get(i).getId();
            dados[i][1] = veiculos.get(i).getMarca();
            dados[i][2] = veiculos.get(i).getModelo();
            dados[i][3] = veiculos.get(i).getCor();
            dados[i][4] = veiculos.get(i).getPlaca();
            dados[i][5] = veiculos.get(i).getNomeMotorista();
            dados[i][6] = formatoSimples.format(veiculos.get(i).getHorarioEntrada());
            if(veiculos.get(i).getFotoVeiculo() != null){
                dados[i][7] = "OK";
            }else{
                dados[i][7] = "-";
            }
        }

        table1.setModel(new DefaultTableModel(dados, colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 7) {
                    return String.class;
                }
                return String.class;
            }
        });

        txt_placa.setText("");

        AjusteColunaTabelas tca = new AjusteColunaTabelas(table1);
        tca.adjustColumns();
    }
}