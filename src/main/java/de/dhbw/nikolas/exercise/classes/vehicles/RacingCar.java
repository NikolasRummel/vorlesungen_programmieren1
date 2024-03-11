package de.dhbw.nikolas.exercise.classes.vehicles;

public class RacingCar extends Vehicle {

    public RacingCar(double speed) {
        super(4, 220, 0, speed);
    }

    @Override
    public void info() {
        System.out.println("RacingCar{" +
                "wheels=" + wheels +
                ", vmax=" + vmax +
                ", position=" + position +
                ", speed=" + speed +
                '}');
    }
}
