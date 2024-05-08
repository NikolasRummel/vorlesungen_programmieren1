package de.dhbw.nikolas.exercise.gui;

import javax.swing.*;
import java.util.Arrays;

/**
 * @author Nikolas Rummel
 * @since 08.05.24, 09:49
 */
public class ComponentFrame extends JFrame {

    public ComponentFrame() {
        this.setSize(600, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JMenuBar menuBar = new JMenuBar();
        JMenuItem item1 = new JMenuItem("MenuItem 1");
        JMenuItem item2 = new JMenuItem("MenuItem 2");
        menuBar.add(item1);
        menuBar.add(item2);
        this.setJMenuBar(menuBar);

        JPanel panel = new JPanel();

        JButton button = new JButton("Button");

        button.addActionListener(e -> JOptionPane.showMessageDialog(this, "Button clicked"));

        panel.add(button);
        panel.add(new JLabel("Label"));
        panel.add(new JTextField("Textfield"));
        panel.add(new JCheckBox("Checkbox"));
        panel.add(new JRadioButton("RadioButton"));
        panel.add(new JSlider());
        panel.add(new JProgressBar());
        panel.add(new JSpinner());
        panel.add(new JList());
        panel.add(new JTable());
        panel.add(new JTree());
        panel.add(new JTabbedPane());

        String list[] = {"Baden-Württemberg", "Bayern",
                "Berlin", "Brandenburg", "Bremen",
                "Hamburg", "Hessen", "Mecklenburg-Vorpommern",
                "Niedersachsen", "Nordrhein-Westfalen", "Rheinland-Pfalz",
                "Saarland", "Sachsen", "Sachsen-Anhalt",
                "Schleswig-Holstein", "Thüringen"};

        panel.add(new JComboBox(list));
        this.add(panel);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ComponentFrame();
    }

}
