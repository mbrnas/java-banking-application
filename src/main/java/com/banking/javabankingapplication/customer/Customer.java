package com.banking.javabankingapplication.customer;


import javafx.scene.control.Alert;

/**
 * The type Customer.
 */
public class Customer {
    private String customerFullName;
    private String phoneNumber;
    private String dateOfBirth;

    private String customerAddress;



    /**
     * Instantiates a new Customer.
     *
     * @param customerFullName the customer full name
     * @param phoneNumber      the phone number
     * @param dateOfBirth      the date of birth
     * @param customerAddress  customers address
     */
    public Customer(String customerFullName, String phoneNumber, String dateOfBirth, String customerAddress) {
        this.customerFullName = customerFullName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.customerAddress = customerAddress;
    }

    /**
     * Instantiates a new Customer.
     */
    public Customer(){}

    /**
     * Sets customer full name.
     *
     * @param fullName the full name
     */
    public void setCustomerFullName(String fullName) {

        if(fullName.matches("^[a-zA-Z]+ [a-zA-Z]+$")){
           this.customerFullName = fullName;
            //System.out.println(fullName);
        }
        else{
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText("Mistake in input");
//            alert.setContentText("Name should not contain numbers!");
            System.out.println("Name should not contain numbers!");
        }
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("\\d+")) {
            System.out.println("Wrong phone number format!");
                // or throw an exception, display an error message, etc.
        } else {
            //System.out.println(phoneNumber);
            this.phoneNumber = phoneNumber;
        }
    }


    /**
     * Sets date of birth.
     *
     * @param dateOfBirth the date of birth
     */
    public void setDateOfBirth(String dateOfBirth) {
        if(dateOfBirth.matches("^\\d{4}-\\d{2}-\\d{2}$")){
            this.dateOfBirth = dateOfBirth;
            //System.out.println(dateOfBirth);
        }
        else{
            //Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText("Mistake in input");
//            alert.setContentText("DOB not in correct format!");
            System.out.println("DOB not in correct format, needs to be YYYY-MM-DD");
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
    public String getCustomerFullName() {
       return customerFullName;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        System.out.println(phoneNumber);
        return phoneNumber;
    }

    /**
     * Gets date of birth.
     *
     * @return the date of birth
     */
    public String getDateOfBirth() {
        System.out.println(dateOfBirth);
        return dateOfBirth;
    }

    public String getCustomerAddress() {
        System.out.println(customerAddress);
        return customerAddress;
    }

    public String getCustomerInfo(){
        return getCustomerFullName() + getCustomerAddress() + getPhoneNumber() + getDateOfBirth();
    }

}
