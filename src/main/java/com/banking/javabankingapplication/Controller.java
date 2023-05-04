package com.banking.javabankingapplication;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import com.banking.javabankingapplication.customer.Customer;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private Text headerText;

    @FXML
    private TextArea firstNameField;

    @FXML
    private TextArea lastNameField;

    @FXML
    private TextArea addressField;

    @FXML
    private TextArea dobField;

    @FXML
    private TextArea phoneField;

    @FXML
    private Button createAccountButton;

    @FXML
    private void initialize() {
        // initialize the controller
    }



    @FXML
    private void createAccount() {
        // get the input fields
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String address = addressField.getText();
        String dob = dobField.getText();
        String phone = phoneField.getText();

        // create a new customer object
        Customer customer = new Customer(firstName, lastName, phone, dob, address);

        // check if all input fields are valid
        try {
            customer.setCustomerFirstName(firstName);
            customer.setCustomerLastName(lastName);
            customer.setCustomerAddress(address);
            customer.setDateOfBirth(dob);
            customer.setPhoneNumber(phone);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Your data");
            alert.setContentText(customer.getCustomerInfo());
            alert.showAndWait();
        } catch (IllegalArgumentException e) {
            // display an error message if any data is invalid
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid input");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        }

        // display the customer data if all input fields are valid

    }


}