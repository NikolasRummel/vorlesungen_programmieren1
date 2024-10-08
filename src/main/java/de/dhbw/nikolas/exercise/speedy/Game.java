package de.dhbw.nikolas.exercise.speedy;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Question> questionPool;
    private List<Question> gameQuestionPool;
    private int questionCount;

    private boolean stated = false;
    private List<GameClient> clients = new ArrayList<>();

    private int currentQuestionIndex;
    private int i;

    private Thread getThread = new Thread(() -> {
        while (true) {
            while (i > 0) {
                try {
                    for (GameClient gameClient : this.clients) {
                        gameClient.setRemainingSeconds(i);
                    }
                    i--;

                    if (i == 0) {
                        clients.forEach(gameClient -> gameClient.setAnswerState(currentQuestionIndex, Status.NO_ANSWER));
                        nextQuestion();
                    }
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        }
    });

    public Game(List<Question> questionPool, int questionCount) throws GameException {
        this.questionPool = questionPool;
        this.questionCount = questionCount;
        this.gameQuestionPool = new ArrayList<>();

        if (questionPool.size() < questionCount) {
            throw new GameException("Too few questions available");
        }

        while (gameQuestionPool.size() < questionCount) {
            int randomIndex = (int) (Math.random() * this.questionPool.size());
            this.gameQuestionPool.add(this.questionPool.get(randomIndex));
            this.questionPool.remove(randomIndex);
        }
    }

    public void startGame() {
        this.stated = true;
        this.currentQuestionIndex = -1; //nextquestion starts with +1
        this.nextQuestion();
        getThread.start();
    }

    public void answerSelected(GameClient client, int index) {
        if (index == getCurrentQuestion().getCorrectIndex()) {
            client.setAnswerState(currentQuestionIndex, Status.CORRECT);
        } else {
            client.setAnswerState(currentQuestionIndex, Status.WRONG);
        }
        for (GameClient gameClient : this.clients) {
            if (gameClient.equals(client)) {
                continue;
            }
            gameClient.setAnswerState(currentQuestionIndex, Status.NO_ANSWER);
        }

        this.nextQuestion();
    }


    private void nextQuestion() {
        i = 10;

        this.currentQuestionIndex = this.currentQuestionIndex + 1;

        if (this.currentQuestionIndex >= this.gameQuestionPool.size()) {
            for (GameClient gameClient : this.clients) {
                gameClient.gameIsOver();
            }
        } else {
            for (GameClient gameClient : this.clients) {
                gameClient.setQuestion(currentQuestionIndex, getCurrentQuestion());
            }
        }
    }

    public void registerClient(GameClient client) {
        if (!stated) this.clients.add(client);
    }


    public int getQuestionCount() {
        return questionCount;
    }

    public Question getCurrentQuestion() {
        return this.gameQuestionPool.get(currentQuestionIndex);
    }
}
