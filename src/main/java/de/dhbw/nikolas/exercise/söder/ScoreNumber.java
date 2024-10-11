package de.dhbw.nikolas.exercise.söder;

public class ScoreNumber {
    private int score, number;

    public ScoreNumber(int score, int number) {
        this.score = score;
        this.number = number;
    }

    public void add(ClassificationResultType type) {
        this.score = this.score + type.getScore();
        this.number = this.number + 1;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
