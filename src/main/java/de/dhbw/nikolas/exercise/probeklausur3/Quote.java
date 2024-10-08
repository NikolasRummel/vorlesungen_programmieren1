package de.dhbw.nikolas.exercise.probeklausur3;

public class Quote {
    private String text;
    private String person;
    private String role;
    private String source;
    private QuoteType quoteType;

    public Quote(String text, String person, String role, String source, QuoteType quoteType) {
        this.text = text;
        this.person = person;
        this.role = role;
        this.source = source;
        this.quoteType = quoteType;
    }

    public String getCitation() {
        return "From: " + person + "( " + role + ", " + source + ")";
    }


    public String getText() {
        return text;
    }

    public String getPerson() {
        return person;
    }

    public String getRole() {
        return role;
    }

    public String getSource() {
        return source;
    }

    public QuoteType getQuoteType() {
        return quoteType;
    }
}
