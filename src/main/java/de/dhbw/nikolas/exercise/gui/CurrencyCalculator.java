package de.dhbw.nikolas.exercise.gui;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * @author Nikolas Rummel
 * @since 22.05.24, 08:05
 */
public class CurrencyCalculator extends JFrame {

    private static final double CONVERSION_FACTOR = 1.09D;

    private JPanel panel;
    private OkHttpClient client = new OkHttpClient();

    public CurrencyCalculator() {
        this.setSize(450, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextField textField = new JTextField();
        textField.setText("Please enter a value to convert");
        panel.add(textField, BorderLayout.NORTH);

        JButton convert1 = new JButton("EUR -> USD");
        JButton convert2 = new JButton("USD -> EUR");
        JButton cancel = new JButton("Cancel");

        JPanel buttonPanel = new JPanel();


        convert1.addActionListener(e -> {
            try {
                double value = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(value * getConversionFactor()));
            } catch (NumberFormatException ex) {
                textField.setText("Please enter a valid number");
            }
        });

        convert2.addActionListener(e -> {
            try {
                double value = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(value / getConversionFactor()));
            } catch (NumberFormatException ex) {
                textField.setText("Please enter a valid number");
            }
        });

        cancel.addActionListener(e -> System.exit(0));

        buttonPanel.add(convert1, BorderLayout.SOUTH);
        buttonPanel.add(convert2, BorderLayout.SOUTH);
        buttonPanel.add(cancel, BorderLayout.SOUTH);

        this.panel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(panel);
        this.setVisible(true);
    }

    private double getConversionFactor() {
        Request request = new Request.Builder()
                .url("https://api.frankfurter.app/latest?from=USD&to=EUR")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String responseBody = response.body().string();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(responseBody);

            return jsonNode.get("rates").get("EUR").asDouble();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0.0;
    }


    public static void main(String[] args) throws InterruptedException {
        new CurrencyCalculator();
        Thread.sleep(10);
    }
}
