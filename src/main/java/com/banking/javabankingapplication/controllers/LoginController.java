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
    private void handleLoginButton(ActionEvent event) {
        loginSender = new LoginDataSender();
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        loginSender.authenticateUser(username, password);
    }

    @FXML
    private void handleRegisterButton(ActionEvent event) {

    }
}
