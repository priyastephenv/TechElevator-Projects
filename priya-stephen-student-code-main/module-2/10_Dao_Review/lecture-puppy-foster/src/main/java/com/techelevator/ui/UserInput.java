package com.techelevator.ui;

import java.util.Scanner;

public class UserInput {
    Scanner scanner = new Scanner(System.in);

    public int choosePuppyById(){

        System.out.println("Please choose a puppy: ");
        int selectedPuppyId = Integer.parseInt(scanner.nextLine());

        return selectedPuppyId;
    }

    public void getPuppyInfo(){

        System.out.println("What is the puppy's name? ");
        String puppyName = scanner.nextLine();

        System.out.println("What is the image URL (press enter if none): ");
        String puppyUrl = scanner.nextLine();

        System.out.println("What is the puppy's breed? ");
        String puppyBreed = scanner.nextLine();

        System.out.println("Is the puppy currently being fostered (Y/N)? ");
        boolean isFostered = scanner.nextLine().equalsIgnoreCase("y");

        System.out.println("What is the puppy's gender (M/F)? ");
        String puppyGender = scanner.nextLine().toUpperCase();

        System.out.println("What is the puppy's weight in pounds (whole numbers)? ");
        int puppyWeightLbs = Integer.parseInt(scanner.nextLine());
    }
}
