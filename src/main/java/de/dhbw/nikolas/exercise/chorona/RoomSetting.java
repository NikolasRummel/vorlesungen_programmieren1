package de.dhbw.nikolas.exercise.chorona;

import de.dhbw.klausur.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoomSetting {

    private int height;
    private int width;

    private List<Point> pollutants;

    private int numberPollutants;

    public RoomSetting(int height, int width, int numberPollutants) {
        this.height = height;
        this.width = width;
        this.numberPollutants = numberPollutants;

        this.pollutants = new ArrayList<>();

        int max = height * width;

        if (numberPollutants > max) {
            throw new AHAException("Insufficient singers");
        } else {
            this.fillPollutants();
        }
    }

    private void fillPollutants() {
        while (pollutants.size() < numberPollutants) {
            int rx = Utils.generateRandom(0, width);
            int ry = Utils.generateRandom(0, height);

            Point point = new Point(rx, ry);

            Optional<Point> optionalPoint = pollutants
                    .stream()
                    .filter(point1 -> point1.getX() == rx && point1.getY() == ry)
                    .findFirst();

            if (optionalPoint.isEmpty()) {
                pollutants.add(point);
                System.out.println("Added point: " + point);
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public List<Point> getPollutants() {
        return pollutants;
    }

    public int getNumberPollutants() {
        return numberPollutants;
    }
}
