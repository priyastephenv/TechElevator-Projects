package com.techelevator;


import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter discount amounts (w/out percentage): ");
        String whatTheUserTyped = scanner.nextLine();
        System.out.println("the user typed: " + whatTheUserTyped);

        // Prompt the user for a single prices
        System.out.print("Please a single price: ");

        // optional: 2 steps in a single line
        double price = Double.parseDouble( scanner.nextLine() );

        // Get an array of each discount typed in by the user on a single line
        //
        // Different split patterns
        // 10 2 5 -> split(" ") -> [10,2,5]
        // 10-2-5 -> split("-") -> [10,2,5]
        // 10, 2, 5 -> split(", ") -> [10,2,5]
        String[] discounts = whatTheUserTyped.split(" ");

        // Go through each discount in the array
        for(int i = 0; i < discounts.length; i++) {

            // Get one of the discounts. convert the whole number percentage into a fraction
            double eachDiscount = Double.parseDouble(discounts[i]) / 100;

            // Get the discount for the specified price
            //
            double discountAmount = price * eachDiscount;
            double finalPrice = price - discountAmount;
            System.out.println("The discount of " + eachDiscount + "% for $" + price + " is: " + finalPrice);
        }
    }
}
