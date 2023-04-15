package com.banking.javabankingapplication.bankaccount;

import java.math.BigDecimal;

public class BankAccTester {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        BankAccount bankAccount1 = new BankAccount();

        BigDecimal depositeAmount = new BigDecimal("100.0");
        bankAccount.deposit(depositeAmount);

        bankAccount.getAccountBalance();

        BigDecimal transferedAmount = new BigDecimal("99");
        bankAccount.transferFunds(bankAccount1, transferedAmount);

        bankAccount.getAccountBalance();
        bankAccount1.getAccountBalance();
    }
}
