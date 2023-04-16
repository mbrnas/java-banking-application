package com.banking.javabankingapplication.bankaccount;

import javafx.scene.control.Alert;

import java.math.BigDecimal;

/**
 * The BankAccount class represents a banking account with a name and balance.
 * It implements the AccountActions interface, which defines deposit and withdraw methods.
 */
public class BankAccount{
    private BigDecimal balance;
    private int numOfDeposits;
    private int numOfWithdraws;

    private final BigDecimal MINIMUM_BALANCE = new BigDecimal("10.00");

    private final BigDecimal MAXIMUM_AMOUNT = new BigDecimal("10000.0");

    public BankAccount(BigDecimal balance) {
        this.balance = balance;
    }

    public BankAccount(){
        this.balance = BigDecimal.ZERO;
    }

    /**
     * Deposits the specified amount into the account.
     * If the amount exceeds the maximum amount, an error Alert is shown.
     * @param amount the amount to deposit
     */

    public void deposit(BigDecimal amount) {
        /**
         * The maximum amount that can be deposited into the account at one time.
         */

        if(amount.compareTo(MAXIMUM_AMOUNT) > 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Deposit error");
            alert.setHeaderText("Mistake in deposit action!");
            alert.setContentText("Amount for deposit cannot be more than 10000");
        }
        else{
            if(amount.compareTo(MINIMUM_BALANCE) < 0){
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setTitle("Deposit error");
//                alert.setHeaderText("Mistake in deposit action!");
//                alert.setContentText("Amount for deposit cannot be less than " + MINIMUM_BALANCE.toString());
//                alert.showAndWait();
                System.out.println("Minimum amount for deposit is " + MINIMUM_BALANCE);
            }

            this.balance = this.balance.add(amount);
            numOfDeposits++;

            if (numOfDeposits > 50) {
                System.out.println("Too many deposits");
            }

        }


    }

    /**
     * Withdraws the specified amount from the account.
     * If the amount exceeds the account balance, an error Alert is shown.
     * @param amount the amount to withdraw
     */

    public void withdraw(BigDecimal amount) {
        if(amount.compareTo(this.balance) > 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Mistake in withdraw action!");
            alert.setContentText("You do not have enough funds in your account");
        }
         else {
            BigDecimal remainingBalance = this.balance.subtract(amount);
            if(remainingBalance.compareTo(MINIMUM_BALANCE) < 0){
//                Alert alert = new Alert(Alert.AlertType.WARNING);
//                alert.setTitle("Warning");
//                alert.setHeaderText("Low balance alert");
//                alert.setContentText("Your remaining balance will be less than the minimum balance");
//                alert.showAndWait();
                System.out.println("MINIMUM BALANCE IS REQ");
            }
            this.balance = remainingBalance;
            numOfWithdraws++;
            if(numOfWithdraws > 50) {
                System.out.println("Number of withdraws is too much");
            }
        }
    }

    public void transferFunds(BankAccount bankAccount, BigDecimal amount){
        bankAccount.deposit(amount);
        this.balance = this.balance.subtract(amount);
    }

    /**
     * Returns the balance of the account.
     * @return the balance of the account
     */
    public BigDecimal getAccountBalance(){
        System.out.println(balance);
        return this.balance;
    }
}