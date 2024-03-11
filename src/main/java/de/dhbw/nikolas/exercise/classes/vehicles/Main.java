package de.dhbw.nikolas.exercise.classes.vehicles;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[4];
        vehicles[0] = new Bicycle(20.0);
        vehicles[1] = new Car(150.0);
        vehicles[2] = new RacingCar(200.0);
        vehicles[3] = new Ambulance(80.0, true);
        vehicles[0].drive(240.0);
        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i].drive(60);
        }
        for (int i = 0; i < vehicles.length; i++) {
            System.out.println(vehicles[i].toString());
        }
    }
}
