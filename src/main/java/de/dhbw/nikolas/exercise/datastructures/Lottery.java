package de.dhbw.nikolas.exercise.datastructures;

import java.util.SortedSet;
import java.util.TreeSet;

public class Lottery {

    public static void main(String[] args) {
        new Lottery();
    }

    public Lottery() {

        SortedSet<Integer> numbers = new TreeSet<>();
        while (numbers.size() < 6) {
            numbers.add(generateNumber());
        }

        numbers.add(generateNumber());
        System.out.println("Your numbers are: " + numbers);

    }

    private int generateNumber() {
        return (int) (Math.random() * 49) + 1;
    }

}
