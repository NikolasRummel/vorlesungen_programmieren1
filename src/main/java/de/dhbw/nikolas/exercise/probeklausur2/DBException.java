package de.dhbw.nikolas.exercise.probeklausur2;

public class DBException extends RuntimeException {

    public DBException(String message) {
        super(message);
    }

    public DBException() {
        super("DBExeption");
    }
}
