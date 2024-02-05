package de.dhbw.nikolas.exercise.classes;

public class Radio {

    private static final int MAX_VOLUME = 10;
    private static final double MAX_FREQUENCY = 110.0;
    private static final int MIN_VOLUME = 0;
    private static final double MIN_FREQUENCY = 85.0;

    private boolean on;
    private int volume;
    private double frequency;

    public Radio() {
        this.on = false;
        this.volume = 5;
        this.frequency = 100.0;
    }

    public Radio(boolean on, int volume, double frequency) {
        this.on = on;

        if (volume >= MIN_VOLUME && volume <= MAX_VOLUME) {
            this.volume = volume;
        } else {
            this.volume = 5;
        }

        if (frequency >= MIN_FREQUENCY && frequency <= MAX_FREQUENCY) {
            this.frequency = frequency;
        } else {
            this.frequency = 100.0;
        }
    }

    public void incrementVolume() {
        if (isOn()) return;

        if (volume < MAX_VOLUME) {
            ++volume;
        }
    }

    public void decrementVolume() {
        if (isOn()) return;

        if (volume > MIN_VOLUME) {
            --volume;
        }
    }

    public double getFrequency() {
        return frequency;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isOn() {
        return this.on;
    }

    public void turnOn() {
        this.on = true;
    }

    public void turnOff() {
        this.on = true;
    }

    public void setVolume(int volume) {
        if (isOn()) return;

        if (volume >= MIN_VOLUME && volume <= MAX_VOLUME) {
            this.volume = volume;
        }
    }

    public void setFrequency(double volume) {
        if (volume >= MIN_FREQUENCY && volume <= MAX_FREQUENCY) {
            this.frequency = volume;
        } else {
            this.frequency = 99.9;
        }
    }

    @Override
    public String toString() {
        return "Radio{" +
                "on=" + on +
                ", volume=" + volume +
                ", frequency=" + frequency +
                '}';
    }
}
