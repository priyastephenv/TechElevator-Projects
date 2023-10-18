package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the length: ");
		String lengthWithoutUnit = input.nextLine();
		double lengthAsDouble = Double.parseDouble(lengthWithoutUnit);

		System.out.print("Is the measurement in (m)eter, or (f)eet? ");
		String unitOfMeasurement = input.nextLine();

		if (unitOfMeasurement.equals("m")) {
			int f = (int) (lengthAsDouble * 3.2808399);

			System.out.print(lengthWithoutUnit + unitOfMeasurement +
					" is " + f + "f.");
		} else if (unitOfMeasurement.equals("f")) {
			int m = (int) (lengthAsDouble * 0.3048);

			System.out.print(lengthWithoutUnit + unitOfMeasurement +
					" is " + m + "m.");
		}
	}
}
