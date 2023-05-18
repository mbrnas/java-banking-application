package com.banking.javabankingapplication.dbconnection.registerconnection;

import com.banking.javabankingapplication.controllers.RegistrationController;
import com.banking.javabankingapplication.dbconnection.DatabaseConnector;
import javafx.scene.control.Alert;

import java.sql.*;

public class RegisterDataSender extends DatabaseConnector {


    public void insertRegisteredUser(String email, String username, String password) {
        ensureConnection();
        try {
            // Check if the username already exists
            String checkUsernameSql = "SELECT * FROM user_registration WHERE username = ?";
            String checkEmailSql = "SELECT * FROM user_registration WHERE email = ?";
            PreparedStatement checkStatement = connection.prepareStatement(checkUsernameSql);
            PreparedStatement checkEmailStatement = connection.prepareStatement(checkEmailSql);
            checkStatement.setString(1, username);
            checkEmailStatement.setString(1, email);

            ResultSet rs = checkStatement.executeQuery();

            if (rs.next()) {
                // username already exists in database
                RegistrationController.showErrorAlert("Error", "Username already exists in the database. Please choose a different username.");
                return;
            }

            ResultSet rs2 = checkEmailStatement.executeQuery();

            if(rs2.next()){
                RegistrationController.showErrorAlert("Error", "Email already exists in the database, try a different one!");
                return;
            }

            // Insert the user data
            String sqlReg ="INSERT INTO user_registration(email, username, password) VALUES(?,?,?)";
            statement = connection.prepareStatement(sqlReg);
            statement.setString(1, email);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.executeUpdate();

            String sqlAuth = "INSERT INTO user_authentication(username, password) VALUES(?,?)";
            statement = connection.prepareStatement(sqlAuth);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();

            RegistrationController.showAlert("Success!", "Your account has been created successfully.");
        } catch (SQLIntegrityConstraintViolationException ex) {
            // handle the unique constraint violation
            RegistrationController.showErrorAlert("Mistake!", "Please try again!");
        } catch (Exception ex){
            // handle other exceptions
            RegistrationController.showErrorAlert("Mistake!", "Please try again!");
        }

        disconnect();
    }



}