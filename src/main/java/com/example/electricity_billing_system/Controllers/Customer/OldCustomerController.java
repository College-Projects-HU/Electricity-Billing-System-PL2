package com.example.electricity_billing_system.Controllers.Customer;
import com.example.electricity_billing_system.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class OldCustomerController implements Initializable {
    public BorderPane old_customer_parent;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().setBorderParent(old_customer_parent);
    }
}
