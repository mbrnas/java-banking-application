module com.banking.javabankingapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.banking.javabankingapplication to javafx.fxml;
    exports com.banking.javabankingapplication;
}