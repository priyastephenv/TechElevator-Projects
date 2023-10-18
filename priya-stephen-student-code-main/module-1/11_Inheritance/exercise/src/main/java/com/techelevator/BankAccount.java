package com.techelevator;

public class BankAccount {

    private String accountHolderName;
    private String accountNumber;
    private int balance;

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public BankAccount (String accountHolderName, String accountNumber) {

        this.accountHolderName = accountHolderName;

        this.accountNumber = accountNumber;


    }

    public BankAccount ( String accountHolderName, String accountNumber, int balance) {

        this.accountHolderName = accountHolderName;
        this. accountNumber = accountNumber;
        this.balance = balance;

    }
    public BankAccount (){

        this.accountNumber = this.accountNumber;
        this.accountHolderName =accountHolderName;
        this.balance = this.balance;
    }

    public int deposit (int amountToDeposit) {


        return this.balance += amountToDeposit;

    }
 public int withdraw ( int amountToWithdraw) {

        this.balance = this.balance - amountToWithdraw;

        return this.balance;
 }


}
