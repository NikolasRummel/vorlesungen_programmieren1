package de.dhbw.nikolas.exercise.datatypes;

public class Round {

    public static void main(String[] args) {
        double d = -4.7D;
        double d2 = d < 0 ? d - 0.5 : 0.5;

        int r = (int) d2;
        System.out.println(r);
    }

}
