package com.banking.javabankingapplication.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDataSender {
    String DB_URL = "jdbc:mysql://localhost:3306/mebex_bank";
    String DB_USERNAME = "root";
    String DB_PASSWORD = "[{Matija20}]";

    private Connection connection;

    private PreparedStatement statement;
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

    public void insertRegisteredUser(String username, String password, String email){
        ensureConnection();
        try {
            String sqlReg ="INSERT INTO user_registration(username, password, email) VALUES(?,?,?)";
            statement = connection.prepareStatement(sqlReg);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, email);
            statement.executeUpdate();

            String sqlAuth = "INSERT INTO user_authentication(username, password) VALUES(?,?)";
            statement = connection.prepareStatement(sqlAuth);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        disconnect();
    }
}
