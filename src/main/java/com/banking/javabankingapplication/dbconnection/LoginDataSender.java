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
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Prepare statement
            String query = "SELECT * FROM user_authentication WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            // Execute query
            ResultSet rs = stmt.executeQuery();

            // Check if there is a matching user
            if (rs.next()) {
                isAuthenticated = true;
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isAuthenticated;
    }




}
