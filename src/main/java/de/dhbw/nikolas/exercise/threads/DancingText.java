package de.dhbw.nikolas.exercise.threads;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 * <p>
 * (C) 2016-2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.1-NO-DANCE
 */
@SuppressWarnings("serial")
public class DancingText extends JComponent {

    private final static int XBASE = 30;
    private final static int XSTEP = 36;
    private final static int YBASE = 150;
    private final static Random RANDOM = new Random();

    private String text;
    private final long delay;

    private int colR = 0; // Color-Channel: red
    private int colG = 90; // Color-Channel: green
    private int colB = 180; // Color-Channel: blue
    private int yOffset = 0;

    public DancingText(String text, long delay) {
        this.text = text;
        this.delay = delay;
    }

    /**
     * Paint dancing text on Graphics
     *
     * @param g graphics to use
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Helvetica", Font.BOLD, 48));
        for (int i = 0; i < this.text.length(); i++) {
            char c = this.text.charAt(i);

            this.colR = (this.colR + 4 + DancingText.RANDOM.nextInt(4)) % 256;
            this.colG = (this.colG + 4 + DancingText.RANDOM.nextInt(4)) % 256;
            this.colB = (this.colB + 4 + DancingText.RANDOM.nextInt(4)) % 256;

            this.yOffset = DancingText.RANDOM.nextInt(30);

            g.setColor(new Color(this.colR, this.colG, this.colB));
            g.drawString("" + c, DancingText.XBASE + i * DancingText.XSTEP,
                    DancingText.YBASE - this.yOffset);
        }
    }

    public static void main(String[] args) {
        // Create frame and add DancingText component
        JFrame f = new JFrame("Dancing Text");
        f.add(new DancingText("-#-#-#-#-#-#-#-#-#-#", 200));

        new Thread(() -> {
            while (true) {
                try {
                    f.repaint();
                    Thread.sleep(1000 / 10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(640, 280);
        f.setVisible(true);
    }

}
