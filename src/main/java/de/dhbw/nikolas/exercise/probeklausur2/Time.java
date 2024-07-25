package de.dhbw.nikolas.exercise.probeklausur2;

public class Time {
    private int hour, minute;

    public Time(int hour, int minute) {
        if(hour < 0 || hour > 23 || minute < 0 || minute > 59) {
            throw new DBException("Falsche Zeit angegeben - bitte 0-23für stunden, 0-59 für minuten");
        }

        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public String toString() {
        String ih = hour < 10 ? "0" : "";
        String im = minute < 10 ? "0" : "";
        return ih + hour + ":" + im + minute;
    }

}
