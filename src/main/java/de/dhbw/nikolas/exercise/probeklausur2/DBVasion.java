package de.dhbw.nikolas.exercise.probeklausur2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class DBVasion {

    public static void main2(String[] args) {
        loadConnections().forEach(trainConnection -> System.out.println(trainConnection));
    }

    public static void main(String[] args) {
        try {
            // Ensure cross platform look&feel on all platforms, including MacOS for foreground/background color support
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
        }

        try {
            List<TrainConnection> connections = loadConnections();

            new ConnectionSelectionTerm(connections);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public static List<TrainConnection> loadConnections() throws DBException {
        List<TrainConnection> conns = new LinkedList<>();

        Path path = Paths.get("myDir/connections.txt");
        try {
            Files.readAllLines(path).forEach(s -> {
                TrainConnection connection = DBVasion.parseTrainConnection(s);
                if (connection != null) {
                    conns.add(connection);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (TrainConnection tc : conns) {
            tc.setStops(DBVasion.loadTrainStops(tc.getName()));
        }

        return conns;
    }

    private static List<Stop> loadTrainStops(String trainName) throws DBException {
        String[] dummies = new String[]{
                "10:17;0;Hamburg-Altona;11",
                "10:25;1;Hamburg Dammtor;4",
                "10:31;3;Hamburg Hbf;5",
                "12:08;2;Berlin-Spandau;5",
                "12:20;9;Berlin Hbf (tief);1",
                "12:34;2;Berlin Südkreuz;3",
                "13:10;1;Lutherstadt Wittenberg Hbf;2",
                "13:42;6;Leipzig Hbf;14",
                "14:29;2;Erfurt Hbf;1",
                "15:14;2;Bamberg;3",
                "15:36;2;Erlangen;4",
                "15:52;3;Nürnberg Hbf;9",
                "17:01;0;München Hbf;20"
        };


        String filename = trainName + ".txt"; // train name "ICE-123" => ICE-123.txt
        Path path = Paths.get("myDir/" + filename);

        List<Stop> stops = new LinkedList<>();
        try {
            Files.readAllLines(path).forEach(s -> {
                Stop stop = DBVasion.parseStops(s);
                if (stop != null) {
                    stops.add(stop);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return stops;
    }

    private static TrainConnection parseTrainConnection(String line) {
        String[] parts = line.split("[;]");
        if (parts.length == 5) {
            boolean regional = Boolean.parseBoolean(parts[3]);
            double price = Double.parseDouble(parts[4]);
            return new TrainConnection(parts[0], parts[1], parts[2], regional, price);
        }
        return null;
    }


    private static Stop parseStops(String line) throws DBException {
        String[] parts = line.split("[;]");
        if (parts.length == 4) {
            String name = parts[2];
            int stayPeriod = Integer.parseInt(parts[1]);
            int stage = Integer.parseInt(parts[3]);

            String[] timeParts = parts[0].split("[:]");
            Time time = new Time(Integer.parseInt(timeParts[0]), Integer.parseInt(timeParts[1]));


            return new Stop(name, time, stayPeriod, stage);
        }
        return null;
    }

    public static ImageIcon createDLTicketIcon() {
        int barH = 4;
        int width = 16;
        BufferedImage img = new BufferedImage(width, barH * 3, BufferedImage.TYPE_3BYTE_BGR);
        Graphics g = img.createGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, barH);
        g.setColor(Color.RED);
        g.fillRect(0, barH, width, barH);
        g.setColor(Color.YELLOW);
        g.fillRect(0, barH * 2, width, barH);
        g.dispose();
        return new ImageIcon(img);
    }

}
