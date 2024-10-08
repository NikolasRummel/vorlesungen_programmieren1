package de.dhbw.nikolas.exercise.speedy;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameTerm extends JFrame implements GameClient {

    private Game game;
    private String playerName;

    private int points = 0;

    private JLabel questionTextLabel;
    private JLabel timeLabel;

    private int remainingTime = 10;

    private JButton[] buttons = new JButton[4];
    private List<QuestionNumberLabel> labels = new ArrayList<>();

    public GameTerm(String playerName, Game game) throws HeadlessException {
        this.game = game;
        this.playerName = playerName;

        this.initFrame();
    }

    public void initFrame() {
        this.setTitle(playerName);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 150);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel questionRow = new JPanel();
        questionRow.setLayout(new GridLayout(1, game.getQuestionCount()));

        for (int i = 0; i < game.getQuestionCount(); i++) {
            QuestionNumberLabel label = new QuestionNumberLabel(i + "");
            questionRow.add(label);
            labels.add(label);
        }

        JPanel centerColumn = new JPanel();
        centerColumn.setLayout(new BoxLayout(centerColumn, BoxLayout.Y_AXIS));
        centerColumn.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        questionTextLabel = new JLabel(game.getCurrentQuestion().getQuestionText());
        timeLabel = new JLabel("" + remainingTime);

        centerColumn.add(questionTextLabel);
        centerColumn.add(timeLabel);


        JPanel south = new JPanel();
        south.setLayout(new GridLayout(2, 2));

        for (int i = 0; i < 4; i++) {
            buttons[i] = new JButton(game.getCurrentQuestion().getAnswers()[i]);
            int finalI = i;
            buttons[i].addActionListener(e -> game.answerSelected(this, finalI));
            south.add(buttons[i]);
        }

        panel.add(questionRow, BorderLayout.NORTH);
        panel.add(centerColumn, BorderLayout.CENTER);
        panel.add(south, BorderLayout.SOUTH);

        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public void setQuestion(int questionIndex, Question q) {
        for (int i = 0; i < 4; i++) {
            buttons[i].setText(game.getCurrentQuestion().getAnswers()[i]);
        }
        questionTextLabel.setText(game.getCurrentQuestion().getQuestionText());
    }

    @Override
    public void setRemainingSeconds(int seconds) {
        this.remainingTime = seconds;
        this.timeLabel.setText(String.valueOf(remainingTime));
    }

    @Override
    public void gameIsOver() {
        for (int i = 0; i < this.buttons.length; i++) {
            buttons[i].setEnabled(false);
        }

        JOptionPane.showMessageDialog(this, game.getEndMessage());
    }

    @Override
    public void setAnswerState(int questionIndex, Status status) {
        labels.get(questionIndex).setStatus(status);
    }

    @Override
    public void addPoint() {
        this.points++;
    }
}
