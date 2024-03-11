package de.dhbw.nikolas.exercise.classes.vehicles;

public class Car extends Vehicle {

    public Car(double speed) {
        super(4, 140, 0, speed);
    }

    @Override
    public void info() {
        System.out.println("Car{" +
                "wheels=" + wheels +
                ", vmax=" + vmax +
                ", position=" + position +
                ", speed=" + speed +
                '}');
    }
}
