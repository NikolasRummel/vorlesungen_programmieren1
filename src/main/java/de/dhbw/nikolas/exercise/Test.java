package de.dhbw.nikolas.exercise;

import java.util.Arrays;

public class Test {


    public static void main(String[] args) {
        int[] list = {0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1};

        int sum = 0;
        for (int i = 0; i < list.length; i++) {
            sum += list[i];
        }

        System.out.println("Summe: " + sum % 2);

        System.out.println("Zahlen: " + Arrays.toString(createZahlen(10)));
    }

    public static int[] createZahlen(int n) {
        int[] list = new int[n];
        list[0] = 3;
        list[1] = 0;
        list[2] = 2;

        for (int i = 3; i < list.length; i++) {
            list[i] = list[i - 2] + list[i - 3];
        }
        return list;
    }

    public int[] bubbleSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length - 1; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
        return list;
    }

}
