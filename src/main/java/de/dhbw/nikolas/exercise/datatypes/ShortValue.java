package de.dhbw.nikolas.exercise.datatypes;

public class ShortValue {

    public static void main(String[] args) {
        short s = 32767;
        System.out.println(s);
        s++;  //-32768 (overflow)
        System.out.println(s);
    }
}
