package com.techelevator;

import java.util.Random;
import java.util.Scanner;

/*
 The classic game of rock, paper, scissors.
 2 players can throw either rock, paper, or scissors.
 The rules below determine who wins:

    rock beats scissors
    rock loses to scissors

    paper beats rock
    paper loses to scissors

    paper beats rock
    paper loses to scissors

    if both players throw the same thing it's a draw.

 Create a best-of-3 game of rock, paper, scissors where the user
 plays against the computer.

 Use the getRandomNumber method to get a random integer of 0, 1, 2
 Hint: Use an if statement and correlate 0 with rock, 1 with paper, 2 with scissors

 */
public class RockPaperScissors {

    public static void main(String[] args) {

        // CODE BELOW

    }


    /**
     * @return rock, paper, scissors string entered by the user
     */
    public static String getUserInput(){
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Please enter rock, paper, or scissors: ");
        return inputScanner.nextLine();
    }

    /**
     * @return Get a random number: 0, 1, 2
     */
    public static int getRandomNumber(){
        return new Random().nextInt(3);
    }
}
