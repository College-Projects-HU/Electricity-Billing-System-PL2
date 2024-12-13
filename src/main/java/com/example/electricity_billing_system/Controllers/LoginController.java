package com.example.electricity_billing_system.Controllers;

import com.example.electricity_billing_system.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public BorderPane login_parent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Model.getInstance().setBorderParent(login_parent);
    }
}
