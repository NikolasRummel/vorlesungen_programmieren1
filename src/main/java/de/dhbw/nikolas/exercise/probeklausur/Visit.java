package de.dhbw.nikolas.exercise.probeklausur;

import java.util.Arrays;

public class Visit {

    private Field[] fields;

    public Visit(Field[] fields) {
        if(fields.length > 3) {
            throw new IllegalArgumentException("Too many fields! Plese provide 3 or less.");
        }
        this.fields = fields;
    }

    public int getValue() {
        int sum = 0;
        for (int i = 0; i < this.fields.length; i++) {
            sum = sum + this.fields[i].getValue();
        }
        return sum;
    }

    public Field getLastField() {
        return fields[this.fields.length - 1];
    }

    public Field[] getFields() {
        return fields;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "fields=" + Arrays.toString(fields) +
                '}';
    }
}
