package de.dhbw.nikolas.exercise.operations;

import java.util.Scanner;

public class QuadraticFormula {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Enter a: ");
            double a = scanner.nextDouble();
            System.out.println("Enter b: ");
            double b = scanner.nextDouble();
            System.out.println("Enter c: ");
            double c = scanner.nextDouble();

            if (a == 0) {
                if (b == 0) {
                    System.out.println("Die Gleichung ist degeneriert");
                } else {
                    System.out.println("x: " + -c / b);
                }
            } else {
                double d = Math.pow(b, 2) - 4 * a * c;
                if (d < 0) {
                    System.out.println("Die Lösung ist konjugiert komplex");
                } else if (d == 0) {
                    System.out.println("x: " + -b / (2 * a));
                } else {
                    double x1 = (-b + Math.sqrt(d)) / (2 * a);
                    double x2 = (-b - Math.sqrt(d)) / (2 * a);
                    System.out.println("x1: " + x1);
                    System.out.println("x2: " + x2);
                }
            }
        }
    }
}
