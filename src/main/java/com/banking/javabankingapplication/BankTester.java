package com.banking.javabankingapplication;

import java.math.BigDecimal;

public class BankTester {
    public static void main(String[] args) {
        BankAccount ba1 = new BankAccount();
        Customer c1 = new Customer();
        IBAN iban = new IBAN();



        Bank bank = new Bank(ba1, c1, iban);
        bank.getWholeCustomerInfo();
    }
}
