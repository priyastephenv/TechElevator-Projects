package application;

import ui.UserInput;
import ui.UserOutput;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    UserOutput userOutput;
    UserInput userInput;
    FileUtilities fileUtilities;

    public Hangman() {
        userInput = new UserInput();
        userOutput = new UserOutput();
        fileUtilities = new FileUtilities();
    }

    public void run() {
        userOutput.displayWelcome();


        String wordToGuess = fileUtilities.readRandomLineFromFile(); // create a string to hold the random word to be guessed. It is retrieved from the fileUtilities class
        Scanner userInput = new Scanner(System.in); // userInput saves the letter the player guesses
        List<Character> guesses = new ArrayList<>(); // List of Characters that are being guessed


        int failedGuesses = 0; // failed guesses variable is initialized at 0
        int maxNumberOfFailures=6; // max number of failures initialized at 6

        while (failedGuesses <= maxNumberOfFailures) { // while the failed guesses are less than or equal to maxNumberOfFailures (6)
            if (failedGuesses < maxNumberOfFailures) { // if failed guesses are less than max number of failed guesses
                System.out.println("Incorrect guesses: " + failedGuesses + " out of 6."); // print the following:
                if (!getPlayerGuess(userInput, wordToGuess, guesses)) { //if the guess is incorrect,
                    failedGuesses++; //increase failed guesses by 1
                }
            }
            if (failedGuesses == maxNumberOfFailures){ // if failed guesses is equal the max number of failed guesses,
                System.out.println("Sorry, You lose!"); // print the following:
                System.out.println("The word was : " + wordToGuess + "!"); // print the following:
                System.out.println("  ______"); //  print the following:
                System.out.println("  |    |");
                System.out.println(" \\O/   |");
                System.out.println("  |    |");
                System.out.println(" / \\   |");
                System.out.println("       |");
                System.out.println("   ____|____");

                break; // end the loop
            }
            if (gameAtCurrentGuess(wordToGuess, guesses)) { // if every character has been guessed,
                System.out.println("Congratulations, You Win!!"); // print out the following:

                break; // end the loop
            }
        }

    }


 /* This method asks the player to guess a letter in the form of a String. The letter is then saved to a Character List
and returns true if the letter is within the wordToGuess.
  */


    //methods
    public boolean getPlayerGuess(Scanner userInput, String wordToGuess, List<Character> guesses) {

        System.out.print("Enter a guess! (One letter): "); //  print the following:
        String userGuess = userInput.nextLine(); // get user input and put it in the string user guess
        guesses.add((userGuess.charAt(0))); // add the character at the zero index from the user guess to guesses List
        System.out.println(); //print an empty line
        System.out.println(); //print an empty line
        return wordToGuess.contains(userGuess); //return true if the wordToGuess contains the letter that the player guessed
    }

    public boolean gameAtCurrentGuess(String wordToGuess, List<Character> guesses) {
        int correctCount = 0; //correct count counter initialized at 0
        for (int i = 0; i < wordToGuess.length(); i++) { //for loop -as long as the index (i) is less than the length of the wordToGuess
            if (guesses.contains((wordToGuess.charAt(i)))) { // if guesses List contains the character at the current index from the word to guess
                System.out.print(wordToGuess.charAt(i)); // print out the character at the index which it appears
                correctCount ++; // add one to the correct count counter
            } else { //otherwise
                System.out.print(("_")); //print out an underscore
            }
        }
        System.out.println(); //print an empty line
        return (wordToGuess.length() == correctCount); //return true is the player has guesses every letter
    }
}