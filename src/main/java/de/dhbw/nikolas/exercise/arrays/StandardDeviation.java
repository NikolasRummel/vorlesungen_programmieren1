package de.dhbw.nikolas.exercise.arrays;

import java.util.Arrays;

public class StandardDeviation {

    private int[] numbers;

    public StandardDeviation() {
        this.numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 10);
        }
    }

    public static void main(String[] args) {
        StandardDeviation standardDeviation = new StandardDeviation();
        System.out.println(standardDeviation.calcuateAverage());
        System.out.println(standardDeviation.calculateStandardDeviation());
    }

    public float calcuateAverage() {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (float) sum / numbers.length;
    }

    public float calculateStandardDeviation() {
        float average = calcuateAverage();
        int sum = 0;
        for (int number : numbers) {
            sum += Math.pow(number - average, 2);
        }
        return (float) Math.sqrt(((double) 1 / (numbers.length-1)) * sum);
    }
}
