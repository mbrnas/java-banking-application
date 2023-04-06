package com.banking.javabankingapplication;

public class BankTester {
    public static void main(String[] args) {
        BankAccount ba1 = new BankAccount();
        Customer c1 = new Customer();
        IBAN iban = new IBAN();

        ba1.deposit(1000);
        c1.setCustomerFullName("Matija");
        iban.generateIBAN();

        Bank bank = new Bank(ba1, c1, iban);
        bank.getWholeCustomerInfo();
    }
}
