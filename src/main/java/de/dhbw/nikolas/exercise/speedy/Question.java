package de.dhbw.nikolas.exercise.speedy;

public class Question {

    private String questionText;
    private String[] answers;
    private int correctIndex;

    public Question(String questionText, String[] answers, int correctIndex) {
        this.questionText = questionText;
        this.answers = answers;
        this.correctIndex = correctIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int getCorrectIndex() {
        return correctIndex;
    }
}
