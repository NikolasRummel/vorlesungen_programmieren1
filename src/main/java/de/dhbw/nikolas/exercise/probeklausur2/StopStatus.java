package de.dhbw.nikolas.exercise.probeklausur2;

import java.awt.*;

public enum StopStatus {
    ON_SCHEDULE(Color.BLACK, new Color(0, 150, 0)),
    REASONABLE(Color.BLACK, new Color(150, 150, 150)),
    DELAYED(Color.WHITE, Color.RED);

    private Color textColor;
    private Color backgroundColor;

    StopStatus(Color textColor, Color backgroundColor) {
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
    }

    public static StopStatus get(int delay) {
        if (delay <= 0) return StopStatus.ON_SCHEDULE;
        if (delay < 6) return StopStatus.REASONABLE;
        else return StopStatus.DELAYED;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
