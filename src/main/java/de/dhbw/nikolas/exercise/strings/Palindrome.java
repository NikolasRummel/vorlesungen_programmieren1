package de.dhbw.nikolas.exercise.strings;

public class Palindrome {

    public static void main(String[] args) {

        String input = "abc";

        boolean isPalindrome = true;

        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                isPalindrome = false;
            }
        }


        String reverse = "";
        for (int i = 0; i < input.length(); i++) {
            reverse = input.charAt(i) + reverse;
        }

        System.out.println("Reverse: " + reverse);

        if (isPalindrome) {
            System.out.println("Das Wort ist ein Palindrom");

        } else {
            System.out.println("Das Wort ist kein Palindrom");
        }
    }
}
