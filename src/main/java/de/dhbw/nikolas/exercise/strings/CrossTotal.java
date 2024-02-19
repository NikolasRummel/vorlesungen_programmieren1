package de.dhbw.nikolas.exercise.strings;

public class CrossTotal {

    public static void main(String[] args) {
        String number = "43";


        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            sum += c - '0';
        }
        System.out.println(sum);
    }
}
