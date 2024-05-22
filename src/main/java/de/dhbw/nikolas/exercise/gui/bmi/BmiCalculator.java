package de.dhbw.nikolas.exercise.gui.bmi;

import javax.swing.*;
import java.awt.*;

/**
 * @author Nikolas Rummel
 * @since 22.05.24, 08:16
 */
public class BmiCalculator extends JFrame {

    private JPanel panel;

    public BmiCalculator() {
        this.setSize(450, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new JPanel();
        this.panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Weight in kg");
        JTextField weightField = new JTextField();
        this.panel.add(label, BorderLayout.NORTH);
        this.panel.add(weightField, BorderLayout.NORTH);

        JLabel label2 = new JLabel("Height in cm");
        JTextField heightField = new JTextField();
        this.panel.add(label2, BorderLayout.NORTH);
        this.panel.add(heightField, BorderLayout.NORTH);

        JRadioButton male = new JRadioButton("male");
        JRadioButton female = new JRadioButton("female");
        this.panel.add(male, BorderLayout.NORTH);
        this.panel.add(female, BorderLayout.NORTH);
    }

}
