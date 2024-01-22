package de.dhbw.nikolas.exercise.operations;

import java.util.Scanner;

public class Easter {

    public static void main(String[] args) {
        Easter easter = new Easter();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bitte geben Sie ein Jahr ein: ");
            int year = scanner.nextInt();
            if (year <= 0) {
                System.out.println("Das Jahr muss größer als 0 sein!");
                continue;
            }
            easter.calculateEaster(year);
        }
    }

    public void calculateEaster(int year) {
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int k = year / 100;
        int p = (8 * k + 13) / 25;
        int q = k / 4;
        int m = (15 + k - p - q) % 30;
        int d = (19 * a + m) % 30;
        int n = (4 + k - q) % 7;
        int e = (2 * b + 4 * c + 6 * d + n) % 7;
        int days = 22 + d + e;
        if (days <= 31) {
            System.out.println("Ostern ist am " + days + ". März");
        } else {
            System.out.println("Ostern ist am " + (days - 31) + ". April");
        }
    }
}
