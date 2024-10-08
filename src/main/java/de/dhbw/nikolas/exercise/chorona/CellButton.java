package de.dhbw.nikolas.exercise.chorona;

import javax.swing.*;
import java.awt.*;

public class CellButton extends JButton {

    private double dose;
    private boolean polluter;

    public CellButton(double dose, boolean polluter) {
        this.setDose(dose); // to satisfy initial UpdateButtonForDose Method
        this.polluter = polluter;

        if (this.polluter) {
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        }
    }

    public void setDose(double dose) {
        this.dose = dose;

        Chorona.updateButtonForDose(this, dose);
    }
}
