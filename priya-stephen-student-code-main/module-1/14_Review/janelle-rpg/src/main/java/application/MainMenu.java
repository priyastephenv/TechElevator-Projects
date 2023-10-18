package application;

import gameplay.Battle;
import model.character.Hero;
import ui.UserInput;
import ui.UserOutput;

public class MainMenu {
    public static final int MAIN_MENU = 0;
    public static final int QUIT = 1;
    public static final int DISPLAY_INVENTORY = 2;
    public static final int BATTLE_ARENA = 3;
    public static final int CAMPAIGN = 4;

    Battle battleArena = new Battle(new Hero("Shrek"));

    public void start(){

        int mainMenuState = MAIN_MENU;

        /*
         * Stay in this loop until the user enters "Quit"
         */
        while( mainMenuState != QUIT ){

            if(mainMenuState == MAIN_MENU){

                /*
                 * Get the user selection
                 */
                UserOutput.displayMainMenu();
                mainMenuState = UserInput.getMainMenuOptions();

            }
            else if(mainMenuState == DISPLAY_INVENTORY){

                /*
                 * Display the hero's inventory
                 */
                System.out.println("displaying hero inventory");
                UserInput.pause();
                mainMenuState = MAIN_MENU;

            }
            else if(mainMenuState == BATTLE_ARENA){

                /*
                 * Go to the battle arena
                 */
                System.out.println("battle arena, let's go!!");
                UserInput.pause();
                battleArena.battleEnemies();
                mainMenuState = MAIN_MENU;

            }
            else if(mainMenuState == CAMPAIGN){

                /*
                 * Continue campaign mode
                 */
                System.out.println("navigating the campaign");
                UserInput.pause();
                mainMenuState = MAIN_MENU;

            }
        }
    }
}
