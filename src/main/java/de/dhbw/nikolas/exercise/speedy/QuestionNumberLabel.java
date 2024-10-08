package de.dhbw.nikolas.exercise.speedy;

import javax.swing.*;

public class QuestionNumberLabel extends JLabel {

    private Status status;

    public QuestionNumberLabel(String text) {
        super(text);
        this.setStatus(Status.PENDING);
        this.setOpaque(true);
        this.setHorizontalAlignment(JLabel.CENTER);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
        this.setBackground(status.getColor());
    }
}
