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
    private TextArea nameField;

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
        // create account with the input fields
        String name = nameField.getText();
        String address = addressField.getText();
        String dob = dobField.getText();
        String phone = phoneField.getText();

        // create a new customer object
        Customer customer = new Customer();

        // set the customer data using the setters of the Customer class
        try {
            customer.setCustomerFullName(name);
            customer.setCustomerAddress(address);
            customer.setDateOfBirth(dob);
            customer.setPhoneNumber(phone);
        } catch (IllegalArgumentException e) {
            // display an error message if any data is invalid
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid input");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        }

        // do something with the created customer object
        //System.out.println(customer.getCustomerInfo());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Your data");
        alert.setContentText(customer.getCustomerInfo());
        alert.showAndWait();
    }


}