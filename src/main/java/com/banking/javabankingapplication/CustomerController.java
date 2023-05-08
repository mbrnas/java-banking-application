package com.banking.javabankingapplication;

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
import com.banking.javabankingapplication.customer.Customer;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

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
        Parent root = FXMLLoader.load(getClass().getResource("banking-view.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    @FXML
    private void createAccount() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String address = addressField.getText().trim();
        String dob = dobField.getText().trim();
        String phone = phoneField.getText().trim();
        handler = new DatabaseHandler();
        // Perform data validation here

        // Create a new Customer object with the user's input
        Customer customer = new Customer(firstName, lastName, phone, dob, address);

        // Call the createUser() method to save the user to the database
        handler.insertCustomer(customer.getCustomerFirstName(), customer.getCustomerLastName(), customer.getPhoneNumber(),
                customer.getDateOfBirth(), customer.getCustomerAddress());

        // Display a success message to the user
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success!");
        alert.setHeaderText(null);
        alert.setContentText("Your account has been created successfully.");
        alert.showAndWait();

        // Clear the input fields
        firstNameField.setText("");
        lastNameField.setText("");
        addressField.setText("");
        dobField.setText("");
        phoneField.setText("");
    }



}