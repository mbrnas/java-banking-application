package com.banking.javabankingapplication.controllers;

import java.io.IOException;

import com.banking.javabankingapplication.customer.Customer;
import com.banking.javabankingapplication.customer.CustomerValidator;
import com.banking.javabankingapplication.dbconnection.DatabaseHandler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CustomerController {
    private DatabaseHandler handler;

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
    private void switchToBankingScene(ActionEvent event) throws IOException {
        Parent bankingViewParent = FXMLLoader.load(getClass().getResource("/com/banking/javabankingapplication/banking-view.fxml"));
        Scene bankingViewScene = new Scene(bankingViewParent);

        // Get the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(bankingViewScene);
        window.show();
    }

    @FXML
    private void createAccount(ActionEvent event) throws IOException {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String address = addressField.getText().trim();
        String dob = dobField.getText().trim();
        String phone = phoneField.getText().trim();

        // Perform data validation here
        CustomerValidator validator = new CustomerValidator();

        if(!validator.checkFirstName(firstName)){
            showAlert("Error in input!", "First name cant have numbers!");
            firstNameField.setText("");
            return;
        }

        if(!validator.checkLastName(lastName)){
            showAlert("Error in input!", "Last name cant have numbers!");
            lastNameField.setText("");
            return;
        }

        if(!validator.checkPhoneNumber(phone)){
            showAlert("Error in input!", "Phone needs to be in format +385012020!");
            phoneField.setText("");
            return;
        }

        if(!validator.checkDateOfBirth(dob)){
            showAlert("Error in input!", "Date of birth needs to be YYYY-DD-MM!");
            dobField.setText("");
            return;
        }

        // Create a new Customer object with the user's input
        Customer customer = new Customer(firstName, lastName, phone, dob, address);

        // Save the customer to the database
        handler = new DatabaseHandler();
        handler.insertCustomer(customer.getCustomerFirstName(), customer.getCustomerLastName(), customer.getPhoneNumber(),
                customer.getDateOfBirth(), customer.getCustomerAddress());

        // Display a success message to the user
        showAlert("Success!", "Your account has been created successfully.");

        // Clear the input fields
        firstNameField.setText("");
        lastNameField.setText("");
        addressField.setText("");
        dobField.setText("");
        phoneField.setText("");

        // Navigate to banking scene
        switchToBankingScene(event);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText("You will now be directed to the banking screen!");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
