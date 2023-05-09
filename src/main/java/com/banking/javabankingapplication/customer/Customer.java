package com.banking.javabankingapplication.customer;


import javafx.scene.control.Alert;

/**
 * The type Customer.
 */
public class Customer {
    private String customerFirstName;

    private String customerLastName;

    private String phoneNumber;
    private String dateOfBirth;

    private String customerAddress;



    /**
     * Instantiates a new Customer.
     * @param phoneNumber      the phone number
     * @param dateOfBirth      the date of birth
     * @param customerAddress  customers address
     */
    public Customer(String customerFirstName, String customerLastName , String phoneNumber, String dateOfBirth, String customerAddress) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.customerAddress = customerAddress;
    }


    /**
     * Gets customer full name.
     *
     * @return the customer full name
     */
    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        //System.out.println(phoneNumber);
        return phoneNumber;
    }

    /**
     * Gets date of birth.
     *
     * @return the date of birth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }


}