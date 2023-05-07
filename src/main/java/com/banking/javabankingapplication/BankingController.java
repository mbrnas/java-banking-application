package com.banking.javabankingapplication;

import com.banking.javabankingapplication.bankaccount.BankAccount;
import com.banking.javabankingapplication.iban.IBAN;
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
    private IBAN iban;

    @FXML
    private Button depositButton;
    @FXML
    private Button withdrawButton;
    @FXML
    private Label balanceLabel;
    @FXML
    private Label ibanLabel;
    @FXML
    private TextField depositAmountTextField;
    @FXML
    private TextField withdrawAmountTextField;

    public BankingController() throws IOException {
        bankAccount = new BankAccount(BigDecimal.TEN, new TransactionLogger("report.log"));
        iban = new IBAN();
    }

    @FXML
    private void initialize() {
        depositButton.setOnAction(event -> handleDeposit());
        withdrawButton.setOnAction(event -> handleWithdraw());
        balanceLabel.setText(bankAccount.getAccountBalance().toString());
        ibanLabel.setText(iban.generateIBAN());
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
