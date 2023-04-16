package com.banking.javabankingapplication.bank;

import com.banking.javabankingapplication.customer.Customer;
import com.banking.javabankingapplication.iban.IBAN;
import com.banking.javabankingapplication.bankaccount.BankAccount;

import java.util.UUID;


public class Bank {
    private BankAccount account;
    private Customer customer;
    private IBAN iban;

    private int bankAccountID = 0;

    /**
     * Instantiates a new Bank.
     *
     * @param account  the account
     * @param customer the customer
     * @param iban     the iban
     */
    public Bank(BankAccount account, Customer customer, IBAN iban){
        this.account = account;
        this.customer = customer;
        this.iban = iban;
        this.bankAccountID = Math.abs(UUID.randomUUID().hashCode());
    }

    public BankAccount getAccount(){
        return account;
    }

    public Customer getCustomer(){
        return customer;
    }

    public IBAN getIban() {
        return iban;
    }

    public int getAccountID(){
        return bankAccountID;
    }



    /**
     * Get whole customer info string.
     *
     * @return the string
     */
    public String getWholeCustomerInfo() {
        String customerInfo = "Customer Information:\n" +
                "Name: " + customer.getCustomerFullName() + "\n" +
                "Address: " + customer.getCustomerAddress() + "\n" +
                "Phone: " + customer.getPhoneNumber() + "\n" +
                "Date of Birth: " + customer.getDateOfBirth() + "\n";


        String accountInfo = "Bank Account Information:\n" +
                "Current Balance: " + account.getAccountBalance() + "\n";


        String ibanInfo = "IBAN Information:\n" + iban.generateIBAN() + "\n";
        System.out.println(customerInfo + accountInfo + ibanInfo);
        return customerInfo + accountInfo + ibanInfo;

    }

}