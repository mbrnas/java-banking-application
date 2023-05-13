package com.banking.javabankingapplication.controllers;


import com.banking.javabankingapplication.dbconnection.LoginDataSender;
import com.mysql.cj.log.Log;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
   private LoginDataSender loginSender;

    @FXML
    private TextField usernameField;

    @FXML
    private Button loginButton;

    @FXML
    private TextField passwordField;

    @FXML
    private Button registerButton;



    @FXML
    private void handleLoginButton(ActionEvent event) throws IOException {
        loginSender = new LoginDataSender();
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        boolean isAuthenticated = loginSender.authenticateUser(username, password);
        if (isAuthenticated) {
            // User is authenticated
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/banking/javabankingapplication/banking-view.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } else {
            // Invalid credentials
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid credentials");
            alert.setContentText("The username and password you entered do not match our records.");
            alert.showAndWait();
        }
    }


    @FXML
    private void handleRegisterButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/banking/javabankingapplication/registration.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

}
