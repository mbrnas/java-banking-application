module com.banking.javabankingapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.banking.javabankingapplication to javafx.fxml;
    exports com.banking.javabankingapplication;
    exports com.banking.javabankingapplication.bankaccount;
    opens com.banking.javabankingapplication.bankaccount to javafx.fxml;
    exports com.banking.javabankingapplication.bank;
    opens com.banking.javabankingapplication.bank to javafx.fxml;
    exports com.banking.javabankingapplication.iban;
    opens com.banking.javabankingapplication.iban to javafx.fxml;
    exports com.banking.javabankingapplication.customer;
    opens com.banking.javabankingapplication.customer to javafx.fxml;
}