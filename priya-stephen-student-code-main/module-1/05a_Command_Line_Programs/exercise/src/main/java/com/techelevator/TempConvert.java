package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		Scanner input = new Scanner (System.in);

		System.out.print ("Please enter the temperature: ");

		String temperatureWithoutUnit = input.nextLine();
		double temperatureAsDouble = Double.parseDouble(temperatureWithoutUnit);

		System.out.print ("Is the temperature in (C)elsius or (F)ahrenheit? ");
		String unitOfTemperature = input.nextLine();

		if (unitOfTemperature.equals( "F" )){

			int temperatureCelsius = (int) ((temperatureAsDouble - 32) / 1.8);

			System.out.print( temperatureWithoutUnit + unitOfTemperature + "is " + temperatureCelsius + "C.");

		} else if (unitOfTemperature.equals ( "C")) {

			int temperatureFarenheit = (int) ( temperatureAsDouble * 1.8 + 32);

			System.out.print( temperatureWithoutUnit + unitOfTemperature + " is " + temperatureFarenheit + "F.");
		}

	}

}
