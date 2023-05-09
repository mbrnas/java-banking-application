package com.banking.javabankingapplication.customer;

public class Test {
    public static void main(String[] args) {
        Customer c = new Customer("M","M", "2892909209", "2002-05-04", "Jaruin 2");
       String hey = c.getIBAN();
        System.out.println(hey.length());

    }
}
