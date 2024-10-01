package de.dhbw.nikolas.exercise.probeklausurlast;

public class Message {

    private String text;
    private Account senderAccount;

    public Message(String text, Account senderAccount) {
        this.text = text;
        this.senderAccount = senderAccount;
    }

    public static String rot13(String message) {
        String msg = message.toLowerCase();
        StringBuilder finalMessage = new StringBuilder();
        for (int i = 0; i < msg.length(); i++) {
            char curr = msg.charAt(i);
            int val = curr-'a';
            char next;
            if(val < 13) {
                 next = (char) (curr +13);

            }else {
                 next = (char) (curr -13);
            }
            String s = String.valueOf(next);
            finalMessage.append(s);
        }
        return finalMessage.toString();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Account getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(Account senderAccount) {
        this.senderAccount = senderAccount;
    }
}
