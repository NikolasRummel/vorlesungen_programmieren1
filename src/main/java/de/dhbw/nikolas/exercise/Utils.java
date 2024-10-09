package de.dhbw.nikolas.exercise;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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

    //Path path = Paths.get("folder/file.txt");
    public static List<String> readLinesFromFile(Path path) throws IOException {
        return Files.readAllLines(path);
    }

    /* FURTHER EXAMPLES BELOW */
    public void schedule() {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(() -> {

        }, 1, 1, TimeUnit.SECONDS);
    }

    //  UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

    public static Point getGridPosition(int index, int gridWidth) {
        // x is the column position
        int x = index % gridWidth;
        // y is the row position
        int y = index / gridWidth;
        return new Point(x, y);
    }

    public static void showDialog() {
        JOptionPane.showMessageDialog(null, "Message", "Title", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null, "Message", "Title", JOptionPane.INFORMATION_MESSAGE);
    }

    public static String showInputDialog() {
        return JOptionPane.showInputDialog(null, "Enter your input:", "Input Dialog", JOptionPane.QUESTION_MESSAGE);
    }

    public static boolean showConfirmationDialog() {
        int option = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
        return option == JOptionPane.YES_OPTION;
    }

    public void gridBagLayout() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Adding a label at (0,0)
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel("Name:"), gbc);

        // Adding a text field at (1,0)
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        panel.add(new JTextField(15), gbc);

        // Adding a label at (0,1)
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        panel.add(new JLabel("Email:"), gbc);

        // Adding a text field at (1,1)
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(new JTextField(15), gbc);

        // Adding a button that spans 2 columns
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(new JButton("Submit"), gbc);
    }
}
