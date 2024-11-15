import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class EditarVeiculo extends JFrame {
    private JTable table1;
    private JButton btn_cancelar;
    private JButton btn_alterar;
    private JPanel Editar;
    private JLabel lbl_foto;
    private JButton btn_deletar;
    private List<Veiculo> veiculos;

    public EditarVeiculo() throws SQLException {
        setContentPane(Editar);
        setTitle("Consulta e Alterações de Veículos");
        setSize(900, 600);
        setLocationRelativeTo(null);
        preencherTabela();

        AjusteFoto.configurarSelecaoImagem(table1, lbl_foto,veiculos);

        btn_cancelar.addActionListener(e -> dispose());

        btn_alterar.addActionListener(e -> {
            int linhaSelecionada = table1.getSelectedRow();

            if (linhaSelecionada >= 0) {
                int id = Integer.parseInt(table1.getValueAt(linhaSelecionada, 0).toString());
                String marca = table1.getValueAt(linhaSelecionada, 1).toString().toUpperCase();
                String modelo = table1.getValueAt(linhaSelecionada, 2).toString().toUpperCase();
                String cor = table1.getValueAt(linhaSelecionada, 3).toString().toUpperCase();
                String placa = table1.getValueAt(linhaSelecionada, 4).toString().toUpperCase().replace("-", "");
                String nomeMotorista = table1.getValueAt(linhaSelecionada, 5).toString().toUpperCase();

                Veiculo veiculoAlterado = new Veiculo(id, marca, modelo, cor, placa, nomeMotorista);

                try {
                    Estacionamento estacionamento = new Estacionamento();
                    estacionamento.atualizarVeiculo(id, veiculoAlterado);
                    JOptionPane.showMessageDialog(this, "Veículo alterado com sucesso!");
                    preencherTabela();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao alterar Veículo");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma linha para alterar o cadastro.");
            }
        });

        btn_deletar.addActionListener(e ->{
            int linhaSelecionada = table1.getSelectedRow();

            if(linhaSelecionada >= 0 ){
                int id = Integer.parseInt(table1.getValueAt(linhaSelecionada,0).toString());

                int balaoConfirmacao = JOptionPane.showConfirmDialog(this,
                        "Tem certeza que deseja excluir esse veículo do Sistema?",
                        "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);

                if(balaoConfirmacao == JOptionPane.YES_OPTION){
                    try{
                        Estacionamento estacionamento = new Estacionamento();
                        estacionamento.excluirVeiculo(id);
                        JOptionPane.showMessageDialog(this, "Veículo excluído com Sucesso!");
                        preencherTabela();
                    }catch (SQLException ex){
                        JOptionPane.showMessageDialog(this,"Erro ao excluir veículo.");
                    }
                }
            }else{
                JOptionPane.showMessageDialog(this, "Você deve selecionar uma linha para excluir o veículo.");
            }
        });
    }

    private void preencherTabela() throws SQLException {
        Estacionamento estacionamento = new Estacionamento();
        veiculos = estacionamento.consultarVeiculos();

        String[] colunas = {"ID", "Marca", "Modelo", "Cor", "Placa", "Nome", "Horario de Entrada", "Foto"};
        Object[][] dados = new Object[veiculos.size()][colunas.length];

        SimpleDateFormat formatoSimples = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        for (int i = 0; i < veiculos.size(); i++) {
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
                return column != 0 && column != 6 && column != 7;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 7) {
                    return String.class;
                }
                return String.class;
            }
        });

        AjusteColunaTabelas tca = new AjusteColunaTabelas(table1);
        tca.adjustColumns();
    }
}