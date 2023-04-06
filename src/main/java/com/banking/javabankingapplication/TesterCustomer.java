package com.banking.javabankingapplication;

public class TesterCustomer {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setCustomerFullName("Matija Brnas");
        customer.setCustomerAddress("Jarun 85");
        customer.setPhoneNumber("12345678");
        customer.setDateOfBirth("2015-12-11");
        customer.getCustomerInfo();
        //test

    }
}
