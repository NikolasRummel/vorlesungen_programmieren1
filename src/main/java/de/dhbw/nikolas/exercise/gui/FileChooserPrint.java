package de.dhbw.nikolas.exercise.gui;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author Nikolas Rummel
 * @since 22.05.24, 09:07
 */
public class FileChooserPrint {
    public static void main(String[] args) throws IOException {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() ||
                        f.getName().toLowerCase().endsWith(".txt");
            }

            @Override
            public String getDescription() {
                return "Text Files";
            }
        });
        int state = fc.showOpenDialog(null);
        if (state == JFileChooser.APPROVE_OPTION) {
            System.out.println(fc.getSelectedFile().getAbsolutePath());

            JFrame frame = new JFrame();
            frame.setSize(400, 400);
            JTextArea textArea = new JTextArea();

            StringBuilder text = new StringBuilder();
            Files.readAllLines(fc.getSelectedFile().toPath()).forEach(s -> text.append(s).append("\n"));
            textArea.setText(text.toString());

            frame.add(textArea);
            frame.setVisible(true);
        } else {
            System.out.println("No selection");
        }
    }
}
