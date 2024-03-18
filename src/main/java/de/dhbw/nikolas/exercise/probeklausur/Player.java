package de.dhbw.nikolas.exercise.probeklausur;

public class Player {

    private String name;
    private int countDartsThrown;
    private Visit[] visits;

    public Player(String name) {
        this.name = name;
        this.countDartsThrown = 0;
        this.visits = new Visit[10];
    }

    public static void main(String[] args) {
        Player player = new Player("awd");
    }

    public int getRemainingPoints() {
        int remaining = 501;

        for (Visit visit : this.visits) {
            if (visit == null) continue;

            for (Field field : visit.getFields()) {
                remaining = remaining - field.getValue();
            }
        }

        return remaining;
    }

    public boolean addVisit(Visit visit) {
        this.countDartsThrown += 3;

        int currentRemainingPoints = this.getRemainingPoints();

        int sum = 0;
        for (Field f : visit.getFields()) {
            if (f == null) continue;
            sum = sum + f.getValue();
        }

        int afterRemainingPoints = currentRemainingPoints - sum;

        if (afterRemainingPoints >= 0) {
            for (int i = 0; i < visits.length; i++) {
                if (visits[i] == null) {
                    if (afterRemainingPoints == 1) {
                        return false;
                    } else if (afterRemainingPoints == 0) {
                        if (visit.getLastField().isDoubleField()) {
                            this.visits[i] = visit;
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        this.visits[i] = visit;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean finishedThrowing() {
        return this.countDartsThrown == 30;
    }

    public String getName() {
        return name;
    }

    public int getCountDartsThrown() {
        return countDartsThrown;
    }

    public Visit[] getVisits() {
        return visits;
    }
}
