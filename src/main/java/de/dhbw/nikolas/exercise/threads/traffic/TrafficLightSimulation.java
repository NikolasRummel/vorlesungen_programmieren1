package de.dhbw.nikolas.exercise.threads.traffic;

import javax.swing.*;

public class TrafficLightSimulation {

    public static void main(String[] args) {
        LightPhase red = new LightPhase("red", true, false, false, 5);
        LightPhase redYellow = new LightPhase("red-yellow", true, true, false, 1);
        LightPhase green = new LightPhase("green", false, false, true, 10);
        LightPhase yellow = new LightPhase("yellow", false, true, false, 2);

        red.setNext(redYellow);
        redYellow.setNext(green);
        green.setNext(yellow);
        yellow.setNext(red);

        JFrame f = new JFrame("Traffic Light");

        TrafficLight trafficLight = new TrafficLight(red);
        f.add(trafficLight);

        new Thread(() -> {
            try {
                LightPhase phase = red;
                while (true) {
                    f.repaint();
                    Thread.sleep(phase.getDuration() * 1000L);
                    phase = phase.getNext();
                    trafficLight.setCurrentPhase(phase);
                    System.out.println(phase.getName());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(100, 260);
        f.setVisible(true);
    }
}
