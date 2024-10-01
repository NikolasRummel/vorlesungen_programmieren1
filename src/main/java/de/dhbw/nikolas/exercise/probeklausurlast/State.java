package de.dhbw.nikolas.exercise.probeklausurlast;

public enum State {

    AVAILABLE("Available"),
    AWAY("Away"),
    DND("Do not disturb");

    private String label;

    State(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
