package com.example.electricity_billing_system.Controllers.Customer;

import com.example.electricity_billing_system.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class OldCustomerMenuController implements Initializable {
    public Button logout_btn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logout_btn.setOnAction(event -> logout());
    }

    private void logout() {
        Stage stage = (Stage)logout_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }

}
