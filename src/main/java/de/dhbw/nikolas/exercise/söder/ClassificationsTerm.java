package de.dhbw.nikolas.exercise.söder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClassificationsTerm extends JFrame implements ClassificationsDisplay {

    private List<ImageDescription> imageDescriptions;

    private HashMap<ImageDescription, JLabel> scoresMap = new HashMap<>();
    private HashMap<ImageDescription, JLabel> numberMap = new HashMap<>();

    public ClassificationsTerm(List<ImageDescription> imageDescriptions) {
        this.imageDescriptions = imageDescriptions;

        this.initFrame();
    }

    private void initFrame() {
        this.setTitle("Classifications Term");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.add(new JLabel("Images to verify: " + imageDescriptions.size()), BorderLayout.NORTH);

        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(1 + imageDescriptions.size(), 3));


        grid.add(new JLabel("TITEL"));
        grid.add(new JLabel("SCORE"));
        grid.add(new JLabel("NUMBER"));

        for (ImageDescription description : imageDescriptions) {
            JLabel name = new JLabel(description.getLabel());
            JLabel score = new JLabel("0");
            JLabel number = new JLabel("0");

            scoresMap.put(description, score);
            numberMap.put(description, number);

            grid.add(name);
            grid.add(score);
            grid.add(number);
        }

        panel.add(grid);

        this.add(panel);
        this.pack();
        this.setVisible(true);
    }


    @Override
    public void setValues(ImageDescription description, int score, int number) {
        scoresMap.get(description).setText("" + score);
        numberMap.get(description).setText("" + number);
    }
}
