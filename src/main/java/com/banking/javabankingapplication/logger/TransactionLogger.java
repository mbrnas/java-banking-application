package com.banking.javabankingapplication.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionLogger {
    private String filename;
    private PrintWriter writer;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public TransactionLogger(String filename) throws IOException {
        this.filename = filename;
        this.writer = new PrintWriter(new FileWriter(filename, true));
    }

    public void logDeposit(BigDecimal amount) {
        String logMessage = String.format("[%s] Deposit of %.2f", getCurrentDateTime(), amount);
        writer.println(logMessage);
        writer.flush();
    }

    public void logWithdrawal(BigDecimal amount) {
        String logMessage = String.format("[%s] Withdrawal of %.2f", getCurrentDateTime(), amount);
        writer.println(logMessage);
        writer.flush();
    }

    private String getCurrentDateTime() {
        return dateTimeFormatter.format(LocalDateTime.now());
    }

    public void close() {
        writer.close();
    }
}

