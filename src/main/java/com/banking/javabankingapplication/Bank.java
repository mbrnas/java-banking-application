package com.banking.javabankingapplication;

/**
 * The type Bank.
 */
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

    /**
     * Get account bank account.
     *
     * @return the bank account
     */
    public BankAccount getAccount(){
        return account;
    }

    /**
     * Get customer customer.
     *
     * @return the customer
     */
    public Customer getCustomer(){
        return customer;
    }

    /**
     * Gets iban.
     *
     * @return the iban
     */
    public IBAN getIban() {
        return iban;
    }

    /**
     * Get whole customer info string.
     *
     * @return the string
     */
    public String getWholeCustomerInfo(){
        String customerInfo = customer.toString();
        String accountInfo = account.toString();
        String ibanInfo = iban.toString();

        return customerInfo + " " + accountInfo + " " + ibanInfo;
    }
}
