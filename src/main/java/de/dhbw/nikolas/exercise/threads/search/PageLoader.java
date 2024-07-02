package de.dhbw.nikolas.exercise.threads.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class PageLoader implements Runnable {

    private String url;
    private String content;
    private boolean loaded = false;

    public PageLoader(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        System.out.println("Gestartet: " + url);
        this.content = getStringContentFromUrl(url, "UTF-8");
        this.loaded = true;
        System.out.println("Geladen: " + url + " (" + this.getFirstChars() + ")");
    }

    public boolean pageLoaded() {
        return loaded;
    }

    public String getContent() {
        return content;
    }

    private String getFirstChars() {
        return getContent().substring(0, 30).replaceAll("\n", "").strip();
    }

    private String getStringContentFromUrl(String url, String encoding) {
        StringBuilder buffer = new StringBuilder();
        String line = null;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new URL(url).openStream(), encoding))) {
            while ((line = br.readLine()) != null) {
                buffer.append(line).append(System.lineSeparator());
            }
        } catch (IOException ex) {
        }
        return buffer.toString();
    }


}
