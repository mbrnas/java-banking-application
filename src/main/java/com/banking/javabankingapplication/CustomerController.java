package com.banking.javabankingapplication;

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