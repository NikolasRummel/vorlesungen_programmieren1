package de.dhbw.nikolas.exercise.probeklausur2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionTerm extends JFrame {

    private TrainConnection connection;
    private JPanel panel;
    private List<StopComponent> stopComponents = new ArrayList<>();

    public ConnectionTerm(TrainConnection connection) {
        this.setTitle(connection.getName());

        this.panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (Stop stop : connection.getStops()) {
            int random = (int) (Math.random() * 20 + 1);
            random = random - 5;

            StopComponent stopComponent = new StopComponent(stop);
            stopComponent.setDelay(random);

            int index = new Random().nextInt(StopComponent.DELAY_REASONS.length);

            if (random > 10) {
                stopComponent.setReason(StopComponent.DELAY_REASONS[index]);
            }

            stopComponents.add(stopComponent);

            this.panel.add(stopComponent);
        }

        AtomicInteger i = new AtomicInteger(0);
        new Thread(() -> {
            while (i.get() < stopComponents.size()) {
                stopComponents.get(i.get()).setStopReached(true);

                int randomDelay = (int) (Math.random() * 4 + 2);
                i.getAndIncrement();
                try {
                    Thread.sleep(randomDelay*1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();


        this.add(panel);
        this.pack();
        this.setVisible(true);
    }

}
