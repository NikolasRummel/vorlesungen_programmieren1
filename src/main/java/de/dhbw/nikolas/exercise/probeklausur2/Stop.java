package de.dhbw.nikolas.exercise.probeklausur2;

public class Stop {
    private String name; //bahnhof
    private Time arrival;
    private int stayPeriod;
    private int stage;

    public Stop(String name, Time arrival, int stayPeriod, int stage) {
        this.name = name;
        this.arrival = arrival;
        this.stayPeriod = stayPeriod;
        this.stage = stage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getArrival() {
        return arrival;
    }

    public void setArrival(Time arrival) {
        this.arrival = arrival;
    }

    public int getStayPeriod() {
        return stayPeriod;
    }

    public void setStayPeriod(int stayPeriod) {
        this.stayPeriod = stayPeriod;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    @Override
    public String toString() {
        return "Stop{" +
                "name='" + name + '\'' +
                ", arrival=" + arrival +
                ", stayPeriod=" + stayPeriod +
                ", stage=" + stage +
                '}';
    }
}
