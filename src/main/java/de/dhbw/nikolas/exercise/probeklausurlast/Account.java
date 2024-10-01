package de.dhbw.nikolas.exercise.probeklausurlast;

import java.awt.*;

public class Account {

    private String name;

    private State state;

    private Color color;


    public Account(String name) {
        this.name = name;
        this.state = State.AVAILABLE;
        this.color = new Color(generateNumber(), generateNumber(), generateNumber());
    }


    private int generateNumber() {
        return (int) (Math.random() * 200) + 1;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
