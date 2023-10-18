package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        FindAndReplace findAndReplace = new FindAndReplace();
        findAndReplace.run();
    }

    public void run() {
        System.out.println ("What is the search word?");

        String searchWord = userInput.nextLine();

        System.out.println ("What is the replacement word?");

        String replacementWord = userInput.nextLine();

        System.out.println ("What is the source file?");

        String pathToSourceFile = userInput.nextLine();

        File sourceFile = new File (pathToSourceFile);


        System.out.println ("What is the destination file?");

        String pathToDestinationFile = userInput.nextLine();

        File outputFile = new File( pathToDestinationFile);




        try (Scanner dataInput = new Scanner(sourceFile);
        PrintWriter dataOutput = new PrintWriter(outputFile)) {

            while (dataInput.hasNextLine()) {

                String lineOfInput = dataInput.nextLine();
                dataOutput.println(lineOfInput.replace(searchWord, replacementWord));
            }

        }catch (FileNotFoundException e) {

            System.err.println ("Cannot open the file for writing.");
        }




    }

}
