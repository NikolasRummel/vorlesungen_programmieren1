package de.dhbw.nikolas.exercise.strings;

public class CrossTotal {

    public static void main(String[] args) {
        String number = "200";


        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum += Integer.parseInt(String.valueOf(number.charAt(i)));
        }
        System.out.println(sum);
    }
}
