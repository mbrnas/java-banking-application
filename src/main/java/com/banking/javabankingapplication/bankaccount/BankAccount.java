package com.banking.javabankingapplication.bankaccount;

import com.banking.javabankingapplication.logger.TransactionLogger;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * The BankAccount class represents a banking account with a name and balance.
 * It implements the AccountActions interface, which defines deposit and withdraw methods.
 */
public class BankAccount{
    private TransactionLogger transactionLogger;
    private BigDecimal balance;
    private int numOfDeposits;
    private int numOfWithdraws;

    private final BigDecimal MINIMUM_BALANCE = new BigDecimal("10.00");

    private final BigDecimal MAXIMUM_DEPOSIT_AMOUNT = new BigDecimal("10000.0");

    public BankAccount(BigDecimal balance, TransactionLogger transactionLogger) throws IOException {
        this.balance = balance;
        this.transactionLogger = new TransactionLogger("transaction.log");
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
        if(amount.compareTo(MAXIMUM_DEPOSIT_AMOUNT) > 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Deposit error");
            alert.setHeaderText("Mistake in deposit action!");
            alert.setContentText("Amount for deposit cannot be more than 10,000");
        }
        else if(amount.compareTo(MINIMUM_BALANCE) < 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Deposit error");
            alert.setHeaderText("Mistake in deposit action!");
            alert.setContentText("Amount for deposit cannot be less than 10,00!");
            alert.showAndWait();
        }

        else if (numOfDeposits > 50) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Deposit error");
                alert.setHeaderText("Mistake in deposit action!");
                alert.setContentText("You deposited over your limit!");
                System.out.println("Too many deposits");
            }
            this.balance = this.balance.add(amount);
            numOfDeposits++;
            transactionLogger.logDeposit(amount);
    }

    /**
     * Withdraws the specified amount from the account.
     * If the amount exceeds the account balance, an error Alert is shown.
     * @param amount the amount to withdraw
     */

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(this.balance) > 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Mistake in withdraw action!");
            alert.setContentText("You do not have enough funds in your account");
        }
        else {
            BigDecimal remainingBalance = this.balance.subtract(amount);
            if (remainingBalance.compareTo(MINIMUM_BALANCE) < 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Low balance alert");
                alert.setContentText("Your remaining balance will be less than the minimum balance");
                alert.showAndWait();
            } else if (numOfWithdraws > 5) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Exceeded amount of withdraws");
                alert.setContentText("You have exceeded your withdrawal limit!");
                alert.showAndWait();
            } else {
                this.balance = remainingBalance;
                numOfWithdraws++;
                transactionLogger.logWithdrawal(amount);
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
        return this.balance;
    }
}