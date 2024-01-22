package de.dhbw.nikolas.exercise.operations;

public class IncrementDecrement {

    public static void main(String[] args) {
        int i = 0;
        int j = 0;

        j = ++i; // j = 1, i = 1
        int k = j++ + ++i; // k = 3, j = 2, i = 2
        System.out.println("k: " + k);
        System.out.println("*: " + j++ + ++i); //j = 2, i = 3
        //j = 3
        System.out.println(j++ + ++i); //j=3, i=4
        //j = 4

        int m = j++ * ++i; //j=5, i=5
        System.out.println("m: " + m); //20
        //j = 5, i = 5

        int n = --j * --i; //j=4, i=4 => 16
        System.out.println("n: " + n); //16
        System.out.println("i: " + i); //4
        System.out.println("j: " + j); //4


    }
}
