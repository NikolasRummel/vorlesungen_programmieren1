package de.dhbw.nikolas.exercise.datatypes;

import java.util.Scanner;

public class Round {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            double input = scanner.nextDouble();
            double tmp = input + (input > 0 ? 0.5 : -0.5);
            int rounded = (int) tmp;

            System.out.println(rounded);
        }
    }
}
