package com.techelevator;

public class SavingsAccount extends BankAccount {

    public SavingsAccount (String accountHolderName, String accountNumber, int balance) {
        super (accountHolderName, accountNumber, balance);

    }
    public SavingsAccount (String accountHolderName, String accountNumber) {

        super (accountHolderName, accountNumber);
    }

    @Override
    public int withdraw(int amountToWithdraw) {

        int serviceFee = 2;

         if (getBalance() - (amountToWithdraw + serviceFee) < 0){

             return getBalance();


        } else if (getBalance() -amountToWithdraw < 150) {

             amountToWithdraw += serviceFee;

             return super.withdraw(amountToWithdraw);

        } else {

            return super.withdraw(amountToWithdraw);
        }
    }

}
