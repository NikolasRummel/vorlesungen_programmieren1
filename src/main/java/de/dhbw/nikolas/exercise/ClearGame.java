package de.dhbw.nikolas.exercise;

import java.util.Scanner;

public class ClearGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long min = Integer.MAX_VALUE;
        while (true) {
            long start = System.currentTimeMillis();
            String input = scanner.nextLine();
            long elapsed = System.currentTimeMillis() - start;

            if(input.equals("clear")) {
                if(min > elapsed) {
                    min = elapsed;
                }
                System.out.println("took:" + elapsed + " ms");
                System.out.println("min:" + min + " ms");
            }
        }
    }
}
