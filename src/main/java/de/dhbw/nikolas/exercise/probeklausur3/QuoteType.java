package de.dhbw.nikolas.exercise.probeklausur3;

import javax.swing.*;
import java.awt.*;

public enum QuoteType {

    UNKNOWN("Unknown", FakeTalkIcons.ICON_UNKNOWN, Color.LIGHT_GRAY),
    HOT_SHIT("Hot shit", FakeTalkIcons.ICON_HOT_SHIT, Color.GREEN),
    BULLSHIT("Bullshit", FakeTalkIcons.ICON_BULLSHIT, new Color(74, 65, 42));

    private String label;
    private ImageIcon icon;
    private Color color;

    QuoteType(String label, ImageIcon icon, Color color) {
        this.label = label;
        this.icon = icon;
        this.color = color;
    }

    public String getLabel() {
        return label;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public Color getColor() {
        return color;
    }
}
