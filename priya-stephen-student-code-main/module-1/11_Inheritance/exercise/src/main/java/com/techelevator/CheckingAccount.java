package com.techelevator;

public class CheckingAccount extends BankAccount{

    public CheckingAccount (String accountHolderName, String accountNumber, int balance){
        super (accountHolderName, accountNumber, balance);
    }

    public CheckingAccount (String accountHolderName, String accountNumber){
        super(accountHolderName, accountNumber);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        int updatedBalance;

        if (getBalance()-amountToWithdraw>-100 && getBalance()-amountToWithdraw<0) {

            int overdraftTotalCharge = amountToWithdraw + 10;

            updatedBalance = super.withdraw(overdraftTotalCharge);

        }else if (getBalance()-amountToWithdraw <= -100){

            updatedBalance = getBalance();


        } else {

            updatedBalance= super.withdraw(amountToWithdraw);
        }

        return updatedBalance;
    }
}
