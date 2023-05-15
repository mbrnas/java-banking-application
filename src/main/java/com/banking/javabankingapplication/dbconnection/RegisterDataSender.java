package com.banking.javabankingapplication.dbconnection;

import javafx.scene.control.Alert;

import java.sql.*;

public class RegisterDataSender extends DatabaseConnector{


    public void insertRegisteredUser(String email, String username, String password){
        ensureConnection();
        try {
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
        } catch (SQLIntegrityConstraintViolationException ex) {
            // handle the unique constraint violation
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Mistake!");
            alert.setHeaderText("Username, password, and email combination not available");
            alert.setContentText("Please choose a different combination of username, password, and email.");
            alert.showAndWait();
        } catch (Exception ex){
            // handle other exceptions
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error inserting user data");
            alert.setContentText("There was an error inserting user data into the database.");
            alert.showAndWait();
        }

        disconnect();
    }
}
