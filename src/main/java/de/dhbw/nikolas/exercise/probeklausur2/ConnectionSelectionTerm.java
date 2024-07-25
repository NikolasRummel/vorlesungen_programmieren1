package de.dhbw.nikolas.exercise.probeklausur2;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionSelectionTerm extends JFrame {


    private List<TrainConnection> connections;
    private JPanel panel;
    JTextField textField;

    public ConnectionSelectionTerm(List<TrainConnection> connections) {
        this.connections = connections;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Name");
        this.textField = new JTextField();

        panel.add(label);
        panel.add(textField);

        for (TrainConnection connection : this.connections) {
            JPanel panel1 = new JPanel();
            panel1.setLayout(new FlowLayout());
            JButton train = new JButton(connection.getName());
            JButton buy = new JButton("Buy Ticket");

            if (connection.isRegional()) {
                train.setIcon(DBVasion.createDLTicketIcon());
            }

            train.addActionListener(e -> {
                clickTrain(connection);
            });

            buy.addActionListener(e -> {
                clickBuy(connection);
            });


            panel1.add(train);
            panel1.add(buy);
            this.panel.add(panel1);
        }

        this.add(panel);
        this.pack();
        this.setVisible(true);
    }

    public void clickBuy(TrainConnection connection) {
            if (textField.getText().isBlank() || textField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this.panel, "Please enter a name");
            } else {

                double price = connection.getPrice();
                String msg = "Regular price: " + price + ". Do you want to buy a 'Supersparpreis' ticket? (80% discount)";

                boolean discount = JOptionPane.showConfirmDialog(
                        this.panel, msg, "Discount?", JOptionPane.YES_NO_OPTION
                ) == JOptionPane.YES_OPTION;

                double finalPrice = discount ? price * 0.8 : price;
                String ticketType = discount ? "Supersparpreis" : "Regular";
                String buymsg = "Ticket for " + connection.getName() + ": " + textField.getText() + "(EUR: " + finalPrice + "€ - " + ticketType + ")";

                JOptionPane.showMessageDialog(this.panel, buymsg);
                saveInFile(buymsg);
        }
    }

    private void saveInFile(String input) {
        try {
            Path path = Paths.get("myDir/tickets.txt");

            if (!Files.exists(path)) {
                Files.createFile(path);
            }

            String line = input + "\n";
            Files.write(path, line.getBytes(), java.nio.file.StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickTrain(TrainConnection connection) {
        Random random = new Random();
        double r = random.nextDouble();
        if (r < 0.1) {
            JOptionPane.showMessageDialog(this.panel, "This connection was cancelled");
        } else {
            new ConnectionTerm(connection);
        }
    }


}
