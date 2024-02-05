package de.dhbw.nikolas.exercise.arrays;

public class Pascal {

    public static void main(String[] args) {
        int[][] pascal = new int[9][9];

        pascal[0][0] = 1;

        for (int i = 1; i < pascal.length; i++) {
            pascal[i][0] = 1;

            for (int j = 1; j < pascal[i].length - 1; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        for (int i = 0; i < pascal.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < pascal[i].length - 1; j++) {
                System.out.print(pascal[i][j] + " ");
            }
        }
    }
}
