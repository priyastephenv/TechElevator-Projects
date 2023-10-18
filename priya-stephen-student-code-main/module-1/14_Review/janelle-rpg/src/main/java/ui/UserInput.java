package ui;

import application.MainMenu;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 *
 * Dependencies: None
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static void pause(){
        scanner.nextLine();
    }

    public static int getMainMenuOptions() {
        System.out.println("Welcome to Next Level Trap");
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Inventory");
        System.out.println("B) Go to the Battle Arena");
        System.out.println("C) Resume the campaign");
        System.out.println("Q) Quit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        if (option.equalsIgnoreCase("d")) {

            return MainMenu.DISPLAY_INVENTORY;

        } else if (option.equalsIgnoreCase("b")) {

            return MainMenu.BATTLE_ARENA;

        } else if (option.equalsIgnoreCase("c")) {

            return MainMenu.CAMPAIGN;

        } else if (option.equals("q")) {

            return MainMenu.QUIT;

        } else {

            return MainMenu.MAIN_MENU;

        }
    }
}


