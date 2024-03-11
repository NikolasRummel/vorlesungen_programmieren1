package de.dhbw.nikolas.exercise.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class PalindromeFile {

    private final Scanner scanner;
    private final Path path;

    public PalindromeFile() {
        this.scanner = new Scanner(System.in);
        this.path = Paths.get("myDir/palindrome.txt");
    }

    private String readLine() {
        System.out.println("Enter a word:");
        return scanner.nextLine();
    }

    private boolean checkIfPalindrome(String input) {
        boolean isPalindrome = true;
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                isPalindrome = false;
            }
        }

        return isPalindrome;
    }

    private void saveInFile(String input) {
        try {
            Path path = Paths.get("myDir/palindrome.txt");

            if (!Files.exists(path)) {
                Files.createFile(path);
            }

            String line = input + "\n";
            Files.write(path, line.getBytes(), java.nio.file.StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printPalindromes() {
        try {
            Files.readAllLines(path).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readPalindrome() {
        String input = this.readLine();

        boolean isPalindrome = this.checkIfPalindrome(input);

        if (isPalindrome) {
            this.saveInFile(input);
            this.printPalindromes();

        } else {
            System.out.println("The word is not a palindrome");
        }
    }

    public static void main(String[] args) {
        new PalindromeFile().readPalindrome();
    }
}
