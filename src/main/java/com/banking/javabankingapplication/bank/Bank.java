package com.banking.javabankingapplication.bank;

import com.banking.javabankingapplication.customer.Customer;
import com.banking.javabankingapplication.iban.IBAN;
import com.banking.javabankingapplication.bankaccount.BankAccount;


public class Bank {
    private BankAccount account;
    private Customer customer;
    private IBAN iban;

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

    /**
     * Get whole customer info string.
     *
     * @return the string
     */
    public String getWholeCustomerInfo() {
        String customerInfo = "Customer Information:\n" +
                "Name: " + customer.getCustomerFullName() + "\n" +
                "Address: " + customer.getCustomerAddress() + "\n";

        String accountInfo = "Bank Account Information:\n" +
                "Current Balance: " + account.getAccountBalance() + "\n";


        String ibanInfo = "IBAN Information:\n" +
                "IBAN: " + iban.generateIBAN() + "\n";

        return customerInfo + accountInfo + ibanInfo;
    }

}
