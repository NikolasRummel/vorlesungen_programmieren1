package de.dhbw.nikolas.exercise.probeklausur3;

import javax.swing.*;
import java.awt.*;

public class QuoteTerm extends JFrame implements FakeTalkClient {

    private String person;
    private QuoteSelectionTerm term;
    private QuoteDisplay display;
    private JLabel footer;
    private Quote quote;

    private int points;

    QuoteButton hot = new QuoteButton(QuoteType.HOT_SHIT);
    QuoteButton shit = new QuoteButton(QuoteType.BULLSHIT);

    public QuoteTerm(String person, QuoteSelectionTerm term) throws HeadlessException {
        this.person = person;
        this.term = term;
        this.points = 10;

        this.initFrame();
    }

    public void initFrame() {
        this.setTitle(person);
        this.setSize(500, 350);

        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BorderLayout());

        display = new QuoteDisplay();
        wrapper.add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));

        hot.setEnabled(false);
        shit.setEnabled(false);

        hot.addActionListener(e -> term.answerSelected(term.getCurrentClient(), quote, hot.getQuoteType()));
        shit.addActionListener(e -> term.answerSelected(term.getCurrentClient(), quote, shit.getQuoteType()));

        panel.add(hot);
        panel.add(shit);

        wrapper.add(panel, BorderLayout.CENTER);
        footer = new JLabel(getPoints() + "Points");

        wrapper.add(footer, BorderLayout.SOUTH);
        this.add(wrapper);
        this.setVisible(true);
    }

    public QuoteDisplay getDisplay() {
        return display;
    }

    public void setDisplay(QuoteDisplay display) {
        this.display = display;
    }

    @Override
    public String getPlayerName() {
        return this.person;
    }

    @Override
    public void setQuote(Quote quote) {
        this.quote = quote;
        hot.setEnabled(false);
        shit.setEnabled(false);
        this.display.setText(quote.getText());

    }

    @Override
    public void addPoints(int points) {
        this.points += points;
    }

    @Override
    public int getPoints() {
        return this.points;
    }
}
