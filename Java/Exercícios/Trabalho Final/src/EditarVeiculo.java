import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class EditarVeiculo extends JFrame{
    private JTable table1;
    private JButton btn_cancelar;
    private JButton btn_alterar;
    private JPanel Editar;

    public EditarVeiculo() throws SQLException {
        setContentPane(Editar);
        setTitle("Consulta e Alterações de Veículos");
        setSize(900, 600);
        setLocationRelativeTo(null);

        preencherTabela();

        btn_cancelar.addActionListener(e ->{
            dispose();
        });

        btn_alterar.addActionListener(e -> {
            int linhaSelecionada = table1.getSelectedRow();

            if( linhaSelecionada >= 0){
                int id = Integer.parseInt(table1.getValueAt(linhaSelecionada, 0).toString());
                String marca = table1.getValueAt(linhaSelecionada, 1).toString().toUpperCase();
                String modelo = table1.getValueAt(linhaSelecionada, 2).toString().toUpperCase();
                String cor = table1.getValueAt(linhaSelecionada, 3).toString().toUpperCase();
                String placa = table1.getValueAt(linhaSelecionada,4).toString().toUpperCase().replace("-","");
                String nomeMotorista = table1.getValueAt(linhaSelecionada, 5).toString().toUpperCase();

//                // Verificar se algum valor essencial está vazio ou nulo
//                if (marca == null || modelo == null || cor == null || placa == null || nomeMotorista == null ||
//                        marca.trim().isEmpty() || modelo.trim().isEmpty() || cor.trim().isEmpty() || placa.trim().isEmpty() || nomeMotorista.trim().isEmpty()) {
//                    JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos antes de alterar.");
//                    return;
//                }
//
//                System.out.println("ID: " + id);
//                System.out.println("Marca: " + marca);
//                System.out.println("Modelo: " + modelo);
//                System.out.println("Cor: " + cor);
//                System.out.println("Placa: " + placa);
//                System.out.println("Nome do Motorista: " + nomeMotorista);
//

                Veiculo veiculoAlterado = new Veiculo(id, marca, modelo, cor, placa, nomeMotorista);

                try{
                    Estacionamento estacionamento = new Estacionamento();
                    estacionamento.atualizarVeiculo(id, veiculoAlterado);
                    JOptionPane.showMessageDialog(this, "Veículo alterado com sucesso!");
                    preencherTabela();
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(this, "Erro ao alterar Veículo");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Selecione uma linha para efetuar alterar o cadastro.");
            }
        });
    }

    private void preencherTabela() throws SQLException {
        Estacionamento estacionamento = new Estacionamento();
        List<Veiculo> veiculos = estacionamento.consultarVeiculos();

        String[] colunas = {"ID","Marca", "Modelo", "Cor", "Placa", "Nome", "Horario de Entrada"};
        Object[][] dados = new Object[veiculos.size()][colunas.length]; //pode ser 7 no lugar do length (8 quando incluir a foto)

        SimpleDateFormat formatoSimples = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        for(int i = 0; i < veiculos.size(); i++){
            dados[i][0] = veiculos.get(i).getId();
            dados[i][1] = veiculos.get(i).getMarca();
            dados[i][2] = veiculos.get(i).getModelo();
            dados[i][3] = veiculos.get(i).getCor();
            dados[i][4] = veiculos.get(i).getPlaca();
            dados[i][5] = veiculos.get(i).getNomeMotorista();
            dados[i][6] = formatoSimples.format(veiculos.get(i).getHorarioEntrada());
            ///dados[i][7] = FOTO

        }

//        System.out.println("Verificacao SQL");
//        for (Veiculo veiculo : veiculos) {
//            System.out.println("Veículo: " + veiculo.getMarca() + ", " + veiculo.getModelo());
//        }

        table1.setModel(new DefaultTableModel(dados, colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0 && column != 6;
            }
        });

        AjusteColunaTabelas tca = new AjusteColunaTabelas(table1); tca.adjustColumns();
    }
}
