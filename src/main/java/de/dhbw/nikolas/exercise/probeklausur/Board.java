package de.dhbw.nikolas.exercise.probeklausur;

import java.util.ArrayList;

public class Board {

    private ArrayList<Field> fields;

    public Board() {
        this.fields = new ArrayList<>();
        this.fillBoard();
    }

    private void fillBoard() {
        for (int i = 1; i <= 20; i++) {
            fields.add(new Field(String.valueOf(i), i, false));
            fields.add(new Field("D" + i, i * 2, true));
            fields.add(new Field("T" + i, i * 3, false));
        }
        fields.add(new Field("Single Bull", 25, false));
        fields.add(new Field("BULL", 25, true));
        fields.add(new Field("x", 0, false));
    }

    public Field parseField(String label) {
        for (Field field : fields) {
            if (field.getLabel().equals(label)) {
                return field;
            }
        }

        return null;
    }

}
