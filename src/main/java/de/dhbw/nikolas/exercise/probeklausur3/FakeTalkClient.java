package de.dhbw.nikolas.exercise.probeklausur3;

public interface FakeTalkClient {

    public String getPlayerName();

    public void setQuote(Quote quote);

    public void addPoints(int points);

    public int getPoints();
}
