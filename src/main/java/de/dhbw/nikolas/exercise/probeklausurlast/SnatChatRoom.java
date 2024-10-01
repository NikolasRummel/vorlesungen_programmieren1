package de.dhbw.nikolas.exercise.probeklausurlast;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SnatChatRoom {

    private List<SnapChatFrontend> frontends = new ArrayList<>();
    private String roomName;
    private Path path;

    public SnatChatRoom(String roomName) {
        this.roomName = roomName;
        this.path = Paths.get("myDir/" + roomName + ".txt");
    }

    private void logMessage(String message) {
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            message = message + "\n";
            //message = Message.rot13(message);
            Files.write(path, message.getBytes(), java.nio.file.StandardOpenOption.APPEND);
        } catch (Exception e) {
        }
    }

    public void register(SnapChatFrontend frontend) {
        this.frontends.add(frontend);
        try {

            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(path));

            for (int i = lines.toArray().length - 10; i < lines.toArray().length; i++) {
                //sendMessage(Message.rot13(lines.get(i)));
                sendMessage(lines.get(i));
            }
        } catch (Exception e) {

        }
    }

    public void unregister(SnapChatFrontend frontend) {
        this.frontends.remove(frontend);
    }

    public void sendMessage(Message message) {
        this.frontends.forEach(frontend -> {
            frontend.receiveMessage(message);
        });
        logMessage(message.getSenderAccount().getName() + ": " + message.getText());
    }

    public void sendMessage(String text) {
        this.frontends.forEach(frontend -> {
            frontend.receiveMessage(text);
        });
        logMessage(text);
    }

    public String getRoomName() {
        return roomName;
    }
}
