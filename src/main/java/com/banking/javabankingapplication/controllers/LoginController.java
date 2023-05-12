package com.banking.javabankingapplication.controllers;


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

    @FXML
    private TextField usernameField = new TextField();

    @FXML
    private Button loginButton;

    @FXML
    private TextField passwordField = new TextField();

    @FXML
    private Button registerButton;

    @FXML
    private void handleLoginButton(ActionEvent event) {
        // Code to handle login button action
    }

    @FXML
    private void handleRegisterButton(ActionEvent event) {
        // Code to handle register button action
    }
}
