package com.techelevator;

import java.util.Scanner;

/*
 Using the provided methods below, complete the code in the main method
 to prompt the user for the total bill, and the amount tendered.
 It should then display the change required.

 If the bill is $50 or more, an automatic gratuity of 10% of the bill is added.

 Please enter the amount of the bill: 23.65
 Please enter the amount tendered: 100.00
 The change required is 76.35
 */
public class MakeChange {

	public static void main(String[] args) {

		double change = (getAmountTendered()-getBillInDollars() );


		System.out.print(" The change required is:  " + change );

	}
	/**
	 * @return bill in dollars entered by user
	 */
	public static double getBillInDollars(){
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Please enter the amount of the bill: ");
		double billInDollars = Double.parseDouble(inputScanner.nextLine());
		return billInDollars;
	}

	/**
	 * @return amount tendered entered by user
	 */
	public static double getAmountTendered() {
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Please enter the amount tendered: ");
		double amountTendered = Double.parseDouble(inputScanner.nextLine());
		return amountTendered;
	}
}
