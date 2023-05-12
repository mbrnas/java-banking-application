package com.banking.javabankingapplication.controllers;

import com.banking.javabankingapplication.dbconnection.RegisterDataSender;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController {
    private RegisterDataSender registerDataSender;

    @FXML
    private TextField emailInputField;

    @FXML
    private PasswordField passwordInputField;

    @FXML
    private Button registerAccount;

    @FXML
    private TextField usernameInputField;

    @FXML
    private void handleRegisterButton(ActionEvent event){
        registerDataSender = new RegisterDataSender();
        String emailInput = emailInputField.getText().trim();
        String username = usernameInputField.getText().trim();
        String password = passwordInputField.getText().trim();

        registerDataSender.insertRegisteredUser(emailInput, username, password);
        showAlert("Success!", "Your account has been created successfully.");

        emailInputField.setText("");
        usernameInputField.setText("");
        passwordInputField.setText("");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText("You will now be directed to the banking screen!");
        alert.setContentText(message);
        alert.showAndWait();
    }
}