package com.banking.javabankingapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BankingController {
    private Scene scene;
     private Parent root;

     public void switchToScene1(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(HelloApplication.class.getResource("customer.fxml"));
         Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
     }


}
