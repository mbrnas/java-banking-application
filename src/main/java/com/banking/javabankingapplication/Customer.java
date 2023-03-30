package com.banking.javabankingapplication;

import javafx.scene.control.Alert;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Customer {
    private String customerFullName;
    private String phoneNumber;
    private String dateOfBirth;

    private int customerID;

    private String regexForLetters = "\\D+";
    private String regexForNumbers = "^[a-zA-Z]+$";


    public Customer(String customerFullName, String phoneNumber, String dateOfBirth, int customerID) {
        this.customerFullName = customerFullName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.customerID = customerID;
    }

    public Customer(){}
    Scanner scan = new Scanner(System.in);
    public String setCustomerFullName(String fullName) {

        if(fullName.matches(regexForNumbers)){
           this.customerFullName = customerFullName;
            System.out.println(fullName);
        }
        else{
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText("Mistake in input");
//            alert.setContentText("Name should not contain numbers!");
            System.out.println("Name should not contain numbers!");
        }
        return customerFullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getCustomerID() {
        return customerID;
    }
}
