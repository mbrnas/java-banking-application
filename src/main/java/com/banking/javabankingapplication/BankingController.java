package com.banking.javabankingapplication;

import com.banking.javabankingapplication.bankaccount.BankAccount;
import com.banking.javabankingapplication.logger.TransactionLogger;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;

public class BankingController extends Application {

    public Button depositButton;
    public Button withdrawButton;
    @FXML
    private TextField depositAmountTextField;
    @FXML
    private TextField withdrawAmountTextField;
    @FXML
    private Label balanceLabel;

    private BankAccount bankAccount;
    @FXML
    private void initialize(){

    }
    @Override
    public void start(Stage primaryStage) throws IOException {

        // initialize bank account with initial balance of 0
        bankAccount = new BankAccount(BigDecimal.ZERO, new TransactionLogger("report.log"));

        // set event handlers for buttons
        depositButton.setOnAction(event -> handleDeposit());
        withdrawButton.setOnAction(event -> handleWithdraw());

    }

    private void handleDeposit() {
        String input = depositAmountTextField.getText();
        BigDecimal amount = new BigDecimal(input);
        bankAccount.deposit(amount);
        balanceLabel.setText(bankAccount.getAccountBalance().toString());
        depositAmountTextField.clear();
        System.out.println("HELLO");
    }

    private void handleWithdraw() {
        String input = withdrawAmountTextField.getText();
        BigDecimal amount = new BigDecimal(input);
        bankAccount.withdraw(amount);
        balanceLabel.setText(bankAccount.getAccountBalance().toString());
        withdrawAmountTextField.clear();
    }


    public static void main(String[] args) {
        launch(args);
    }
}