package de.dhbw.nikolas.exercise.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TextFile {

    private List<String> lines;

    public TextFile(String path) {
        try {
            this.lines = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void read() {

    }

}
