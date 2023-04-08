package com.banking.javabankingapplication.bankaccount;

import javafx.scene.control.Alert;

import java.math.BigDecimal;

/**
 * The BankAccount class represents a banking account with a name and balance.
 * It implements the AccountActions interface, which defines deposit and withdraw methods.
 */
public class BankAccount{
    /**
     * The current balance of the account.
     */
    private BigDecimal balance;

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
        final BigDecimal MAXIMUM_AMOUNT = new BigDecimal("10000.0");
        if(amount.compareTo(MAXIMUM_AMOUNT) > 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Deposit error");
            alert.setHeaderText("Mistake in deposit action!");
            alert.setContentText("Amount for deposit cannot be more than 10000");
        }
        else{
            this.balance = this.balance.add(amount);
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
        else{
            this.balance = this.balance.subtract(amount);
        }
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
