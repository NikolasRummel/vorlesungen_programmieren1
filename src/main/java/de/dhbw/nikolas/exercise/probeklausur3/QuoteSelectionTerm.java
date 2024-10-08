package de.dhbw.nikolas.exercise.probeklausur3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuoteSelectionTerm extends JFrame {


    private List<FakeTalkClient> clients = new ArrayList<>();

    private List<Quote> quotes;
    private int rows, cols;
    private JPanel panel;

    private boolean started = false;

    private JLabel header;
    private JLabel footer;
    private List<Quote> gameQuotes = new ArrayList<>();
    private List<QuoteButton> gameButtons = new ArrayList<>();

    private int currentClientIndex = 0;
    private int currentQuoteIndex;

    public QuoteSelectionTerm(List<Quote> quotes, int rows, int cols) {
        this.quotes = quotes;
        this.rows = rows;
        this.cols = cols;

        this.gameQuotes = getRandomQuotes();

        int canContain = rows * cols;
        if (quotes.size() < canContain) {
            throw new FakeNewsException("Provided quote catalog does not contain enough (hot/bull)shit!");
        }
    }

    private void initFrame() {
        this.setSize(600, 450);
        this.panel = new JPanel();
        this.panel.setLayout(new BorderLayout());

        header = new JLabel("Pick a quote, " + getCurrentClient().getPlayerName());
        this.panel.add(header, BorderLayout.NORTH);

        JPanel matrixPanel = new JPanel();
        matrixPanel.setLayout(new GridLayout(this.rows, this.cols));

        this.panel.add(matrixPanel);
        this.getRandomQuotes().forEach(quote -> {
            QuoteButton button = new QuoteButton();
            gameButtons.add(button);
            matrixPanel.add(button);

            button.addActionListener(e -> {

            });
        });

        this.panel.add(matrixPanel, BorderLayout.CENTER);

        this.footer = new JLabel(getCurrentClient().getPoints() + "points");
        this.panel.add(footer, BorderLayout.SOUTH);

        this.add(panel);
        this.setVisible(true);
    }

    public void register(FakeTalkClient client) {
        if (started) throw new FakeNewsException("Already started!");
        else {
            System.out.println("added client : " + client.getPlayerName());
            this.clients.add(client);
        }
    }

    public void start() {
        if (started) return;

        if (this.clients.size() < 2) throw new FakeNewsException("Need 2 clients or more!");
        else {
            this.started = true;
            this.initFrame();
        }
    }

    public void answerSelected(FakeTalkClient client, Quote quote, QuoteType selectedType) {
        JOptionPane.showMessageDialog(this.panel, "This quote is " + selectedType.getLabel() + "\n " + quote.getCitation());

        if (quote.getQuoteType() == selectedType) {
            client.addPoints(10);
        } else {
            client.addPoints(-10);
        }

        this.footer.setText(client.getPoints() + "points");
        //TODO: Quotebutton set type

        long count = gameButtons.stream().filter(QuoteButton::isUnknown).count();
        if (count == 0) {
            StringBuilder s = new StringBuilder();
            for (FakeTalkClient fakeTalkClient : this.clients) {
                s.append(fakeTalkClient.getPlayerName()).append("(").append(fakeTalkClient.getPoints()).append(") - ");
            }
            JOptionPane.showMessageDialog(this.panel, "Game finished. Score: " + s);
        } else {
            this.nextPlayer();
        }
    }

    private void nextPlayer() {
        if (currentClientIndex == clients.size()) {
            currentClientIndex = 0;
        } else {
            currentClientIndex++;
        }

        this.updateInfo();

    }

    private void updateInfo() {
        this.footer.setText(getCurrentClient().getPoints() + "points");
        this.header.setText("Pick a quote, " + getCurrentClient().getPlayerName());
    }


    public List<Quote> getRandomQuotes() {
        int count = rows * cols;

        List<Quote> current = this.quotes;
        List<Quote> random = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int rand = new Random().nextInt(current.size());
            Quote newRandom = current.get(rand);
            random.add(newRandom);
            current.remove(rand);
        }

        return random;
    }

    public Quote getNextQuote() {
        Quote next = getRandomQuotes().get(currentQuoteIndex);
        currentQuoteIndex++;
        return next;
    }


    public FakeTalkClient getCurrentClient() {
        return this.clients.get(currentClientIndex);
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
}
