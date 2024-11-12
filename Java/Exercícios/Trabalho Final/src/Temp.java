//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.util.List;
//
//public class EditarVeiculo extends JFrame {
//    private JTable table1;
//    private JButton btn_cancelar;
//    private JButton btn_alterar;
//    private JPanel Editar;
//    private JLabel lbl_foto;
//    private List<Veiculo> veiculos;
//
//    public EditarVeiculo() throws SQLException {
//        // Inicializar painel principal
//        Editar = new JPanel(new BorderLayout());
//        setContentPane(Editar);
//        setTitle("Consulta e Alterações de Veículos");
//        setSize(900, 600);
//        setLocationRelativeTo(null);
//
//        // Inicializar componentes
//        lbl_foto = new JLabel();
//        lbl_foto.setPreferredSize(new Dimension(100, 100));
//        lbl_foto.setHorizontalAlignment(JLabel.CENTER);
//        lbl_foto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//
//        table1 = new JTable();
//        JScrollPane scrollPane = new JScrollPane(table1);
//
//        btn_cancelar = new JButton("Cancelar");
//        btn_alterar = new JButton("Alterar");
//
//        // Painel de botões
//        JPanel painelBotoes = new JPanel();
//        painelBotoes.add(btn_cancelar);
//        painelBotoes.add(btn_alterar);
//
//        // Adicionar componentes ao painel principal
//        Editar.add(lbl_foto, BorderLayout.EAST);
//        Editar.add(scrollPane, BorderLayout.CENTER);
//        Editar.add(painelBotoes, BorderLayout.SOUTH);
//
//        preencherTabela();
//
//        btn_cancelar.addActionListener(e -> dispose());
//
//        btn_alterar.addActionListener(e -> {
//            int linhaSelecionada = table1.getSelectedRow();
//
//            if (linhaSelecionada >= 0) {
//                int id = Integer.parseInt(table1.getValueAt(linhaSelecionada, 0).toString());
//                String marca = table1.getValueAt(linhaSelecionada, 1).toString().toUpperCase();
//                String modelo = table1.getValueAt(linhaSelecionada, 2).toString().toUpperCase();
//                String cor = table1.getValueAt(linhaSelecionada, 3).toString().toUpperCase();
//                String placa = table1.getValueAt(linhaSelecionada, 4).toString().toUpperCase().replace("-", "");
//                String nomeMotorista = table1.getValueAt(linhaSelecionada, 5).toString().toUpperCase();
//
//                Veiculo veiculoAlterado = new Veiculo(id, marca, modelo, cor, placa, nomeMotorista);
//
//                try {
//                    Estacionamento estacionamento = new Estacionamento();
//                    estacionamento.atualizarVeiculo(id, veiculoAlterado);
//                    JOptionPane.showMessageDialog(this, "Veículo alterado com sucesso!");
//                    preencherTabela();
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(this, "Erro ao alterar Veículo");
//                }
//            } else {
//                JOptionPane.showMessageDialog(this, "Selecione uma linha para alterar o cadastro.");
//            }
//        });
//
//        table1.getSelectionModel().addListSelectionListener(e -> {
//            if (!e.getValueIsAdjusting() && table1.getSelectedRow() != -1) {
//                int linhaSelecionada = table1.getSelectedRow();
//                byte[] fotoBytes = veiculos.get(linhaSelecionada).getFotoVeiculo();
//
//                if (fotoBytes != null) {
//                    ImageIcon fotoIcon = new ImageIcon(fotoBytes);
//                    Image img = fotoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Miniatura
//                    lbl_foto.setIcon(new ImageIcon(img));
//                } else {
//                    lbl_foto.setIcon(null); // Remove a imagem caso não exista
//                }
//            }
//        });
//    }
//
//    private void preencherTabela() throws SQLException {
//        Estacionamento estacionamento = new Estacionamento();
//        veiculos = estacionamento.consultarVeiculos();
//
//        String[] colunas = {"ID", "Marca", "Modelo", "Cor", "Placa", "Nome", "Horario de Entrada", "Foto"};
//        Object[][] dados = new Object[veiculos.size()][colunas.length];
//
//        SimpleDateFormat formatoSimples = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//
//        for (int i = 0; i < veiculos.size(); i++) {
//            dados[i][0] = veiculos.get(i).getId();
//            dados[i][1] = veiculos.get(i).getMarca();
//            dados[i][2] = veiculos.get(i).getModelo();
//            dados[i][3] = veiculos.get(i).getCor();
//            dados[i][4] = veiculos.get(i).getPlaca();
//            dados[i][5] = veiculos.get(i).getNomeMotorista();
//            dados[i][6] = formatoSimples.format(veiculos.get(i).getHorarioEntrada());
//            dados[i][7] = veiculos.get(i).getFotoVeiculo(); // Coluna de fotos
//        }
//
//        table1.setModel(new DefaultTableModel(dados, colunas) {
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return column != 0 && column != 6 && column != 7; // Apenas permite edição de algumas colunas
//            }
//
//            @Override
//            public Class<?> getColumnClass(int columnIndex) {
//                if (columnIndex == 7) {
//                    return ImageIcon.class;
//                }
//                return String.class;
//            }
//        });
//
//        AjusteColunaTabelas tca = new AjusteColunaTabelas(table1);
//        tca.adjustColumns();
//    }
//}
