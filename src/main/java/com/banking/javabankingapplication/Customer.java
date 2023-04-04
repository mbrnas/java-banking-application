package com.banking.javabankingapplication;


import javafx.scene.control.Alert;

public class Customer {
    private String customerFullName;
    private String phoneNumber;
    private String dateOfBirth;

    private int customerID;

    //private String regexForPhoneNumbers = "^(\\+\\d{1,3}[- ]?)?\\d{10}$";

    private String regexForBirthdays = "^\\d{4}-\\d{2}-\\d{2}$";




    public Customer(String customerFullName, String phoneNumber, String dateOfBirth, int customerID) {
        this.customerFullName = customerFullName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.customerID = customerID;
    }

    public Customer(){}

    public void setCustomerFullName(String fullName) {

        if(fullName.matches("^[a-zA-Z]+ [a-zA-Z]+$")){
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
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("\\d+")) {
            System.out.println("Wrong phone number format!");
                // or throw an exception, display an error message, etc.
        } else {
            System.out.println(phoneNumber);
            this.phoneNumber = phoneNumber;
        }
    }


    public void setDateOfBirth(String dateOfBirth) {
        if(dateOfBirth.matches("^\\d{4}-\\d{2}-\\d{2}$")){
            this.dateOfBirth = dateOfBirth;
            System.out.println(dateOfBirth);
        }
        else{
            //Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText("Mistake in input");
//            alert.setContentText("DOB not in correct format!");
            System.out.println("DOB not in correct format, needs to be YYYY-MM-DD");
        }

    }

    public void setCustomerID(String customerID) {
        try {
            int custID = Integer.parseInt(customerID);
            if(custID <= 0 && customerID.matches("\\d+")){
                System.out.println("CustomerID cannot be 0 or negative!");
            }
            else{
                System.out.println("CustomerID: " + customerID);
                this.customerID = Integer.parseInt(customerID);
            }
        }
        catch (NumberFormatException exception){
            System.out.println("Dont put letters");
        }
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
