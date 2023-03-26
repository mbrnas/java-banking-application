package com.banking.javabankingapplication;

import javafx.scene.control.Alert;

/**
 * The BankAccount class represents a banking account with a name and balance.
 * It implements the AccountActions interface, which defines deposit and withdraw methods.
 */
public class BankAccount implements AccountActions{
    /**
     * The name of the account holder.
     */
    private String name;
    /**
     * The current balance of the account.
     */
    private double balance;
    /**
     * The maximum amount that can be deposited into the account at one time.
     */
    private final double MAXIMUM_AMOUNT = 10000.0;

    public BankAccount() {
        this.name = "";
        this.balance = 0.0;
    }

    /**
     * Deposits the specified amount into the account.
     * If the amount exceeds the maximum amount, an error Alert is shown.
     * @param amount the amount to deposit
     */
    @Override
    public void deposit(double amount) {
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
     * Sets the name of the account holder.
     * @param name the name of the account holder
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Returns the name of the account holder.
     * @return the name of the account holder
     */
    public String getName(){
        return this.name;
    }

    /**
     * Returns the balance of the account.
     * @return the balance of the account
     */
    public double getBalance(){
        return this.balance;
    }
}
