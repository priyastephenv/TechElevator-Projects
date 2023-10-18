import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
//        try (Scanner reader = new Scanner(wonderland)) {
//
//            int linesRead = 1;
//            final int maxLinesToRead = 10;
//
//            while (reader.hasNextLine() && linesRead <= maxLinesToRead) {
//                String line = reader.nextLine();
//                System.out.println(linesRead + ". " + line);
//
//                linesRead += 1;
//            }
//        } catch (FileNotFoundException e) {
//            /*
//             * 3. Catch the condition if the file is not found
//             */
//            e.printStackTrace();
//        }

        try {
            log("This is the first update to the log");
            log("This is the second update to the log");
            log("This is the third update to the log");
        } catch (IOException e) {
            System.out.println("ERROR: Unable to write to log");
        }
    }

    final String OUTPUT_DIRECTORY = "log";
    final String LOG_FILENAME = "file.log";

    public void log(String message) throws IOException {
        /*
         * Create a Logger that writes a message to an output file along with
         * the current date
         */

        // 1. Create the directory and File objects
        File directory = new File(OUTPUT_DIRECTORY);
        File logFile = new File(OUTPUT_DIRECTORY, LOG_FILENAME);

        // 2. Actually create the file and directory
        directory.mkdir();
        logFile.createNewFile();

        // 3. Create a PrintWrite object to write to the file
        //    PrintWriter(<fileObject>) => write and overwrite
        //    PrintWriter(new FileOutputStream(<fileObject), true)) => write and append
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))){
            // 4. Put the PrintWriter object into a try-with-resources so
            //    it auto-closes

            // 5. Get the current time and date for logging
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a, MMMM dd yyyy ");
            String currentTimeDate = dateTime.format(formatter);

            // 6. Write the message...but need to add timestamp
            writer.println(currentTimeDate + ": " + message);
        }
    }


    public static void main(String[] args) {
        new FileIOExamples().start();
    }
}
