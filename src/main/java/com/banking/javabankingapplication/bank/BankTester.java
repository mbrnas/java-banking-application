package com.banking.javabankingapplication.bank;

import com.banking.javabankingapplication.customer.Customer;
import com.banking.javabankingapplication.iban.IBAN;
import com.banking.javabankingapplication.bankaccount.BankAccount;
import com.banking.javabankingapplication.management.BankAccountManager;

import java.math.BigDecimal;

public class BankTester {
    public static void main(String[] args) {
        BankAccountManager manager = new BankAccountManager();
        BigDecimal initialBalance = new BigDecimal("1000");
        BankAccount ba1 = new BankAccount(initialBalance);
        Customer c1 = new Customer();
        c1.setCustomerFullName("Matija Brnas");
        c1.setDateOfBirth("2015-01-01");
        c1.setPhoneNumber("123");
        c1.setCustomerAddress("Jarun");
        IBAN iban = new IBAN();

        Bank bank1 = new Bank(ba1, c1, iban);
        manager.addAccount(bank1);

        // Create a new Bank object with different data
        Customer c2 = new Customer();
        c2.setCustomerFullName("John Smith");
        c2.setDateOfBirth("1990-01-01");
        c2.setPhoneNumber("456");
        c2.setCustomerAddress("Main Street");
        IBAN iban2 = new IBAN();
        BankAccount ba2 = new BankAccount(new BigDecimal("500"));
        Bank bank2 = new Bank(ba2, c2, iban2);
        manager.addAccount(bank2);

        manager.getBankAccounts();
    }
}
