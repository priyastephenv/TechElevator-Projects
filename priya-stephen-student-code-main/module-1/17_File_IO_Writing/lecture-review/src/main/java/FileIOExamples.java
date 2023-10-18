import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIOExamples {

    public static final String FILENAME = "alices_adventures_in_wonderland.txt";

    public void start() {

        /*
         * 1. Get a file Object to represent a path and filename
         */
        File wonderland = new File(FILENAME);

        /*
         * 2. Open a Scanner object to read the file
         */
        try (Scanner reader = new Scanner(wonderland)) {

            int linesRead = 1;
            final int maxLinesToRead = 10;

            while (reader.hasNextLine() && linesRead <= maxLinesToRead) {
                String line = reader.nextLine();
                System.out.println(linesRead + ". " + line);

                linesRead += 1;
            }
        } catch (FileNotFoundException e) {
            /*
             * 3. Catch the condition if the file is not found
             */
            e.printStackTrace();
        }
    }

    public void Log(String message) {

        /*
         * Create a Logger that writes a message to an output file along with
         * the current date
         */

    }


    public static void main(String[] args) {
        new FileIOExamples().start();
    }
}
