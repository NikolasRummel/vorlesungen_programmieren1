package de.dhbw.nikolas.exercise.gui.numberguesser;

import javax.swing.*;
import java.awt.*;

public class NumberGuessingGui extends JFrame {

    private NumberGuessingGame game;

    public NumberGuessingGui(NumberGuessingGame game) {
        super("Number Guesser");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel nameLabel = new JLabel("Player name:");
        JTextField nameField = new JTextField(30);
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        panel.add(namePanel);

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel inputLabel = new JLabel("Guess a number between 1 and 1000:");
        JTextField inputField = new JTextField(17);
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);
        panel.add(inputPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton gameButton = new JButton("New Game");
        JButton okButton = new JButton("Ok");
        JButton bestPlayerButton = new JButton("Best Player");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(gameButton);
        buttonPanel.add(okButton);
        buttonPanel.add(bestPlayerButton);
        buttonPanel.add(exitButton);

        panel.add(buttonPanel);

        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JTextField result = new JTextField("Attempt #0:", 40);
        resultPanel.add(result);
        panel.add(resultPanel);

        gameButton.addActionListener(e -> {
            game.setNumberToGuess(game.generateNumber());
            game.setAttempts(0);
            inputField.setText("");
            result.setText("Attempt #0:");
        });

        okButton.addActionListener(e -> {
            try {
                int guess = Integer.parseInt(inputField.getText());
                game.incrementAttempts();
                if (guess == game.getNumberToGuess()) {
                    result.setText("Attempt #" + game.getAttempts() + ": " + guess + " is the number.");
                    boolean finished = game.saveGame(nameField.getText());
                    JOptionPane.showMessageDialog(this, "Congratulations! You guessed the number in " + game.getAttempts() + " attempts.");
                    if (finished) {
                        JOptionPane.showMessageDialog(this, "Your result was saved.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Your result could not be saved, becuse no name was provided.");
                    }

                } else if (guess < game.getNumberToGuess()) {
                    result.setText("Attempt #" + game.getAttempts() + ": " + guess + " is lower than the number.");
                } else {
                    result.setText("Attempt #" + game.getAttempts() + ": " + guess + " is higher than the number.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number.");
            }
        });

        bestPlayerButton.addActionListener(e -> {
            String[] bestResult = game.getBestResultFromFile();
            JOptionPane.showMessageDialog(this, "Best player: " + bestResult[0] + " with " + bestResult[1] + " attempts.");
        });

        exitButton.addActionListener(e -> System.exit(0));

        this.add(panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}