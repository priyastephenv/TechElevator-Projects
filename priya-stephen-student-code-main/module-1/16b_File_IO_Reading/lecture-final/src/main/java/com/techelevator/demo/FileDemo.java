package com.techelevator.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileDemo {

    public static void main(String[] args) {
        new FileDemo().start();
    }

    public void start() {
        System.out.println("Calling start...");
        run();
        System.out.println("After calling the run method");
    }

    public void run() {
        System.out.println("Calling run...");

        File testFile = new File("test-file.txt");
        File dummyFile = new File("adfafev.txt");
        File errorLog = new File("src/main/java/com/techelevator/exceptions/errors.log");

        System.out.println("Dummy File exists: " + dummyFile.exists());
        //dummyFile.createNewFile()

        if(testFile.exists()){
            System.out.println("File exists at: " + testFile.getAbsolutePath());

            // Open a scanner to read the file object
            try(Scanner inputScanner = new Scanner(testFile)){

                int lineNumber = 1;

                // DON'T DO THIS. Example to show what happens when
                // an exception is not caught
                String str = null;
                str.toLowerCase();

                // While there is a line to read from the file
                while( inputScanner.hasNextLine() ){

                    // Read a single line
                    String lineFromFile = inputScanner.nextLine();
                    System.out.println(lineNumber +". " + lineFromFile);
                    lineNumber += 1;
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("AFTER try-catch block");
        }
    }
}
