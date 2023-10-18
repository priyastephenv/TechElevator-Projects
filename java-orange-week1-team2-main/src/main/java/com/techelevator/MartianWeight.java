package com.techelevator;

import java.util.Scanner;

/*
 In case you've ever pondered how much you weigh on Mars, here's the calculation:
  	Wm = We * 0.378
  	where 'Wm' is the weight on Mars, and 'We' is the weight on Earth

 Using the provided method below, complete the code in the main method
 to accepts a series of Earth weights from the user
 and displays each Earth weight as itself, and its Martian equivalent.

 Use the method Integer.parseInt() to convert a string to its int equivalent,
 for example:
    int weightLbs = Integer.parseInt("98");

 Enter a series of Earth weights (space-separated): 98 235 185
 
 98 lbs. on Earth is 37 lbs. on Mars.
 235 lbs. on Earth is 88 lbs. on Mars.
 185 lbs. on Earth is 69 lbs. on Mars. 
 */
public class MartianWeight {

	public static void main(String[] args) {

		// CODE BELOW
		//saves string array that is made with getEarthWeights
		String [] arrayOfStrings = getEarthWeights();

		int [] arrayOfIntegers = new int [arrayOfStrings.length];
		int [] arrayOfMarsWeights = new int [arrayOfStrings.length];
// makes array of Integers from string array of Earth Weights
		for (int i = 0; i < arrayOfStrings.length; i++) {
			arrayOfIntegers [i] = Integer.parseInt( arrayOfStrings[i]);
		}
// makes array of Mars weights from Integers
		for ( int z = 0; z < arrayOfIntegers.length; z ++) {
			arrayOfMarsWeights[z] = (int) (arrayOfIntegers[z] * 0.378);

			System.out.println( arrayOfIntegers[z] + " lbs. on Earth is " + arrayOfMarsWeights [z] + " lbs. on Mars.") ;
		}

	}


	/**
	 * @return array of Strings that represent earth weights
	 */
	public static String[] getEarthWeights(){
		Scanner userInput = new Scanner(System.in);

		System.out.print("Enter a series of Earth weights (space-separated): ");
		String inputWeights = userInput.nextLine();
		String[] earthWeights = inputWeights.split(" ");

		return earthWeights;
	}
}
