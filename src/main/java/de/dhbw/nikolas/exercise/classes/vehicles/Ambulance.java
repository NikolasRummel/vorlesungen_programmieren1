package de.dhbw.nikolas.exercise.classes.vehicles;

public class Ambulance extends Vehicle {

    private boolean isSirenOn;

    public Ambulance(double speed, boolean isSirenOn) {
        super(3, 140, 0, speed);
        this.isSirenOn = isSirenOn;
    }

    public void turnOnSiren() {
        isSirenOn = true;
    }

    public void turnOffSiren() {
        isSirenOn = false;
    }
}
