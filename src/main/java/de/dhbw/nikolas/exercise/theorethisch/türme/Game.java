package de.dhbw.nikolas.exercise.theorethisch.türme;

public class Game {

    public static void main(String[] args) {

    }


    public void start() {

    }
    public static void move(int n, int[][] towers, int from, int to, int help) {
        if (n == 1) {
            move(towers, from, to);
            printTowers(towers);
        } else {
            move(n - 1, towers, from, help, to);
            move(towers, from, to);
            printTowers(towers);
            move(n - 1, towers, help, to, from);
        }
    }


    private static void move(int[][] towers, int from, int to) {
        int i = 0;
        while (towers[i][from] == 0) {
            i++;
        }
        int j = 0;
        while (towers[j][to] == 0) {
            j++;
        }
        towers[j - 1][to] = towers[i][from];
        towers[i][from] = 0;
    }


    public static void printTowers(int[][] towers) {
        for (int i = 0; i < towers.length; i++) {
            for (int j = 0; j < towers[i].length; j++) {
                System.out.print(towers[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
