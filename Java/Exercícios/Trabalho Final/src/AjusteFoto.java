import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AjusteFoto {

    public static void configurarSelecaoImagem(JTable table, JLabel lblFoto, List<Veiculo> veiculos) {
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                int linhaSelecionada = table.getSelectedRow();
                byte[] fotoBytes = veiculos.get(linhaSelecionada).getFotoVeiculo();

                if (fotoBytes != null) {
                    ImageIcon fotoIcon = new ImageIcon(fotoBytes);
                    Image img = fotoIcon.getImage().getScaledInstance(120, 80, Image.SCALE_SMOOTH); // Miniatura da foto nas telas
                    lblFoto.setIcon(new ImageIcon(img));

                    for (var listener : lblFoto.getMouseListeners()) {
                        lblFoto.removeMouseListener(listener);
                    }

                    lblFoto.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            if (evt.getClickCount() == 1 && lblFoto.getIcon() != null) {
                                JFrame frameFotoAmpliada = new JFrame("Foto Ampliada");

                                ImageIcon originalIcon = new ImageIcon(fotoBytes);
                                Image img = originalIcon.getImage();

                                int larguraOriginal = img.getWidth(null);
                                int alturaOriginal = img.getHeight(null);
                                int larguraMax = 800;
                                int alturaMax = 600;

                                // Redimensiona proporcionalmente se a imagem ultrapassar 800x600
                                if (larguraOriginal > larguraMax || alturaOriginal > alturaMax) {
                                    float larguraProporcao = (float) larguraMax / larguraOriginal;
                                    float alturaProporcao = (float) alturaMax / alturaOriginal;
                                    float proporcaoFinal = Math.min(larguraProporcao, alturaProporcao);

                                    int novaLargura = (int) (larguraOriginal * proporcaoFinal);
                                    int novaAltura = (int) (alturaOriginal * proporcaoFinal);

                                    img = img.getScaledInstance(novaLargura, novaAltura, Image.SCALE_SMOOTH);
                                }

                                JLabel lblFotoAmpliada = new JLabel(new ImageIcon(img));
                                frameFotoAmpliada.add(lblFotoAmpliada);
                                frameFotoAmpliada.pack();
                                frameFotoAmpliada.setLocationRelativeTo(null);
                                frameFotoAmpliada.setVisible(true);
                            }
                        }
                    });

                } else {
                    lblFoto.setIcon(null); // Remove a imagem caso não exista
                }
            }
        });
    }
}