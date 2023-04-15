package com.banking.javabankingapplication.bank;

import com.banking.javabankingapplication.customer.Customer;
import com.banking.javabankingapplication.iban.IBAN;
import com.banking.javabankingapplication.bankaccount.BankAccount;

import java.math.BigDecimal;

public class BankTester {
    public static void main(String[] args) {
        BigDecimal initialBalance = new BigDecimal("1000");
        BankAccount ba1 = new BankAccount(initialBalance);
        Customer c1 = new Customer();
        c1.setCustomerFullName("Matija Brnas");
        c1.setDateOfBirth("2015-01-01");
        c1.setPhoneNumber("123");
        c1.setCustomerAddress("Jarun");
        IBAN iban = new IBAN();



        Bank bank = new Bank(ba1, c1, iban);
        bank.getWholeCustomerInfo();
    }
}