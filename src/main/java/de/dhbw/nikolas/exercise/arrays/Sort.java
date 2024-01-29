package de.dhbw.nikolas.exercise.arrays;

import java.util.Arrays;

public class Sort {


    //bubblesort
    public static void main(String[] args) {
        double[] numbs = {1.2, 4.0, 0.9, 2.7};

        for (int i = 0; i < numbs.length; i++) {
            int min = i;
            for(int j = i; j < numbs.length; j++){
                if (numbs[j] < numbs[min]){
                    min = j;

                    double tmp = numbs[i];
                    numbs[i] = numbs[min];
                    numbs[min] = tmp;
                }
            }
        }


        System.out.println(Arrays.toString(numbs));
    }

}
