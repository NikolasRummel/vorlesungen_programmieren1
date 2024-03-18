package de.dhbw.nikolas.exercise.probeklausur;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Game {

    private boolean finished;
    private Board board;
    private Player[] players;

    private ArrayList<String> checkOut;


    public Game(Board board, Player[] players) {
        this.board = board;
        this.players = players;
        this.checkOut = new ArrayList<>();
        this.readCheckout();
    }

    private void readCheckout() {
        Path path = Paths.get("myDir/checkouts.txt");
        try {
            Files.readAllLines(path).forEach(s -> checkOut.add(s));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void start() {
        final Scanner scanner = new Scanner(System.in);

        boolean firstPlayer = true;
        while (!finished) {
            Player player;
            if (firstPlayer) {
                player = players[0];
                firstPlayer = false;
            } else {
                player = players[1];
                firstPlayer = true;
            }

            System.out.println("=============================================");
            System.out.println("Player:" + player.getName() + " " + player.getRemainingPoints() + " points remaining.");
            if (player.getRemainingPoints() <= 170) {
                System.out.println("Checkout:" + checkOut.get(player.getRemainingPoints() - 1));
            }
            System.out.print("Enter visit: ");
            String input = scanner.nextLine();

            Visit visit = this.getFromInput(input);
            player.addVisit(visit);
            System.out.println("Scored: " + visit.getValue());


            finished = checkIfFinished();
        }

        this.printWinner();
    }


    private boolean printWinner() {
        for (Player player : this.players) {
            if (player.getRemainingPoints() == 0) {
                System.out.println("Game shot and the leg," + player.getName() + "!");

                this.saveHighScore(player);
                return true;
            }
        }
        System.out.println("You're to bad for this game!");
        return false;
    }

    private void saveHighScore(Player player) {
        Path highscore = Paths.get("myDir/highscore.txt");
        try {
            if (!Files.exists(highscore)) {
                Files.createFile(highscore);
            }

            String line = player.getName() + " won with " + player.getCountDartsThrown() + " darts \n";
            Files.write(highscore, line.getBytes(), java.nio.file.StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private Visit getFromInput(String input) {
        String split[] = input.split(" ");
        Field[] fields = new Field[split.length];

        for (int i = 0; i < fields.length; i++) {
            fields[i] = this.board.parseField(split[i]);
        }
        return new Visit(fields);
    }

    private boolean checkIfFinished() {
        for (Player player : this.players) {
            if (player.getRemainingPoints() == 0) {
                return true;
            }
        }

        // sollte gehen, da nur 2 spieler bei darts
        if (this.players[0].finishedThrowing() && this.players[1].finishedThrowing()) {
            return true;
        }

        return false;
    }
}

