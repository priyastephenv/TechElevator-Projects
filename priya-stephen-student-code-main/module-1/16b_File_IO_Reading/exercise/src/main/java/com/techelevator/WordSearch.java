package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class WordSearch {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);




	public static void main(String[] args) {
		WordSearch wordSearch = new WordSearch();
		wordSearch.run();
	}

	public void run() {
		/* Your code goes here */
		System.out.println("What is the name of the file that should be searched?");

		String pathToFile = userInput.nextLine();


		System.out.println("What word are you looking for?");

		String wordToFind = userInput.nextLine();


		System.out.println ("Should the search be case sensitive?");

		String answer = userInput.nextLine();

		String searchWord = wordToFind.toLowerCase();

		File inputFile = new File(pathToFile);

		Scanner reader = null;
		try {
			reader = new Scanner(inputFile);

			int lineNumber = 1;

			while( reader.hasNextLine()) {

				String lineInput = reader.nextLine();
				String lowercaseInput = lineInput.toLowerCase();


					if (lineInput.contains(wordToFind) && answer.equals("Y")) {

						System.out.println (lineNumber + " " + lineInput);

					}else if (lowercaseInput.contains(searchWord) && answer.equals("N")) {

						System.out.println(lineNumber + " " + lineInput);
					}

				 lineNumber++;
				}



	} catch (FileNotFoundException e) {
			System.out.print ("File not found");
		}
		


	}

}
