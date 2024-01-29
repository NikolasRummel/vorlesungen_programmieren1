package de.dhbw.nikolas.exercise.arrays;

import java.util.Scanner;

public class Norm {

    public static void main(String[] args) {
        System.out.println("Bitte Anzahl der Elemente n eingeben:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] vector = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Bitte " + (i+1) + ". Element eingeben:");
            int input = scanner.nextInt();
            vector[i] = input;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += vector[i] * vector[i];
        }

        System.out.println("Betrag: " + Math.sqrt(sum));
    }
}
