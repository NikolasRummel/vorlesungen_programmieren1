package de.dhbw.nikolas.exercise.probeklausurlast;

import de.dhbw.nikolas.exercise.probeklausur2.Time;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SnatChatWindow extends JFrame implements SnapChatFrontend {

    private SnatChatRoom room;
    private Account account;

    private JPanel panel;

    private ChatMessagesComponent chatMessagesComponent;

    public SnatChatWindow(SnatChatRoom room, Account account) {
        this.room = room;
        this.account = account;

        this.initFrame();
    }

    private void initFrame() {
        this.setSize(1000, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel name = new JLabel(account.getName(), SwingConstants.CENTER);
        name.setForeground(account.getColor());
        panel.add(name, BorderLayout.NORTH);

        chatMessagesComponent = new ChatMessagesComponent();
        panel.add(chatMessagesComponent, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        ButtonGroup group = new ButtonGroup();
        JRadioButton availableButton = new JRadioButton(State.AVAILABLE.getLabel());
        JRadioButton awayButton = new JRadioButton(State.AWAY.getLabel());
        JRadioButton dndButton = new JRadioButton(State.DND.getLabel());

        availableButton.addActionListener(e -> {
            account.setState(State.AVAILABLE);
            room.sendMessage("State of " + account.getName() + " is now " + account.getState().getLabel());
        });

        awayButton.addActionListener(e -> {
            account.setState(State.AWAY);
            room.sendMessage("State of " + account.getName() + " is now " + account.getState().getLabel());
        });

        dndButton.addActionListener(e -> {
            account.setState(State.DND);
            room.sendMessage("State of " + account.getName() + " is now " + account.getState().getLabel());
        });

        buttonPanel.setLayout(new GridLayout(2, 3));
        group.add(availableButton);
        group.add(awayButton);
        group.add(dndButton);

        buttonPanel.add(availableButton);
        buttonPanel.add(awayButton);
        buttonPanel.add(dndButton);

        JTextField textField = new JTextField();
        JButton sendButton = new JButton("Send");

        sendButton.addActionListener(e -> {
            if (textField.getText().isEmpty()) {
                String message = "Dear " + account.getName() + " please enter a message";
                JOptionPane.showMessageDialog(this.panel, message, "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {
                room.sendMessage(new Message(textField.getText(), this.account));
                textField.setText("");
            }
        });

        buttonPanel.add(textField);
        buttonPanel.add(sendButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void receiveMessage(Message msg) {
        JLabel label = new JLabel(msg.getSenderAccount().getName() + ": " + msg.getText());
        label.setForeground(msg.getSenderAccount().getColor());
        chatMessagesComponent.add(label);


        AtomicInteger timer = new AtomicInteger(10);
        new Thread(() -> {
            while (timer.get() >= 0) {

                try {
                    timer.getAndDecrement();
                    if (timer.get() == 0) {
                        chatMessagesComponent.remove(label);
                    }

                    String text = msg.getSenderAccount().getName() + ": " + msg.getText() + "[" + timer + "]";
                    label.setText(text);
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
            }
        }).start();


    }

    @Override
    public void receiveMessage(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.GRAY);
        chatMessagesComponent.add(label);
    }

    @Override
    public Account getAccount() {
        return this.account;
    }
}
