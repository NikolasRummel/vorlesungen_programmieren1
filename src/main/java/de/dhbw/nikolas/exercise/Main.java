package de.dhbw.nikolas.exercise;

import de.dhbw.nikolas.exercise.classes.Radio;

public class Main {

    public static void main(String[] args) {
        Radio radio = new Radio(false, 7, 93.5);
        System.out.println(radio);
        radio.turnOn();
        System.out.println(radio);
        radio.incrementVolume();
        System.out.println(radio);
        radio.incrementVolume();
        radio.incrementVolume();
        System.out.println(radio);
        radio.decrementVolume();
        System.out.println(radio);
        radio.setFrequency(97.8);
        System.out.println(radio);
        radio.setFrequency(112.7);
        System.out.println(radio);
        radio.turnOff();
        System.out.println(radio);
    }
}