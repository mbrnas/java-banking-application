package com.banking.javabankingapplication.dbconnection;

import com.banking.javabankingapplication.customer.Customer;

import java.sql.*;

public class CustomerDataSender {
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

    public void addCustomerAndIban(String firstName, String lastName, String phone_number, String date_of_birth, String cust_address, String iban) {
        ensureConnection();
        try {
            String sql = "INSERT INTO customers(firstName, lastName, phone_number, date_of_birth, cust_address) VALUES (?,?,?,?,?)";
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, phone_number);
            statement.setString(4, date_of_birth);
            statement.setString(5, cust_address);
            statement.executeUpdate();

            // get the generated customer id
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int customer_id = generatedKeys.getInt(1);
                // insert the IBAN for the customer
                insertIBAN(iban, customer_id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnect();
    }


    public void insertIBAN(String iban, int customer_id) {
        ensureConnection();
        try {
            String sql = "INSERT INTO customers_iban(customer_id, iban) VALUES (?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, customer_id);
            statement.setString(2, iban);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
