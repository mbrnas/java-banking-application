package com.banking.javabankingapplication;

import com.banking.javabankingapplication.bankaccount.BankAccount;
import com.banking.javabankingapplication.logger.TransactionLogger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.math.BigDecimal;

public class BankingController {
    private BankAccount bankAccount;

    @FXML
    private Button depositButton;
    @FXML
    private Button withdrawButton;
    @FXML
    private Label balanceLabel;
    @FXML
    private TextField depositAmountTextField;
    @FXML
    private TextField withdrawAmountTextField;

    public BankingController() throws IOException {
        bankAccount = new BankAccount(BigDecimal.TEN, new TransactionLogger("report.log"));
    }

    @FXML
    private void initialize() {
        depositButton.setOnAction(event -> handleDeposit());
        withdrawButton.setOnAction(event -> handleWithdraw());
        balanceLabel.setText(bankAccount.getAccountBalance().toString());
    }

    private void handleDeposit() {
        BigDecimal amount = new BigDecimal(depositAmountTextField.getText());
        bankAccount.deposit(amount);
        balanceLabel.setText(bankAccount.getAccountBalance().toString());
        depositAmountTextField.clear();
        System.out.println("hello");
    }

    private void handleWithdraw() {
        BigDecimal amount = new BigDecimal(withdrawAmountTextField.getText());
        bankAccount.withdraw(amount);
        balanceLabel.setText(bankAccount.getAccountBalance().toString());
        withdrawAmountTextField.clear();
    }
}
