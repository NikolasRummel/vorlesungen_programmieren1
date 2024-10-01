package de.dhbw.nikolas.exercise.probeklausurlast;

public interface SnapChatFrontend {
    public void receiveMessage(Message msg);

    public void receiveMessage(String text);

    public Account getAccount();
}
