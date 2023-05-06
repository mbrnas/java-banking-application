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

    @FXML
    private TextField depositAmountTextField;
    @FXML
    private TextField withdrawAmountTextField;
    @FXML
    private Label balanceLabel;

    private BankAccount bankAccount;

    @Override
    public void start(Stage primaryStage) throws IOException {

        // initialize bank account with initial balance of 0
        bankAccount = new BankAccount(BigDecimal.ZERO, new TransactionLogger("report.log"));

        // create UI elements
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label depositLabel = new Label("Deposit amount:");
        depositAmountTextField = new TextField();
        Button depositButton = new Button("Deposit");

        Label withdrawLabel = new Label("Withdraw amount:");
        withdrawAmountTextField = new TextField();
        Button withdrawButton = new Button("Withdraw");

        Label balanceTextLabel = new Label("Balance:");
        balanceLabel = new Label("0.00");

        // add UI elements to grid pane
        gridPane.add(depositLabel, 0, 0);
        gridPane.add(depositAmountTextField, 1, 0);
        gridPane.add(depositButton, 2, 0);
        gridPane.add(withdrawLabel, 0, 1);
        gridPane.add(withdrawAmountTextField, 1, 1);
        gridPane.add(withdrawButton, 2, 1);
        gridPane.add(balanceTextLabel, 0, 2);
        gridPane.add(balanceLabel, 1, 2);

        // set event handlers for buttons
        depositButton.setOnAction(event -> {

                BigDecimal amount = new BigDecimal(depositAmountTextField.getText());
                bankAccount.deposit(amount);
                balanceLabel.setText(bankAccount.getAccountBalance().toString());

            depositAmountTextField.clear();
        });

        withdrawButton.setOnAction(event -> {

                BigDecimal amount = new BigDecimal(withdrawAmountTextField.getText());
                bankAccount.withdraw(amount);
                balanceLabel.setText(bankAccount.getAccountBalance().toString());
            withdrawAmountTextField.clear();
        });

        // create scene and show stage

    }

    public static void main(String[] args) {
        launch(args);
    }
}
