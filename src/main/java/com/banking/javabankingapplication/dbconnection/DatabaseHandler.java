package com.banking.javabankingapplication.dbconnection;

import com.banking.javabankingapplication.customer.Customer;

import java.sql.*;

public class DatabaseHandler {
    private Connection connection;
    private PreparedStatement statement;

    private Customer customer;

    public void ensureConnection() {
        if (connection == null) {
            connect();
        }
    }

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mebex_bank";
            String username = "root";
            String password = "[{Matija20}]";
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

    public void insertCustomer(String firstName, String lastName, String phone_number, String date_of_birth, String cust_address) {
        ensureConnection();
        try {
            String sql = "INSERT INTO customers(firstName, lastName, phone_number, date_of_birth, cust_address) VALUES (?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, phone_number);
            statement.setString(4, date_of_birth);
            statement.setString(5, cust_address);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
