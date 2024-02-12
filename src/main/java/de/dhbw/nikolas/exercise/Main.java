package de.dhbw.nikolas.exercise;

import de.dhbw.nikolas.exercise.classes.Point;
import de.dhbw.nikolas.exercise.classes.Radio;

public class Main {

    public static void main(String[] args) {
        Point point = new Point(3, 4);
        Point point2 = new Point(4, 5);
        System.out.println(point.distance(point2));
        System.out.println(point.mirrorY());
        System.out.println(point.mirrorX());
        System.out.println(point.mirror());
    }
}