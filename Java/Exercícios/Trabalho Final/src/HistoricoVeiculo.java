import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class HistoricoVeiculo extends JFrame{
    private JTable table1;
    private JPanel Historico;
    private JLabel lbl_total;
    private JLabel lbl_foto;
    private List<Veiculo> veiculos;



    public HistoricoVeiculo() throws SQLException {
        setContentPane(Historico);
        setTitle("Consulta e Alterações de Veículos");
        setSize(900, 600);
        setLocationRelativeTo(null);
        preencherTabela();

        AjusteFoto.configurarSelecaoImagem(table1, lbl_foto,veiculos);
    }

    private void preencherTabela() throws SQLException {
        Estacionamento estacionamento = new Estacionamento();
        veiculos = estacionamento.consultarVeiculosHistorico();

        String[] colunas = {"ID","Marca", "Modelo", "Cor", "Placa", "Nome", "Horario de Entrada", "Horário de Saída", "Valor","Foto","Valor p/ Hora"};
        Object[][] dados = new Object[veiculos.size()][colunas.length];

        SimpleDateFormat formatoSimples = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        double total = 0.0;

        for(int i = 0; i < veiculos.size(); i++){
            dados[i][0] = veiculos.get(i).getId();
            dados[i][1] = veiculos.get(i).getMarca();
            dados[i][2] = veiculos.get(i).getModelo();
            dados[i][3] = veiculos.get(i).getCor();
            dados[i][4] = veiculos.get(i).getPlaca();
            dados[i][5] = veiculos.get(i).getNomeMotorista();
            dados[i][6] = formatoSimples.format(veiculos.get(i).getHorarioEntrada());

            if (veiculos.get(i).getHorarioSaida() != null) {
                dados[i][7] = formatoSimples.format(veiculos.get(i).getHorarioSaida());
            } else {
                dados[i][7] = "";
            }
            double valorTotal = veiculos.get(i).getValorTotal();
            dados[i][8] = "R$ " + String.format("%.2f", valorTotal);
            total += valorTotal;

            if(veiculos.get(i).getFotoVeiculo() != null){
                dados[i][9] = "OK";
            }else{
                dados[i][9] = "-";
            }

            double valorHora = veiculos.get(i).getValorHora();
            dados[i][10] = "R$ " + String.format("%.2f",valorHora);
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

        AjusteColunaTabelas tca = new AjusteColunaTabelas(table1);
        tca.adjustColumns();

        lbl_total.setText("Total: R$ " + String.format("%.2f", total));
    }
}