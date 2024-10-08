package de.dhbw.nikolas.exercise.speedy;

import java.awt.*;

public enum Status {

    ACTIVE(Color.ORANGE, 0),
    CORRECT(Color.GREEN, 1),
    WRONG(Color.RED, -1),
    PENDING(Color.WHITE, 0),
    NO_ANSWER(Color.GRAY, 0);

    private Color color;
    private int points;

    Status(Color color, int points) {
        this.color = color;
        this.points = points;
    }

    public Color getColor() {
        return color;
    }

    public int getPoints() {
        return points;
    }
}
