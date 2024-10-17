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
    private boolean isEating = false;
    private boolean isTired = false;
    private boolean isSleeping = false;

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
        int headSize = 200;
        g.setColor(Color.YELLOW);
        g.fillOval(70, 50, headSize, headSize);

        // Contorno da cabeça
        g.setColor(Color.BLACK);
        g.drawOval(70, 50, headSize, headSize);

        // Tamanho e posição dos olhos
        int eyeSize = 20;
        int eyeY = 130;
        int leftEyeX = 130;
        int rightEyeX = 190;

        if (!animal.isVivo()) {
            // Desenho do bichinho morto
            g.drawLine(leftEyeX, eyeY, leftEyeX + eyeSize, eyeY + 10);
            g.drawLine(leftEyeX + eyeSize, eyeY, leftEyeX, eyeY + 10);
            g.drawLine(rightEyeX, eyeY, rightEyeX + eyeSize, eyeY + 10);
            g.drawLine(rightEyeX + eyeSize, eyeY, rightEyeX, eyeY + 10);
            g.drawLine(120, 180, 220, 180);
        } else {
            // Se o bichinho está dormindo
            if (isSleeping) {
                g.drawLine(leftEyeX, eyeY, leftEyeX + eyeSize, eyeY);
                g.drawLine(rightEyeX, eyeY, rightEyeX + eyeSize, eyeY);
                g.drawString("ZzZz", 150, 40);
            } else {
                // Desenho dos olhos abertos
                g.fillOval(leftEyeX, eyeY, eyeSize, eyeSize);
                g.fillOval(rightEyeX, eyeY, eyeSize, eyeSize);
            }

            // Bocas
            if (isEating) {
                g.drawArc(110, 180, 120, 40, 0, 180);
                g.drawArc(110, 180, 120, 40, 0, -180);
            }
            if (isTired) {
                g.drawArc(110, 180, 120, 40, 0, 180);
            } else {
                g.drawArc(110, 180, 120, 40, 0, -180);
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
                    isEating = true;
                    isTired = false;
                    isSleeping = false;
                    break;
                case "Correr":
                    result = animal.correr();
                    isEating = false;
                    isTired = true;
                    isSleeping = false;
                    break;
                case "Dormir":
                    result = animal.dormir();
                    isEating = false;
                    isTired = false;
                    isSleeping = true;
                    break;
                case "Morrer":
                    result = animal.morrer();
                    break;
            }
            animationState++;
            displayPanel.repaint();
            statusArea.setText(result + "\n" + animal.status());
        }
    }
}