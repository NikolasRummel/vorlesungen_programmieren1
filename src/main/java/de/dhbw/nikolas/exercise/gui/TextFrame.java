package de.dhbw.nikolas.exercise.gui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Nikolas Rummel
 * @since 08.05.24, 11:22
 */
public class TextFrame extends JFrame {

    private Path path;
    private JTextArea textArea;

    public TextFrame(String fileName, int width, int height) {
        this.path = Paths.get("myDir/" + fileName);
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            this.textArea = new JTextArea();
            StringBuilder text = new StringBuilder();
            Files.readAllLines(path).forEach(s -> text.append(s).append("\n"));
            textArea.setText(text.toString());

            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            this.add(textArea);

            this.setVisible(true);

            this.updateText();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateText() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    StringBuilder text = new StringBuilder();
                    Files.readAllLines(path).forEach(s -> text.append(s).append("\n"));
                    textArea.setText(text.toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }, 0, 10); // 1000 milliseconds = 1 second
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java TextFrame <filename> <width> <height>");
            System.exit(1);
        }
        new TextFrame(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
    }
}
