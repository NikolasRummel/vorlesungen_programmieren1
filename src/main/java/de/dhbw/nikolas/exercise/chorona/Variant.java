package de.dhbw.nikolas.exercise.chorona;

public enum Variant {

    WILD_TYPE("Wildtyp", "SARS-CoV-2"),
    DELTA ("Delta", "logic.B.1.617"),
    ALPHA ("Alpha", "logic.B.1.1.7"),
    FETA ("Feta" ,"O.u.z.o"),
    BETA ("Beta", "logic.B.1.351"),
    LAMBDA ("Lambda", "C.37"),
    GAMMA ("Gamma", "P.1"),
    OMICRON ("Omikron", "logic.B.1.1.529");

    private final String label;
    private final String designation;

    Variant(String label, String designation) {
        this.label = label;
        this.designation = designation;
    }

    public String getLabel() {
        return label;
    }

    public String getDesignation() {
        return designation;
    }
}
