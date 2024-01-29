package de.dhbw.nikolas.exercise.operations.control;

import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 != 0) {
                    System.out.println("Kein Schaltjahr");
                } else {
                    System.out.println("Schaltjahr");
                }
            } else {
                System.out.println("Schaltjahr");
            }
        } else {
            System.out.println("Kein Schaltjahr");
        }
    }
}
