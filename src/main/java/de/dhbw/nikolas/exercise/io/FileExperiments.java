package de.dhbw.nikolas.exercise.io;

import java.io.File;

public class FileExperiments {

    public static void main(String[] args)  {
        File dir = new File("myDir");
        dir.mkdir();

        File foo1 = new File(dir, "foo1.txt");
        File foo2 = new File(dir, "foo2.txt");
        File foo3 = new File(dir, "foo3.txt");

        try {
            foo1.createNewFile();
            foo2.createNewFile();
            foo3.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(dir.getAbsolutePath());
        for (File file : dir.listFiles()) {
            System.out.println(file.getName());
        }


        foo1.delete();
        foo2.delete();
        foo3.delete();

        dir.delete();
    }
}
