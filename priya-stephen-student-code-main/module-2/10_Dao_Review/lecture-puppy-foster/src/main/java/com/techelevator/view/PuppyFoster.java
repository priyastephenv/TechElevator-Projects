package com.techelevator.view;

import com.techelevator.connection.DbConnection;
import com.techelevator.dao.JdbcPuppyDao;
import com.techelevator.dao.JdbcShelterDao;
import com.techelevator.dao.PuppyDao;
import com.techelevator.dao.ShelterDao;
import com.techelevator.model.Puppy;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.util.List;
import java.util.Scanner;

public class PuppyFoster {
    private UserInput userInput;
    private PuppyUI puppyUi;

    private PuppyDao puppyDao;
    private ShelterDao shelterDao;

    public PuppyFoster() {
        this.userInput = new UserInput();
        this.puppyUi = new PuppyUI();

        /*
         * Create a single connection to pass on to the
         * JDBC classes to issue SQL queries
         */
        DbConnection connection = new DbConnection();
        puppyDao = new JdbcPuppyDao(connection);
        shelterDao = new JdbcShelterDao(connection);
    }

    public void run() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        UserOutput.displayMenuHeader();

        while (isRunning) {

            UserOutput.displayMenu();

            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                /*
                 * Display puppies
                 */
                List<Puppy> puppies = puppyDao.getAllPuppies();
                for(Puppy eachPuppy: puppies){
                    System.out.println(eachPuppy);
                }
            }
            else if (choice.equals("2")) {
                /*
                 * Choose puppy
                 */
                int puppyId = userInput.choosePuppyById();
                Puppy puppy = puppyDao.getPuppyById(puppyId);
                System.out.println(puppy);

                puppyUi.addPuppyCard(puppy.getImageUrl(), "A handful!");
            }
            else if (choice.equals("3")) {
                /*
                 * Add puppy
                 */
            }
            else if (choice.equals("4")) {
                /*
                 * Foster/update puppy
                 */
            }
            else if (choice.equals("5")) {
                /*
                 * Adopt/remove puppy
                 */
            }
            else if (choice.equals("6")) {
                /*
                 * Exit
                 */
                isRunning = false;
            }
            else {
                System.out.println("Not a valid choice. Please choose again.");
            }
        }

        UserOutput.displayGoodBye();
        System.exit(0);
    }
}
