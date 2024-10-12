package Tamagotchi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela extends JFrame {
    private Animais animal;
    private JPanel displayPanel;
    private JTextArea statusArea;
    private int animationState = 0;
    private boolean isEating = false; // Novo estado para quando o bichinho está comendo
    private boolean isTired = false;  // Novo estado para quando o bichinho está cansado
    private boolean isSleeping = false; // Novo estado para quando o bichinho está dormindo

    public Tela(Animais animal) {
        this.animal = animal;
        setTitle("Tamagotchi Swing");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel de exibição central
        displayPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawTamagotchi(g);
            }
        };
        displayPanel.setPreferredSize(new Dimension(200, 200));
        add(displayPanel, BorderLayout.CENTER);

        // Área de status
        statusArea = new JTextArea(animal.status());
        statusArea.setEditable(false);
        statusArea.setRows(8);
        JScrollPane scrollPane = new JScrollPane(statusArea);
        scrollPane.setPreferredSize(new Dimension(400, 150));
        add(scrollPane, BorderLayout.NORTH);

        // Painel de botões
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5));
        String[] buttonLabels = {"Comer", "Correr", "Dormir", "Morrer"};
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonAction(label));
            buttonPanel.add(button);
        }
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void morrerAction() {
        if (!animal.isVivo()) {
            statusArea.append("\nO bichinho já está morto.");
            return;
        }
        statusArea.append("\n" + animal.morrer());
        repaint();
    }

    private void drawTamagotchi(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());

        // Cabeça
        int headSize = 200; // Novo tamanho da cabeça
        g.setColor(Color.YELLOW);
        g.fillOval(70, 50, headSize, headSize);

        // Contorno da cabeça
        g.setColor(Color.BLACK);
        g.drawOval(70, 50, headSize, headSize);

        // Tamanho e posição dos olhos
        int eyeSize = 20; // Tamanho dos olhos
        int eyeY = 130;   // Y para os olhos
        int leftEyeX = 130; // X para o olho esquerdo
        int rightEyeX = 190; // X para o olho direito

        if (!animal.isVivo()) {
            // Desenho do bichinho morto
            g.drawLine(leftEyeX, eyeY, leftEyeX + eyeSize, eyeY + 10); // Olho esquerdo - diagonal
            g.drawLine(leftEyeX + eyeSize, eyeY, leftEyeX, eyeY + 10); // Olho esquerdo - diagonal
            g.drawLine(rightEyeX, eyeY, rightEyeX + eyeSize, eyeY + 10); // Olho direito - diagonal
            g.drawLine(rightEyeX + eyeSize, eyeY, rightEyeX, eyeY + 10); // Olho direito - diagonal
            g.drawLine(120, 180, 220, 180); // Boca
        } else {
            // Se o bichinho está dormindo
            if (isSleeping) {
                g.drawLine(leftEyeX, eyeY, leftEyeX + eyeSize, eyeY); // Olho esquerdo fechado
                g.drawLine(rightEyeX, eyeY, rightEyeX + eyeSize, eyeY); // Olho direito fechado
                g.drawString("ZzZz", 150, 40); // Desenha "ZzZz" acima da cabeça
            } else {
                // Desenho dos olhos abertos
                g.fillOval(leftEyeX, eyeY, eyeSize, eyeSize); // Olho esquerdo
                g.fillOval(rightEyeX, eyeY, eyeSize, eyeSize); // Olho direito
            }

            // Boca com base no estado da animação
            if (isEating) {
                g.drawArc(110, 180, 120, 40, 0, 180); // Boca aberta (simulando que está comendo)
                g.drawArc(110, 180, 120, 40, 0, -180); // Boca triste (simulando que está cansado)
            }
            if (isTired) {
                g.drawArc(110, 180, 120, 40, 0, 180); // Boca aberta (simulando que está comendo)
            } else {
                g.drawArc(110, 180, 120, 40, 0, -180); // Boca sorrindo
                }
            }
        }




    // Ação dos botões
    private class ButtonAction implements ActionListener {
        private String action;

        public ButtonAction(String action) {
            this.action = action;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String result = "";
            switch (action) {
                case "Comer":
                    result = animal.comer();
                    isEating = true; // Bichinho está comendo
                    isTired = false; // Reseta estado de cansaço
                    isSleeping = false; // Reseta estado de sono
                    break;
                case "Correr":
                    result = animal.correr();
                    isEating = false; // Reseta estado de comer
                    isTired = true; // Bichinho está cansado
                    isSleeping = false; // Reseta estado de sono
                    break;
                case "Dormir":
                    result = animal.dormir();
                    isEating = false; // Reseta estado de comer
                    isTired = false; // Reseta estado de cansaço
                    isSleeping = true; // Bichinho está dormindo
                    break;
                case "Morrer":
                    result = animal.morrer();
                    break;
//                case "Status":
//                    result = animal.status();
//                    break;
            }
            animationState++;
            displayPanel.repaint();
            statusArea.setText(result + "\n" + animal.status());
        }
    }
}
