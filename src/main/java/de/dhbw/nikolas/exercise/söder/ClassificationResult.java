package de.dhbw.nikolas.exercise.söder;

public class ClassificationResult {

    private ImageDescription image;
    private ClassificationResultType type;

    public ClassificationResult(ImageDescription image, ClassificationResultType type) {
        this.image = image;
        this.type = type;
    }

    public ImageDescription getImage() {
        return image;
    }

    public ClassificationResultType getType() {
        return type;
    }
}
