package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {


		Scanner userInput = new Scanner(System.in);

		System.out.print("Please enter a number: ");

		String numberAsString = userInput.nextLine();

		int numberAsInteger = Integer.parseInt(numberAsString);

		int firstNumber = 0;
		int secondNumber = 1;


		if (numberAsInteger <= 0) {
			System.out.print("0, 1");
		} else if (numberAsInteger == 1) {
			System.out.print("0, 1, 1");
		} else if (numberAsInteger > 1)

			// on first pass next number = 1, 2nd time next number = 2
			//         2 >= 0, 2>=1, 2>=1
			while (numberAsInteger >= firstNumber) {

				// on first pass first number = 0, first number = 1
				System.out.print(firstNumber + ", ");

				// next number = 1, next number = 2,
				int nextNumber = firstNumber + secondNumber;

				// then first number = 1, first number = 1
				firstNumber = secondNumber;

				// then second number = 1, second number = 2
				secondNumber = nextNumber;




			}


	}
}


