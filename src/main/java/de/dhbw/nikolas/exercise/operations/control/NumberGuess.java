package de.dhbw.nikolas.exercise.operations.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberGuess {

    private Scanner scanner;
    private String player;
    private List<Integer> tries;

    private boolean isRunning;


    public NumberGuess() {

    }

    private void initialize() {
        this.scanner = new Scanner(System.in);

        System.out.println("Wie heißt du?");
        this.player = scanner.nextLine();
        this.tries = new ArrayList<>();
        this.isRunning = true;

        start();
    }

    public void start() {
        while (isRunning) {
            int random = (int) (Math.random() * 100 + 1);
            boolean found = false;
            int currentTries = 0;

            while (!found) {
                currentTries++;

                System.out.println(player + ", rate eine Zahl zwischen 1 und 100");
                int input = scanner.nextInt();

                if (input > random) {
                    System.out.println(input + " ist zu groß");
                } else if (input < random) {
                    System.out.println(input + " ist zu klein");
                } else {
                    System.out.println("Du hast die Zahl erraten");
                    System.out.println("Du hast " + currentTries + " Versuche gebraucht");

                    tries.add(currentTries);
                    found = true;

                    System.out.println("Was möchtest du tun?");
                    System.out.println("0: Beenden");
                    System.out.println("1: Neues Spiel");
                }
            }

            int input = scanner.nextInt();
            if (input == 0) {
                isRunning = false;
            }
        }


        tries.forEach(System.out::println);

        System.out.println("----------------------------------------------------------------");
        System.out.println("Gespiele Spiele: " + tries.size());
        System.out.println("Durchschnittliche Verusche: " + tries.stream().mapToInt(Integer::intValue).sum() / tries.size());
        System.out.println("----------------------------------------------------------------");
    }
    public static void main(String[] args) {
        new NumberGuess().start();
    }
}