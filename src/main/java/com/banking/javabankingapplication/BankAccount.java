package com.banking.javabankingapplication;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;

/**
 * The BankAccount class represents a banking account with a name and balance.
 * It implements the AccountActions interface, which defines deposit and withdraw methods.
 */
public class BankAccount implements AccountActions{
    /**
     * The current balance of the account.
     */
    private double balance;

    public BankAccount( double balance) {
        this.balance = balance;
    }

    public BankAccount(){}

    /**
     * Deposits the specified amount into the account.
     * If the amount exceeds the maximum amount, an error Alert is shown.
     * @param amount the amount to deposit
     */
    @Override
    public void deposit(double amount) {
        /**
         * The maximum amount that can be deposited into the account at one time.
         */
        final double MAXIMUM_AMOUNT = 10000.0;
        if(amount > MAXIMUM_AMOUNT){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Deposit error");
            alert.setHeaderText("Mistake in deposit action!");
            alert.setContentText("Amount for deposit cannot be more than 10000");
        }
        else{
            this.balance += amount;
        }
    }

    /**
     * Withdraws the specified amount from the account.
     * If the amount exceeds the account balance, an error Alert is shown.
     * @param amount the amount to withdraw
     */
    @Override
    public void withdraw(double amount) {
        if(amount > balance){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Mistake in withdraw action!");
            alert.setContentText("You do not have enough funds in your account");
        }
        else{
            this.balance -= amount;
        }
    }

    /**
     * Returns the balance of the account.
     * @return the balance of the account
     */
    public void getBalance(){
        System.out.println(balance);
        //return this.balance;
    }
}
