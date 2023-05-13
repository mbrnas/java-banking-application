package com.banking.javabankingapplication.controllers;

import com.banking.javabankingapplication.dbconnection.RegisterDataSender;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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
    private void handleRegisterButton(ActionEvent event) throws IOException {
        registerDataSender = new RegisterDataSender();
        String emailInput = emailInputField.getText().trim();
        String username = usernameInputField.getText().trim();
        String password = passwordInputField.getText().trim();

        registerDataSender.insertRegisteredUser(emailInput, username, password);
        showAlert("Success!", "Your account has been created successfully.");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/banking/javabankingapplication/customer.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

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