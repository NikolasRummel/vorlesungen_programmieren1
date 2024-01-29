package de.dhbw.nikolas.exercise.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        System.out.println("Bitte Anzahl der Elemente n eingeben:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Bitte " + (i + 1) + ". Element eingeben:");
            int input = scanner.nextInt();
            arr[i] = input;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[i]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println("Sortiert:" + Arrays.toString(arr));
    }
}
