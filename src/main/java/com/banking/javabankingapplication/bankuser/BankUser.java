package com.banking.javabankingapplication.bankuser;

import com.banking.javabankingapplication.bankaccount.BankAccount;
import com.banking.javabankingapplication.customer.Customer;
import com.banking.javabankingapplication.iban.IBAN;

import java.util.ArrayList;
import java.util.List;

public class BankUser {
    private BankAccount bankAccount;
    private Customer customer;
    private IBAN iban;

    public BankUser(BankAccount bankAccount, Customer customer, IBAN iban) {
        this.bankAccount = bankAccount;
        this.customer = customer;
        this.iban = iban;

    }

    List<BankUser> bankUserList = new ArrayList<>();

    public void printUser() {
        System.out.println("Customer name: " + customer.getCustomerFullName());
        System.out.println("Customer address: " + customer.getCustomerAddress());
        System.out.println("Phone number: " + customer.getPhoneNumber());
        System.out.println("Date of birth: " + customer.getDateOfBirth());
        System.out.println("IBAN: " + iban.generateIBAN());
        System.out.println("Account balance: " + bankAccount.getAccountBalance());
    }

}
