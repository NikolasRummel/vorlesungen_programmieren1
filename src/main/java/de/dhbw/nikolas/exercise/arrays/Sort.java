package de.dhbw.nikolas.exercise.arrays;

import java.util.Arrays;

public class Sort {


    //bubbleSort
    public static void main(String[] args) {
        int[] numbs = {2, 4, 1, 8};

        for (int i = 0; i < numbs.length; i++) {
            int min = i;
            for(int j = i; j < numbs.length; j++){
                if (numbs[j] < numbs[min]){
                    min = j;

                    int tmp = numbs[i];
                    numbs[i] = numbs[min];
                    numbs[min] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(numbs));
    }

}
