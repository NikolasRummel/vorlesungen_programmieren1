package de.dhbw.nikolas.exercise.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TextFile {

    private List<String> lines;

    private String path;

    public TextFile(String path) {
        this.path = path;
        this.read();
    }

    public void read() {
        try {
            this.lines = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write() {
        try {
            Files.write(Path.of(path), lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getAvailableLines() {
        return lines.size();
    }

    public String[] getLines() {
        String[] lines = new String[this.lines.size()];

        for (int i = 0; i < this.lines.size(); i++) {
            lines[i] = this.lines.get(i);
        }
        return lines;
    }

    public String getLine(int index) {
        return lines.get(index);
    }

    public void setLine(int index, String line) {
        this.lines.set(index, line);
    }

    public void replaceAll(String regexp, String ersatz) {
        for (int i = 0; i < lines.size(); i++) {
            lines.set(i, lines.get(i).replaceAll(regexp, ersatz));
        }
    }

    public void close(){
        this.write();
    }
}
