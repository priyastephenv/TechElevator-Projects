package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

public class BankAccount {

    public static void main(String[] args) {
        new BankAccount().totalMoneyGiven();


    }

        BigDecimal sum = new BigDecimal ("0.00");



        public BigDecimal totalMoneyGiven (){

            System.out.println("Current Money Provided: $" + sum);

            Scanner askingForMoney = new Scanner(System.in);

            System.out.println("Please enter a dollar amount: ");

            String dollarAmount = askingForMoney.nextLine();



            BigDecimal vendingMoney = new BigDecimal(dollarAmount);


            sum = sum.add(vendingMoney);

            System.out.println("Current Money Provided: $" + sum);
            return sum;
        }


}
