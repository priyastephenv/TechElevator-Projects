package ui;

public class UserOutput {
    public static void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayMainMenu() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Main Menu");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void quit(){
        System.out.println("Take care warrior!");
        System.out.println("Good Bye");
    }
}
