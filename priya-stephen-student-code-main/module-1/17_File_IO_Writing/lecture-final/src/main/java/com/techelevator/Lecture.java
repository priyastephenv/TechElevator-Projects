package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

		final String TEST_DIRECTORY = "test-directory";
		File newDirectory = new File(TEST_DIRECTORY);
		File newOutputFile = new File(TEST_DIRECTORY, "new-test-file.txt");
		File newInputFile = new File(TEST_DIRECTORY, "input-file.log");

		if( ! newDirectory.exists() ){
			// If the directory doesn't exist, create it

			boolean isDirectoryCreated = newDirectory.mkdir();
			System.out.println("directory was created: " + isDirectoryCreated);

		} else {
			// Directory DOES exist, create new file

			// Create new files IF they do not exist
			newOutputFile.createNewFile();
			newInputFile.createNewFile();

			// Overwrite previous contents
			try ( Scanner reader = new Scanner(newInputFile);
				  PrintWriter writer = new PrintWriter(newOutputFile)
			) {

				// Read from file, line by line
				while (reader.hasNextLine()){
					String line = reader.nextLine();

					// Have the line from the file
					// Just String manipulation from here!
					String[] words = line.split(" ");

					// Check array is NOT null and has at least 1 word
					if(words != null && words.length > 0) {

						// Write last word in array to the file
						writer.println(words[words.length - 1]);
						writer.flush();        // Makes sure your message is written to the file
					}
				}

				//writer.println("Appreciate\nElevate\nParticipate");

			}

			// Append to the end of the file
//			try (PrintWriter writer = new PrintWriter(new FileOutputStream(newOutputFile, true))) {
//				writer.print("Appreciate\nElevate\nParticipate");
//				writer.flush();        // Makes sure your message is written to the file
//			}
		}


	}

}
