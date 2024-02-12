package de.dhbw.nikolas.exercise.arrays;

import java.util.Arrays;

public class SiebDesEratostenes {

    /**
     * Die *-Aufgaben sind für alle, die schon Erfahrung im Programmieren haben und/oder schon früher
     * fertig geworden sind; manchmal anspruchsvoller, manchmal für Fleißige.
     * Der folgende Algorithmus („Sieb des Eratostenes“) ermittelt alle Primzahlen zwischen 2 und einer
     * vorgegebenen Grenze n:
     * (1) Menge sieve = alle natürlichen Zahlen von 2 bis n
     * (2) Menge primes = leere Menge
     * (3) wiederhole die Schritte (4) bis (6) solange, bis sieve leer wird
     * (4) bestimme die kleinste Zahl min in sieve
     * (5) füge min zu primes hinzu
     * (6) entferne min und alle seine ganzzahligen Vielfachen aus sieve
     * Schreiben Sie ein Programm, das diesen Algorithmus implementiert, z.B. für n = 100.
     * Tipp:
     * Sie können ein
     *
     */



    public static void main(String[] args) {
        int n = 100;
        int[] sieve = new int[n];
        int[] primes = new int[n];

        int primesFound = 0;

        boolean finished = false;


        // array befüllen
        for (int i = 0; i < sieve.length; i++) {
            sieve[i] = i + 2;
        }

        while (!finished) {
            int min = Integer.MAX_VALUE;
            // min suchen
            for(int i = 0; i < sieve.length; i++) {
                if (sieve[i] != 0 && sieve[i] < min) {
                    min = sieve[i];
                    break;
                }
            }

            // min zu primes hinzufügen
            primesFound++;
            primes[primesFound] = min;

            // alle entfernen, die durch min teilbar sind
            for (int i = 0; i <  sieve.length; i++) {
                if (sieve[i] % min == 0) {
                    sieve[i] = 0;
                }
            }

            System.out.println("Sieve: " + Arrays.toString(sieve));
            System.out.println("Primzahlen: " + Arrays.toString(primes));

            //checken ob fertig
            boolean empty = true;
            for (int i = 0; i < primes.length-1; i++) {
                if (sieve[i] != 0) {
                    empty = false;
                }
            }





            //fertig
            if (empty) {
                finished = true;
            } else {
                System.out.println("Not finished yet");
            }
        }

    }
}
