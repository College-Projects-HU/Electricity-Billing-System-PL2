package com.example.electricity_billing_system.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

    public Label user_name_lbl;
    public TextField user_name_fld;
    public Label password_lbl;
    public TextField password_fld;
    public Label error_lbl;
    public Button login_btn;
    public Button register_btn;

    public void handleLoginButton(ActionEvent event) throws Exception {
        try {
            // Load Old Customer FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Customer/OldCustomer.fxml"));
            Parent root = loader.load();

            // Get Current Stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the Scene to Old Customer
            stage.setScene(new Scene(root));
            stage.setTitle("Old Customer");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            error_lbl.setText("Error loading scene.");
        }
    }
}