package com.banking.javabankingapplication.management;
import com.banking.javabankingapplication.bank.Bank;

import java.util.HashMap;

public class BankAccountManager {
    private Bank bank;

    private HashMap<String, Bank> accountCollection;

    public BankAccountManager() {
        accountCollection = new HashMap<String, Bank>();
    }

    public void addAccount(Bank bank) {
        if(!accountCollection.containsKey(String.valueOf(bank.getAccountID()))) {
            accountCollection.put(String.valueOf(bank.getAccountID()), bank);
        }
    }

    public void removeAccount(Bank bank) {
        accountCollection.remove(String.valueOf(bank.getAccountID()), bank);
    }

    public void updateAccount(Bank bank) {
        accountCollection.put(String.valueOf(bank.getAccountID()),bank);
    }

    public void getBankAccounts(){
        for (Bank bank : accountCollection.values()) {
            System.out.println("Account ID: " + bank.getAccountID() + "\n" + bank.getWholeCustomerInfo());
        }
    }
}
