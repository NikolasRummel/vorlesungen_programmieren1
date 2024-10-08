package de.dhbw.nikolas.exercise.probeklausur3;

import javax.swing.*;

public class QuoteButton extends JButton {

    private QuoteType quoteType;

    public QuoteButton(QuoteType quoteType) {
        setQuoteType(quoteType);
    }

    public QuoteButton() {
        this.setQuoteType(QuoteType.UNKNOWN);
    }

    public boolean isUnknown() {
        return quoteType == QuoteType.UNKNOWN;
    }

    public QuoteType getQuoteType() {
        return quoteType;
    }

    public void setQuoteType(QuoteType quoteType) {
        this.quoteType = quoteType;
        this.setIcon(quoteType.getIcon());
        this.setBackground(quoteType.getColor());
    }
}
