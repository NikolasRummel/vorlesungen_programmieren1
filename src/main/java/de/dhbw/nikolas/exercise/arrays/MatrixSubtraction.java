package de.dhbw.nikolas.exercise.arrays;

import java.util.Scanner;

public class MatrixSubtraction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte Anzahl der Elemente n eingeben:");
        int n = scanner.nextInt();
        System.out.println("Bitte Anzahl der Elemente m eingeben:");
        int m = scanner.nextInt();

        int[][] matrix1 = new int[n][m];
        int[][] matrix2 = new int[n][m];
        int[][] result = new int[n][m];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = (int) (Math.random() * 100);
                matrix2[i][j] = (int) (Math.random() * 100);
            }
        }

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        System.out.println(" ");
        for (int i = 0; i < matrix1.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < matrix1[i].length; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
        }

        System.out.println(" ");
        for (int i = 0; i < matrix2.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < matrix2[i].length; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
        }

        System.out.println(" ");
        for (int i = 0; i < result.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
        }
    }

}
