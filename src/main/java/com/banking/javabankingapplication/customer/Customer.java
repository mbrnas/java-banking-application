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

    public void setCustomerFirstName(String firstName) {
        if(firstName.matches("^[a-zA-Z]+\\S[a-zA-Z]+$")){
            this.customerFirstName = firstName;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid input");
            alert.setContentText("First name should not contain numbers!");
            alert.showAndWait();
        }
    }

    public void setCustomerLastName(String lastName) {
        if(lastName.matches("^[a-zA-Z]+\\S[a-zA-Z]+$")){
            this.customerLastName = lastName;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid input");
            alert.setContentText("Last name should not contain numbers!");
            alert.showAndWait();
        }
    }




    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.matches("^[a-zA-Z]+ [a-zA-Z]+$")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid input");
            alert.setContentText("Phone number should not contain letters!");
            alert.showAndWait();
        }
        else {
            this.phoneNumber = phoneNumber;
        }
    }


    /**
     * Sets date of birth.
     *
     * @param dateOfBirth the date of birth
     */
    public void setDateOfBirth(String dateOfBirth) {
        if(dateOfBirth.matches("^\\d{4}/\\d{2}/\\d{2}$")){
            this.dateOfBirth = dateOfBirth;
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Mistake in input");
            alert.setContentText("DOB needs to be YYYY/MM/DD!");
            alert.showAndWait();
        }

    }

    public void setCustomerAddress(String customerAddress){
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
        //System.out.println(dateOfBirth);
        return dateOfBirth;
    }

    public String getCustomerAddress() {
        //System.out.println(customerAddress);
        return customerAddress;
    }

    public String getCustomerInfo(){
        return getCustomerFirstName()+ " " + getCustomerLastName() + " " + getCustomerAddress() + " " + getPhoneNumber() + " " + getDateOfBirth();
    }

}