package de.dhbw.nikolas.exercise.threads.traffic;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 * <p>
 * (C) 2016-2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.1-STATICLIGHT
 */
@SuppressWarnings("serial")
public class TrafficLight extends JComponent {

    private final static long DELAY = 500;

    private LightPhase currentPhase;

    public TrafficLight(LightPhase currentPhase) {
        this.currentPhase = currentPhase;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent( g );
        // traffic light box
        g.setColor(Color.BLACK);
        g.fillRect(10, 10, 80, 195);

        // 3 x empty light
        g.setColor(Color.WHITE);
        g.fillOval(23, 23, 54, 54);
        g.fillOval(23, 83, 54, 54);
        g.fillOval(23, 143, 54, 54);

        boolean redOn = currentPhase.isRed();
        boolean yellowOn = currentPhase.isYellow();
        boolean greenOn = currentPhase.isGreen();

        // draw colored lights, if active
        if (redOn) {
            g.setColor(Color.RED);
            g.fillOval(25, 25, 50, 50);
        }

        if (yellowOn) {
            g.setColor(Color.YELLOW);
            g.fillOval(25, 85, 50, 50);
        }
        if (greenOn) {
            g.setColor(Color.GREEN);
            g.fillOval(25, 145, 50, 50);
        }
    }

    public void setCurrentPhase(LightPhase currentPhase) {
        this.currentPhase = currentPhase;
    }
}
