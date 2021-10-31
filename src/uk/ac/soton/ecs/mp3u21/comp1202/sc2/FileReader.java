package uk.ac.soton.ecs.mp3u21.comp1202.sc2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    String text = "";

    public String readFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                text += line.trim();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return text;
    }

}
