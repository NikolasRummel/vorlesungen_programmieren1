package de.dhbw.nikolas.exercise.söder;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResultStore {

    private ClassificationsDisplay display;
    private List<ClassificationResult> results = new ArrayList<>();

    private HashMap<ImageDescription, ScoreNumber> score = new HashMap<>();

    public ResultStore(ClassificationsDisplay display) {
        this.display = display;
    }

    public void addResult(ClassificationResult result) {
        System.out.println(result.getType());
        this.results.add(result);

        if (score.get(result.getImage()) != null) {
            ScoreNumber newScoreNumber = getCurrentScoreNumber(result.getImage());
            newScoreNumber.add(result.getType());
            this.score.put(result.getImage(), newScoreNumber);
        } else {
            this.score.put(result.getImage(), new ScoreNumber(result.getType().getScore(), 1));
        }

        this.display.setValues(result.getImage(), score.get(result.getImage()).getScore(), score.get(result.getImage()).getNumber());
        this.log(result);
    }

    private void log(ClassificationResult result) {
        String log = result.getImage().getLabel() + ";" + result.getType() + "\n";
        Utils.saveInFile(Paths.get("classifications.txt"), log, true);
    }

    private ScoreNumber getCurrentScoreNumber(ImageDescription description) {
        return score.get(description);
    }


    public ClassificationsDisplay getDisplay() {
        return display;
    }

    public List<ClassificationResult> getResults() {
        return results;
    }
}
