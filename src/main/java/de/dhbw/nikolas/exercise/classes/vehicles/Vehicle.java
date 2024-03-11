package de.dhbw.nikolas.exercise.classes.vehicles;

public abstract class Vehicle {

    protected int wheels = 0;
    protected double vmax = 0;
    protected double position = 0;
    protected double speed = 0;

    public Vehicle(int wheels, double vmax, double position, double speed) {
        this.wheels = wheels;
        this.vmax = vmax;
        this.position = position;
        this.speed = speed;
    }

    public Vehicle(double speed) {
        this.speed = speed;
    }

    public abstract void info();

    protected double setSpeed(double speed) {
        if (speed > vmax) {
            this.speed = vmax;
        } else {
            this.speed = speed;
        }
        return this.speed;
    }

    protected void drive(double minutes) {
        position += speed * (minutes / 60);
    }

    public String toString() {
        return "Vehicle{" +
                "wheels=" + wheels +
                ", vmax=" + vmax +
                ", position=" + position +
                ", speed=" + speed +
                '}';
    }
}
