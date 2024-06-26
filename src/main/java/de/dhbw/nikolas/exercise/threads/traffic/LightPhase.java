package de.dhbw.nikolas.exercise.threads.traffic;

public class LightPhase {

    private String name;
    private boolean red;
    private boolean yellow;
    private boolean green;
    private int duration;
    private LightPhase next;

    public LightPhase(String name, boolean red, boolean yellow, boolean green, int duration) {
        this.name = name;
        this.red = red;
        this.yellow = yellow;
        this.green = green;
        this.duration = duration;
    }

    public void setNext(LightPhase next) {
        this.next = next;
    }

    public LightPhase getNext() {
        return this.next;
    }

    public String getName() {
        return name;
    }

    public boolean isRed() {
        return red;
    }

    public boolean isYellow() {
        return yellow;
    }

    public boolean isGreen() {
        return green;
    }

    public int getDuration() {
        return duration;
    }
}