package com.banking.javabankingapplication.bankaccount;


import com.banking.javabankingapplication.logger.TransactionLogger;

import java.io.IOException;
import java.math.BigDecimal;


public class BankAccTester {
    public static void main(String[] args) {
        try {
            TransactionLogger transactionLogger = new TransactionLogger("transaction.log");
            BankAccount bankAccount = new BankAccount(BigDecimal.ZERO, transactionLogger);

            BigDecimal depositAmount = new BigDecimal("1000.0");
            bankAccount.deposit(depositAmount);

            BigDecimal withdrawAmount = new BigDecimal("200");
            bankAccount.withdraw(withdrawAmount);
            transactionLogger.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}


