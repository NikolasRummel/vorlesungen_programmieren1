package de.dhbw.nikolas.exercise.gui.numberguesser;

public class NumberGuesssing {

    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        new NumberGuessingGui(game);
    }
}
