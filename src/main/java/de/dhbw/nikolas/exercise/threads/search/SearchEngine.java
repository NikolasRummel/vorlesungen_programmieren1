package de.dhbw.nikolas.exercise.threads.search;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SearchEngine {

    private static int THREADS = 3;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

    public SearchEngine() {
        String[] websites = {
                "https://www.tagesschau.de/",
                "https://www.sueddeutsche.de",
                "https://www.spiegel.de",
                "https://www.kit.edu",
                "https://nikolas-rummel.de",
                "https://youtube.com",
                "https://x.com",
                "https://dm.de",
        };

        for (int i = 0; i < websites.length; i++) {
            executorService.submit(new PageLoader(websites[i]));
        }
    }

    public static void main(String[] args) {
        new SearchEngine();
    }

}
