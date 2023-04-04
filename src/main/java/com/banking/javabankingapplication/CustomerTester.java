package com.banking.javabankingapplication;

public class CustomerTester {
    public static void main(String[] args) {
        Customer customer = new Customer();
        //customer.setCustomerFullName("Matija Brnas");
        customer.setCustomerFullName("Matija Brnas");
        customer.setPhoneNumber("12345689998");
        customer.setDateOfBirth("2000-12-21");
        customer.setCustomerID("158");

        customer.getCustomerID();
        customer.getCustomerFullName();
        customer.getDateOfBirth();
        customer.getPhoneNumber();
    }
}
