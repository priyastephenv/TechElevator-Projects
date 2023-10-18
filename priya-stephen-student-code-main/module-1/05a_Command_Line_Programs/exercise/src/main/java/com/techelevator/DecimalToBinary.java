package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter some numbers: ");

		String inputFromScanner = scanner.nextLine();

		String [] inputArr = inputFromScanner.split( " ");

		for (int i =0; i < inputArr.length; i ++) {
			System.out.println (inputArr [i] + " in binary is: " + convert (inputArr [i]));
		}

	}

	public static String convert (String inputFromArray) {

		String binary = " ";

		int variableAsInt = Integer.parseInt(inputFromArray);

		//  variable = 8 , 4 , 2 , 1

		while (variableAsInt > 0) {
             // remainder = 0 , 0 , 0, 0, 1
			int variableRemainder = (variableAsInt % 2) ;
             // binary = 0 " ", 00 " ", 000"", 1000 ""
			binary = variableRemainder + binary;

			// variable = 4, 2, 1, 0 b/c int returns fractions as 0

			variableAsInt = variableAsInt/2;


		}


		return binary;
	}

}