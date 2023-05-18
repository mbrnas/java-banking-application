package com.banking.javabankingapplication.controllers;

import com.banking.javabankingapplication.dbconnection.registerconnection.RegisterDataSender;
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

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/banking/javabankingapplication/customer.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        emailInputField.setText("");
        usernameInputField.setText("");
        passwordInputField.setText("");
    }

    public static void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText("Registration Success");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText("Error in registration");
        alert.setContentText(message);
        alert.showAndWait();
    }

}