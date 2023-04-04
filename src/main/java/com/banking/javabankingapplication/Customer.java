package com.banking.javabankingapplication;


public class Customer {
    private String customerFullName;
    private String phoneNumber;
    private String dateOfBirth;

    private int customerID;

    private String regexForLetters = "\\D+";
    private String regexForNumbers = "^[a-zA-Z]+$";

    private String regexForPhoneNumbers = "^(\\+\\d{1,3}[- ]?)?\\d{10}$";

    private String regexForBirthdays = "^\\d{4}-\\d{2}-\\d{2}$";




    public Customer(String customerFullName, String phoneNumber, String dateOfBirth, int customerID) {
        this.customerFullName = customerFullName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.customerID = customerID;
    }

    public Customer(){}

    public void setCustomerFullName(String fullName) {

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
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.matches(regexForPhoneNumbers)){
            this.phoneNumber = phoneNumber;
        }
        else{
              //Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText("Mistake in input");
//            alert.setContentText("Phone number not in correct format!");
            System.out.println("Wrong phone number");
        }
    }

    public void setDateOfBirth(String dateOfBirth) {
        if(dateOfBirth.matches(regexForBirthdays)){
            this.dateOfBirth = dateOfBirth;
        }
        else{
            //Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText("Mistake in input");
//            alert.setContentText("DOB not in correct format!");
            System.out.println("DOB not in correct format");
        }

    }

    public void setCustomerID(int customerID) {
        if(customerID <= 0){
            System.out.println("CustomerID cannot be 0 or negative!");
        }
        else{
            this.customerID = customerID;
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
