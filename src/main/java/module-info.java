module com.banking.javabankingapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.banking.javabankingapplication to javafx.fxml;
    exports com.banking.javabankingapplication;
}