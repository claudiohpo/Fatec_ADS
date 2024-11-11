import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class IncluirVeiculo extends JFrame {
    private JButton btn_registrar;
    private JLabel lbl_modelo;
    private JTextField txt_marca;
    private JTextField txt_modelo;
    private JTextField txt_cor;
    private JTextField txt_placa;
    private JTextField txt_motorista;
    private JPanel Incluir;
    private JLabel lbl_marca;
    private JLabel lbl_cor;
    private JLabel lbl_placa;
    private JLabel lbl_motorista;
    private JLabel lbl_Titulo;
    private JButton btn_cancelar;
    private JLabel lcl_foto;
    private JButton btn_foto;

    private byte[] fotoBytes = null;

    public IncluirVeiculo() throws SQLException {
        setContentPane(Incluir);
        setTitle("Incluir Veículo");
        setSize(800, 600);
        setLocationRelativeTo(null);

        Estacionamento estacionamento = new Estacionamento();

        btn_foto.addActionListener(e -> {
            JFileChooser arquivoFoto = new JFileChooser();
            arquivoFoto.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int resultado = arquivoFoto.showOpenDialog(this);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                File file = arquivoFoto.getSelectedFile();
                try {
                    fotoBytes = Files.readAllBytes(file.toPath()); // Lê a imagem em bytes
                    JOptionPane.showMessageDialog(this, "Foto selecionada com sucesso!");
                    System.out.println("Foto: " + fotoBytes);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao carregar a foto.");
                }
            }
        });

        btn_registrar.addActionListener(e ->{

            try {
                String marca = txt_marca.getText().toUpperCase();
                String modelo = txt_modelo.getText().toUpperCase();
                String cor = txt_cor.getText().toUpperCase();
                String placa = txt_placa.getText().replace("-","").toUpperCase();
                if(estacionamento.placaDuplicada(placa)){
                    JOptionPane.showMessageDialog(null,"Erro: O veículo " + placa + " já está no Estacionamento!");
                    return;
                }
                String nomeMotorista = txt_motorista.getText().toUpperCase();

                Timestamp horarioEntrada = new Timestamp(System.currentTimeMillis());
                SimpleDateFormat formatoSimples = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String dataFormatada = formatoSimples.format(horarioEntrada);

                Veiculo veiculo = new Veiculo(marca, modelo, cor, placa, nomeMotorista, horarioEntrada, fotoBytes);

                System.out.println("Horário de entrada: " + dataFormatada); //console
                int balao = JOptionPane.showConfirmDialog(Incluir,"Horário de entrada: "
                        + dataFormatada +"\nEntrada registrada com sucesso!"
                        + "\n\nDeseja Incluir outro Veículo?", "Continuar?", JOptionPane.YES_NO_OPTION);
                if(balao != JOptionPane.YES_NO_OPTION){
                    dispose();
                }
                //JOptionPane.showMessageDialog(Incluir, "Horário de entrada: " + dataFormatada +"\nEntrada registrada com sucesso!"); //Message Box
                estacionamento.registrarEntrada(veiculo);

                System.out.println("Entrada registrada com sucesso!"); //Console

                txt_marca.setText("");
                txt_modelo.setText("");
                txt_cor.setText("");
                txt_placa.setText("");
                txt_motorista.setText("");
                fotoBytes = null;

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        btn_cancelar.addActionListener(e ->{
           dispose();
        });
    }
}