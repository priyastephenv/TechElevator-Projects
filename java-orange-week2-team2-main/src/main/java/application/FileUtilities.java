package application;

import javax.swing.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class FileUtilities {
    public static final String VOCAB_FILE = "words.txt";

    /**
     * Use this to get a random word from the VOCAB_FILE
     */
    public static String readRandomLineFromFile() {
        String word = "";

        File wordFile = new File(VOCAB_FILE);

        try (Scanner inputScanner = new Scanner(wordFile)){

            int randomNumber = new Random().nextInt(getTotalWordsInFile(wordFile));

            for (int i = 0; i < randomNumber; i++) {
                word = inputScanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Could not find file at: " + VOCAB_FILE, "ERROR", 1);
        }

        return word;
    }

    public static int getTotalWordsInFile(File wordFile) {
        int totalLines = 0;

        try (Scanner inputScanner = new Scanner(wordFile)){

            while (inputScanner.hasNextLine()) {
                totalLines++;
                inputScanner.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return totalLines;

    }
}
