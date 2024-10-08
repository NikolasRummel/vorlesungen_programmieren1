package de.dhbw.nikolas.exercise.chorona;

import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ChoronaTerminal extends JFrame {

    private Variant variant;
    private Room room;

    private JLabel stepLabel;

    private List<CellButton> cellButtons;
    private HashMap<Point, CellButton> cellButtonMap;

    public ChoronaTerminal(Variant variant, Room room) {
        this.variant = variant;
        this.room = room;
        this.cellButtons = new ArrayList<>();
        this.cellButtonMap = new HashMap<>();

        this.initFrame();
    }

    private void initFrame() {
        this.setTitle("Chorona - " + variant.getLabel() + "(" + variant.getDesignation() + ")“");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        stepLabel = new JLabel("Steps: " + room.getSteps());

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(room.getSetting().getHeight(), room.getSetting().getWidth()));

        for (int i = 0; i < room.getSetting().getHeight() * room.getSetting().getWidth(); i++) {
            int index = i;
            AtomicBoolean polluter = new AtomicBoolean(false);
            room.getSetting().getPollutants().forEach(point -> {
                int c = point.getY() * room.getSetting().getWidth();
                int a = point.getX();
                int z = a + c;

                if (index == z) {
                    polluter.set(true);
                }
            });

            CellButton button = new CellButton(0, polluter.get());
            this.cellButtons.add(button);

            gridPanel.add(button);
        }

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));

        JButton stepButton = new JButton("Step");
        JButton playButton = new JButton("Play");
        JButton saveButton = new JButton("Save");

        buttonPanel.add(stepButton);
        buttonPanel.add(playButton);
        buttonPanel.add(saveButton);

        stepButton.addActionListener(e -> {
            performStep();
        });

        playButton.addActionListener(e -> {
            playButton.setEnabled(false);
            stepButton.setEnabled(false);
            new Thread(() -> {
                int max = 20;
                while (max > 0) {
                    try {
                        performStep();

                        Thread.sleep(500);
                        max--;
                    } catch (Exception ex) {
                    }
                }
            }).start();
            playButton.setEnabled(true);
            stepButton.setEnabled(true);
        });

        panel.add(stepLabel, BorderLayout.NORTH);
        panel.add(gridPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(panel);

        this.setSize(room.getSetting().getWidth() * 100, room.getSetting().getHeight() * 100 + 100);
        this.setVisible(true);

    }


    private void performStep() {
        room.step();
        stepLabel.setText("Steps: " + room.getSteps());
        AtomicInteger i = new AtomicInteger();
        cellButtons.forEach(cellButton -> {
            int x = i.get() % room.getSetting().getWidth();
            int y = i.get() / room.getSetting().getWidth();
            System.out.println(x + "-" + y);

            cellButton.setDose(room.getDose(x, y));
            i.getAndIncrement();
        });
    }


}
