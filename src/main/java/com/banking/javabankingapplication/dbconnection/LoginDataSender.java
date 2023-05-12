package com.banking.javabankingapplication.dbconnection;



import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LoginDataSender {
    private Connection connection;
    private PreparedStatement statement;

    String DB_URL = "jdbc:mysql://localhost:3306/mebex_bank";
    String DB_USERNAME = "root";
    String DB_PASSWORD = "[{Matija20}]";


    public void ensureConnection() {
        if (connection == null) {
            connect();
        }
    }

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = DB_URL;
            String username = DB_USERNAME;
            String password = DB_PASSWORD;
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    public boolean authenticateUser(String username, String password) {
        boolean isAuthenticated = false;

        try {
            ensureConnection();
            // Connect to database


            // Prepare statement
            String query = "SELECT * FROM user_authentication WHERE username = ? AND password = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            // Execute query
            ResultSet rs = statement.executeQuery();

            // Check if there is a matching user
            if (rs.next()) {
                isAuthenticated = true;
            }

            // Close resources
            rs.close();
            statement.close();
            connection.close();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isAuthenticated;
    }




}
