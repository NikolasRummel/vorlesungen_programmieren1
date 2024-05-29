package de.dhbw.nikolas.exercise.gui.numberguesser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NumberGuessingGame {

    private final Path path = Paths.get("myDir/numberguess.txt");

    private String playerName;
    private int numberToGuess;
    private int attempts;

    public NumberGuessingGame() {
        this.numberToGuess = generateNumber();
        this.attempts = 0;

        this.createFile();
    }

    private void createFile() {
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] getBestResultFromFile() {
        String bestPlayer = "";
        int bestAttempts = Integer.MAX_VALUE;

        try {
            for (String line : Files.readAllLines(path)) {
                String[] parts = line.split(" ");
                int attempts = Integer.parseInt(parts[2]);

                if (attempts < bestAttempts) {
                    bestAttempts = attempts;
                    bestPlayer = parts[0];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return new String[]{bestPlayer, bestAttempts + ""};
    }

    public boolean saveGame(String playerName) {
        this.playerName = playerName;

        if (playerName == null || playerName.isEmpty()) {
            return false;
        }

        try {
            String line = playerName + " " + numberToGuess + " " + attempts + "\n";
            Files.write(path, line.getBytes(), java.nio.file.StandardOpenOption.APPEND);

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public int generateNumber() {
        return (int) (Math.random() * 1000 + 1);
    }

    public void incrementAttempts() {
        attempts++;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getNumberToGuess() {
        return numberToGuess;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setNumberToGuess(int numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
}
