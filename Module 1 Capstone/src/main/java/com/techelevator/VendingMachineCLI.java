package com.techelevator;


import java.io.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;






/*
 * This class is provided to you as a *suggested* class to start
 * your project. Feel free to refactor this code as you see fit.
 */
public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";

	private static final String MAIN_MENU_OPTION_EXIT = "Exit";



	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };


	List <Product> productList = new ArrayList<>();

	List <Product> vendingMachineSnacks = new ArrayList<>();

	Product currentSnack;



	public static void main(String[] args) {
		VendingMachineCLI cli = new VendingMachineCLI();
		cli.run();
	}

	public void run() {
		//code in here that updates productList
		Product inventory = new Product();
		productList = inventory.updatingProductList();
		Purchase transaction = new Purchase();
		BigDecimal snackPrice;
		BigDecimal snackBudget = new BigDecimal( "0.00");
		int numberOfItemsPurchased = 0;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");
		LocalDateTime now  = LocalDateTime.now();
		Product newQuantity = new Product();


		while (true) {
			/*
			 * TODO: Use a method to initialize this value
			 */

			System.out.println ( "(1) "+ MAIN_MENU_OPTION_DISPLAY_ITEMS);
			System.out.println ("(2) "+MAIN_MENU_OPTION_PURCHASE);
			System.out.println ("(3) "+ MAIN_MENU_OPTION_EXIT);

			Scanner userInput = new Scanner(System.in);

			String choice = userInput.nextLine();



			BankAccount bankAccount = new BankAccount();

			if (choice.equals("1")) {

//
//
//				// display vending machine items

				new Product().displayProducts();




			} else if (choice.equals("2")) {

				snackBudget = new BigDecimal("0");

				while (true) {

				System.out.println("(1) " + PURCHASE_MENU_OPTION_FEED_MONEY);
				System.out.println("(2) " + PURCHASE_MENU_OPTION_SELECT_PRODUCT);
				System.out.println("(3) " + PURCHASE_MENU_OPTION_FINISH_TRANSACTION);

				Scanner newChoice = new Scanner(System.in);

				String nextChoice = newChoice.nextLine();

				if (nextChoice.equals("1")) {

					snackBudget = bankAccount.totalMoneyGiven();

				} else if (nextChoice.equals("2")) {



//					System.out.println(getProductList());
					for(Product p : productList) {
						System.out.println(p.getSlotIdentifier() + " " +  p.getProductName());
					}
					System.out.println();

					currentSnack = transaction.buyingSnacks();
					snackPrice = currentSnack.getPrice();


//					//Trying to run a sold out statement
//					if(currentSnack.getQuantity() <= 0){
//						System.out.println("Sold Out");
//					}


					//call bogodo method
					//transaction.bogodo(snackPrice, numberOfItemsPurchased);

					snackPrice = transaction.bogodo(snackPrice, numberOfItemsPurchased);

					System.out.println();
					System.out.println(currentSnack.getProductName() + " " + snackPrice);

					BigDecimal trialBalance = snackBudget.subtract(snackPrice);

					BigDecimal zero = new BigDecimal("0");

					int comparisonResult = trialBalance.compareTo(zero);

					if(comparisonResult < 0){
						System.out.println("Insufficient funds. Please enter money.");
						System.out.println();
						continue;
					}

					snackBudget = snackBudget.subtract(snackPrice);
						System.out.println("Balance remaining: " + snackBudget + "\n");

					//

					numberOfItemsPurchased +=1;








				} else if (nextChoice.equals ("3")){

					transaction.giveChange(snackBudget);

					Scanner purchaseInput = new Scanner(System.in);
					String purchaseLog = "Log.txt";
					File logFile = new File(purchaseLog);
					try (PrintWriter log = new PrintWriter(new FileOutputStream(logFile, true))) {
						log.println(formatter.format(now) + " FEED ME $" + bankAccount.sum + " $" + snackBudget);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}

					numberOfItemsPurchased = 0;

					break;

				}



				}
				// do purchase


			} else if(choice.equals("3")) {

				break;


			}
		}
	}







	public List<Product> getProductList() {

		return productList;
	}
}
