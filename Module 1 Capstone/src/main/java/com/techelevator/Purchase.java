package com.techelevator;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class Purchase extends Product {

    private String snackID;
    private BigDecimal priceOfSnack;


    private String snackType;

    private Product snack;

    private List<Product> purchaseInventory = new Product().updatingProductList();



    //test has been run on this method in PurchaseTest
    public Product buyingSnacks() {

        Scanner purchaseMenuInput = new Scanner(System.in);
        System.out.print( "Please enter a code: ");
        String snackID = purchaseMenuInput.nextLine();

        //start

        for(Product eachProduct: purchaseInventory) {
            this.snack = eachProduct;
            snackType = this.snack.getSnackType();
            if (this.snack.getQuantity() <= 5 && this.snack.getQuantity() > 0) {

                double currentQuantity = snack.getQuantity();

                this.snack.setQuantity(currentQuantity - 1);

                //System.out.println(snack.getQuantity());
            } else {
                System.out.println("Out of Stock");

                break;
            }
        }


        //end
        for (Product eachProduct: purchaseInventory) {

            if (eachProduct.getSlotIdentifier().equals (snackID)) {


                snackType = eachProduct.getSnackType();

                snack = eachProduct;


                if (snackType.equals("Gum")) {

                    System.out.println("Chew Chew, Yum!");

                } else if (snackType.equals("Candy")) {

                    System.out.println("Yummy Yummy, So Sweet!");

                } else if (snackType.equals("Munchy")) {
                    System.out.println("Crunch Crunch, Yum!");

                } else if (snackType.equals("Drink")) {
                    System.out.println("Glug Glug, Yum!");

                }
                break;
            }

        }

            return snack;
    }


public static BigDecimal giveChange (BigDecimal balanceRemaining) {

    BigDecimal endBalance = new BigDecimal("0.00");
    BigDecimal nickel = new BigDecimal("0.05");
    BigDecimal dime = new BigDecimal("0.10");
    BigDecimal quarter = new BigDecimal("0.25");

    int numberOfNickels =0;

    int numberOfDimes =0;
    int numberOfQuarters =0;

    while (balanceRemaining.compareTo(endBalance) == 1) {

        if (balanceRemaining.compareTo(quarter) == 1 || balanceRemaining.compareTo(quarter) == 0) {

           balanceRemaining = balanceRemaining.subtract(quarter);

            numberOfQuarters+=1;


        } else if (balanceRemaining.compareTo(dime) == 1 || balanceRemaining.compareTo(dime) == 0) {

            balanceRemaining= balanceRemaining.subtract(dime);

            numberOfDimes +=1;


        } else if (balanceRemaining.compareTo(nickel) == 1 || balanceRemaining.compareTo(nickel) == 0) {

            balanceRemaining = balanceRemaining.subtract(nickel);

            numberOfNickels +=1;


        }



    }


    return balanceRemaining;
}



public BigDecimal bogodo (BigDecimal snackPrice, int numberOfItemsPurchased){


    if(numberOfItemsPurchased % 2 == 1 ){
       snackPrice = snackPrice.subtract(new BigDecimal("1"));
    }


    return snackPrice;

}



}
