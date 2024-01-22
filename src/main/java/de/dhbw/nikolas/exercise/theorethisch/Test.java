package de.dhbw.nikolas.exercise.theorethisch;

public class Test {
    public int[] bubbleSort(int[] array) {
        int n = array.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1] > array[j]) {
                    //swap elements
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }

    public int[] selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public int ggt(int x, int y) {
        while (y != 0) {
            int a = x % y;
            x = y;
            y = a;
        }
        return x;
    }

    public int nextPrimeNumberAfter(int n) {
        int pp = n;
        boolean isPrime = false;
        do {
            pp++;
            int mt = 2;
            boolean gehtAuf = false;
            do {
                gehtAuf = pp % mt == 0;
                mt++;
            } while (!gehtAuf);

            if (mt > pp) {
                isPrime = true;
            }
        } while (!isPrime);
        return pp;
    }

    public int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n-1);
    }

    public static void main(String[] args) {
        System.out.println(new Test().nextPrimeNumberAfter(152));
    }



}




