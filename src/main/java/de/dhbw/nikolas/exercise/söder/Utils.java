package de.dhbw.nikolas.exercise.söder;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Utils {

    public static int generateRandom(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }

    public static boolean saveInFile(Path path, String message, boolean append) {
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            if (append) {
                Files.write(path, message.getBytes(), java.nio.file.StandardOpenOption.APPEND);
            } else {
                Files.write(path, message.getBytes());
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static List<String> readLinesFromFile(Path path) throws IOException {
        return Files.readAllLines(path);
    }
}