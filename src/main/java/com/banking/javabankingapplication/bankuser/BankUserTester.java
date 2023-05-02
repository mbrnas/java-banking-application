package com.banking.javabankingapplication.bankuser;

import com.banking.javabankingapplication.bankaccount.BankAccount;
import com.banking.javabankingapplication.bankuser.Bank;
import com.banking.javabankingapplication.customer.Customer;
import com.banking.javabankingapplication.iban.IBAN;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankUserTester {
    public static void main(String[] args) {
        List<BankUser> bankUserList = new ArrayList<>();
        Customer customer = new Customer();
        IBAN iban = new IBAN();
        BankAccount bankAccount = new BankAccount(); // initialize the bank account separately

        customer.setCustomerFullName("Matija Brnas");
        customer.setCustomerAddress("Jarun");
        customer.setPhoneNumber("1234565");
        customer.setDateOfBirth("2015-01-01");
        bankAccount.deposit(new BigDecimal("100"));
        BankUser user = new BankUser(bankAccount, customer, iban); // pass in the pre-existing bank account
        bankUserList.add(user);
        user.printUser();

        Customer customer2 = new Customer();
        IBAN iban2 = new IBAN();
        BankAccount bankAccount2 = new BankAccount();

        customer2.setCustomerFullName("Halo Halo");
        customer2.setCustomerAddress("Ilica 2");
        customer2.setPhoneNumber("0090909");
        customer2.setDateOfBirth("2015-12-03");
        bankAccount2.deposit(new BigDecimal("2000"));
        BankUser user2 = new BankUser(bankAccount2, customer2, iban2);
        bankAccount2.withdraw(new BigDecimal("200"));
        bankUserList.add(user2);
        user2.printUser();
    }

}
