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
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new JPanel();
        this.panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel label = new JLabel("Weight in kg");
        JTextField weightField = new JTextField(15);
        c.gridx = 0;
        c.gridy = 0;
        this.panel.add(label, c);
        c.gridx = 1;
        this.panel.add(weightField, c);

        JLabel label2 = new JLabel("Height in cm");
        JTextField heightField = new JTextField(15);
        c.gridx = 0;
        c.gridy = 1;
        this.panel.add(label2, c);
        c.gridx = 1;
        this.panel.add(heightField, c);

        JRadioButton male = new JRadioButton("male");
        JRadioButton female = new JRadioButton("female");
        c.gridx = 0;
        c.gridy = 2;
        this.panel.add(male, c);
        c.gridx = 1;
        this.panel.add(female, c);

        JButton calculate = new JButton("Calculate");
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        this.panel.add(calculate, c);

        JLabel result = new JLabel();
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        this.panel.add(result, c);

        calculate.addActionListener(e -> {
            try {
                double weight = Double.parseDouble(weightField.getText());
                double height = Double.parseDouble(heightField.getText());
                double bmi = weight / Math.pow(height / 100, 2);
                result.setText("Your BMI is: " + bmi);
            } catch (NumberFormatException ex) {
                result.setText("Please enter a valid number");
            }
        });

        JLabel label3 = new JLabel("BMI: ");
        JTextField bmi = new JTextField(15);
        c.gridx = 0;
        c.gridy = 5;
        this.panel.add(label3, c);
        c.gridx = 1;
        this.panel.add(bmi, c);

        this.add(panel);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new BmiCalculator();
    }
}