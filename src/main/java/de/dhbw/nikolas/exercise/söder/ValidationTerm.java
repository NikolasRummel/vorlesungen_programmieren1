package de.dhbw.nikolas.exercise.söder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ValidationTerm extends JFrame {

    private List<ImageDescription> descriptions;
    private ResultStore resultStore;
    private int numberOfImages;

    private JButton mainImageButton = new JButton();

    private List<JButton> referenceButtons = new ArrayList<>();
    private List<ImageDescription> randomDescriptions = new ArrayList<>();

    private int count = 10;
    private Thread thread;

    public ValidationTerm(List<ImageDescription> descriptions, ResultStore resultStore, int numberOfImages) throws ChatterException {
        this.descriptions = descriptions;
        this.resultStore = resultStore;
        this.numberOfImages = numberOfImages;

        if (descriptions.size() < numberOfImages) throw new ChatterException("To many descriptions given!");

        this.selectRandom();
        this.initFrame();
        this.updateImages();

        this.thread = getThread();
        this.thread.start();
    }

    private Thread getThread() {
        return new Thread(() -> {
            while (count > 0) {
                try {
                    setTitle("Valdiation Term (" + count + " Seconds) ");
                    Thread.sleep(1000);
                    count--;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            selectRandom();
            updateImages();
            resultStore.addResult(new ClassificationResult(randomDescriptions.get(0), ClassificationResultType.NOT_CLASSIFIED));
            this.thread = getThread();
            this.thread.start();
        });
    }


    private void selectRandom() {
        randomDescriptions.clear();
        List<ImageDescription> descriptionList = new ArrayList<>(descriptions);
        while (randomDescriptions.size() < numberOfImages) {
            int rIndex = Utils.generateRandom(0, descriptionList.size());
            randomDescriptions.add(descriptionList.get(rIndex));
            descriptionList.remove(rIndex);
        }
    }

    public void updateImages() {
        mainImageButton.setIcon(randomDescriptions.get(0).getReferenceImage());

        List<Integer> possibleIndices = new ArrayList<>();
        for (int i = 0; i < randomDescriptions.size(); i++) {
            possibleIndices.add(i);
            System.out.println(i);
        }

        for (int i = 0; i < referenceButtons.size(); i++) {
            int r = Utils.generateRandom(0, possibleIndices.size());
            int index = possibleIndices.get(r);
            possibleIndices.remove(r);

            referenceButtons.get(index).setIcon(randomDescriptions.get(i).getMainImage());
        }

        count = 10;
    }

    public void initFrame() {
        this.setTitle("Validation Term");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());


        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(1, numberOfImages)); //OR fix to 3

        grid.add(new JLabel());
        mainImageButton.addActionListener(e -> JOptionPane.showMessageDialog(
                this, "Select the matching Image below!",
                "Meldung", JOptionPane.INFORMATION_MESSAGE
        ));

        grid.add(mainImageButton);
        grid.add(new JLabel());
        panel.add(grid, BorderLayout.NORTH);

        JPanel matrix = new JPanel();
        matrix.setLayout(new GridLayout(1, numberOfImages)); //OR fix to 3

        for (int i = 0; i < numberOfImages; i++) {
            JButton button = new JButton();
            matrix.add(button);
            referenceButtons.add(button);


            button.addActionListener(e -> {
                ClassificationResult result;
                if (button.getIcon().equals(randomDescriptions.get(0).getMainImage())) {
                    result = new ClassificationResult(randomDescriptions.get(0), ClassificationResultType.CORRECT);
                } else {
                    result = new ClassificationResult(randomDescriptions.get(0), ClassificationResultType.INCORRECT);
                }
                resultStore.addResult(result);
                this.selectRandom();
                this.updateImages();
            });
        }

        panel.add(matrix, BorderLayout.CENTER);

        JButton newImageButton = new JButton("New Images");

        newImageButton.addActionListener(e -> {
            this.selectRandom();
            this.updateImages();
            resultStore.addResult(new ClassificationResult(randomDescriptions.get(0), ClassificationResultType.NOT_CLASSIFIED));
        });

        panel.add(newImageButton, BorderLayout.SOUTH);

        this.add(panel);
        this.setVisible(true);
    }

    public List<ImageDescription> getDescriptions() {
        return descriptions;
    }

    public ResultStore getResultStore() {
        return resultStore;
    }

    public int getNumberOfImages() {
        return numberOfImages;
    }
}
