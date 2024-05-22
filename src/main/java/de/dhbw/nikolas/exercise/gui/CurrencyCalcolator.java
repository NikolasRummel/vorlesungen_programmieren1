package de.dhbw.nikolas.exercise.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Nikolas Rummel
 * @since 22.05.24, 08:05
 */
public class CurrencyCalcolator extends JFrame {

    private static final double CONVERSION_FACTOR = 1.09D;

    private JPanel panel;

    public CurrencyCalcolator() {
        this.setSize(450, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextField textField = new JTextField();
        textField.setText("Please enter a value to convert");
        panel.add(textField, BorderLayout.NORTH);

        JButton convert1 = new JButton("EUR -> USD");
        JButton convert2 = new JButton("USD -> EUR");
        JButton cancel = new JButton("Cancel");

        JPanel buttonPanel = new JPanel();


        convert1.addActionListener(e -> {
            try {
                double value = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(value * CONVERSION_FACTOR));
            } catch (NumberFormatException ex) {
                textField.setText("Please enter a valid number");
            }
        });

        convert2.addActionListener(e -> {
            try {
                double value = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(value / CONVERSION_FACTOR));
            } catch (NumberFormatException ex) {
                textField.setText("Please enter a valid number");
            }
        });

        cancel.addActionListener(e -> System.exit(0));

        buttonPanel.add(convert1, BorderLayout.SOUTH);
        buttonPanel.add(convert2, BorderLayout.SOUTH);
        buttonPanel.add(cancel, BorderLayout.SOUTH);

        this.panel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(panel);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new CurrencyCalcolator();
    }
}
