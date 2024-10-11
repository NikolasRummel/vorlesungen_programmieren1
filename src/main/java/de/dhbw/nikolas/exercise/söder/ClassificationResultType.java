package de.dhbw.nikolas.exercise.söder;

public enum ClassificationResultType {

    CORRECT("Correct", 10),
    INCORRECT("Incorrect", -10),
    NOT_CLASSIFIED("Not classified", 0);

    private String label;
    private int score;

    ClassificationResultType(String label, int score) {
        this.label = label;
        this.score = score;
    }


    public String getLabel() {
        return label;
    }

    public int getScore() {
        return score;
    }
}
