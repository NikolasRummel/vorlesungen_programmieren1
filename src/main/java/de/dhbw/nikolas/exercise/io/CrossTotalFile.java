package de.dhbw.nikolas.exercise.io;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class CrossTotalFile {

    public static void main(String[] args) {
        File dir = new File("myDir");
        dir.mkdir();


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        String number = scanner.nextLine();

        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            sum += c - '0';
        }

        File file = new File(dir, "crossTotal.txt");
        try {
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String line = "Quersumme von " + number + " ist " + sum + "\n";

        try (FileOutputStream outputStream = new FileOutputStream(file, true)) {
            byte[] strToBytes = line.getBytes();
            outputStream.write(strToBytes);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
