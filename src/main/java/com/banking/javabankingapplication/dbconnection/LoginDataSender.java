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

    public void disconnect() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void authenticateUser(String username, String password){
        ensureConnection();
        boolean isAuthenticated = validateUserCredentials(username, password);

        if(isAuthenticated){
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/banking/javabankingapplication/customer.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
//                Parent bankingViewParent = FXMLLoader.load(getClass().getResource("/com/banking/javabankingapplication/banking-view.fxml"));
//                Scene bankingViewScene = new Scene(bankingViewParent);
//
//                // Get the Stage information
//                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//
//                window.setScene(bankingViewScene);
//                window.show();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid credentials");
            alert.setContentText("The username and password you entered do not match our records.");
            alert.showAndWait();
        }
    disconnect();
    }

    private boolean validateUserCredentials(String username, String password) {
        boolean isValid = false;

        try {
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
                isValid = true;
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isValid;
    }



}
