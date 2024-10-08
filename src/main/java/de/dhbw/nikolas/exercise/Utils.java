package de.dhbw.nikolas.exercise;

public class Utils {

    public static int generateRandom(int Min, int Max) {
        return (int) (Math.random() * (Max - Min)) + Min;
    }
}
