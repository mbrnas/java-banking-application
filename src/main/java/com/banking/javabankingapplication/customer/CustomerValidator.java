package com.banking.javabankingapplication.customer;

import com.banking.javabankingapplication.controllers.CustomerController;

public class CustomerValidator {


    public boolean checkFirstName(String firstName){
       return firstName.matches("^[a-zA-Z]+$");
    }

    public boolean checkLastName(String lastName){
        return lastName.matches("^[a-zA-Z]+$");
    }

    public boolean checkPhoneNumber(String phoneNumber){
        return (!phoneNumber.matches("^\\d+$\n"));
    }

    public boolean checkDateOfBirth(String dateOfBirth){
        return dateOfBirth.matches("^\\d{4}-\\d{2}-\\d{2}$");
    }



    public CustomerValidator() {

    }
}
