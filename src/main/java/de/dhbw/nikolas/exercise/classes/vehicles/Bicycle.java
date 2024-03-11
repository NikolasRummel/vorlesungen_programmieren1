package de.dhbw.nikolas.exercise.classes.vehicles;

public class Bicycle extends Vehicle {

    public Bicycle(double speed) {
        super(2, 30, 0, speed);
    }

    @Override
    public void info() {
        System.out.println("Bicycle{" +
                "wheels=" + wheels +
                ", vmax=" + vmax +
                ", position=" + position +
                ", speed=" + speed +
                '}');
    }
}
