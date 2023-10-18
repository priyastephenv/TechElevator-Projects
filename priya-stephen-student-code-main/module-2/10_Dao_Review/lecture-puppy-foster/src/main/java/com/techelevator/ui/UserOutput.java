package com.techelevator.ui;

public class UserOutput {

    public static void displayMenuHeader(){
        System.out.println(ConsoleColors.RED_BRIGHT    + "-------------------------------------------------" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "Welcome to \uD83D\uDC36 Puppy Foster \uD83D\uDC36" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED_BRIGHT    + "-------------------------------------------------" + ConsoleColors.RESET);
    }

    public static void displayGoodBye(){
        System.out.println(ConsoleColors.RED_BRIGHT    + "-------------------------------------------------" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "Sorry to see you leave \uD83D\uDC36" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED_BRIGHT    + "-------------------------------------------------" + ConsoleColors.RESET);
    }

    public static void displayMenu() {
        System.out.println(ConsoleColors.CYAN_BRIGHT);
        System.out.println("What would you like to do");
        System.out.println("(1) Display all puppies");
        System.out.println("(2) Choose a puppy");
        System.out.println("(3) Add a puppy");
        System.out.println("(4) Foster/Update a puppy");
        System.out.println("(5) Adopt/Remove a puppy");
        System.out.println("(6) Exit");
        System.out.print(ConsoleColors.RESET);
    }

}
