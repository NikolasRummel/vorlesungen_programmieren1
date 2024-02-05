package de.dhbw.nikolas.exercise.arrays;

import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {
        int[] fib = new int[20];
        fib[0] = 1;
        fib[1] = 1;

        for(int i = 2; i< fib.length; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }

        System.out.println(Arrays.toString(fib));
    }
}
