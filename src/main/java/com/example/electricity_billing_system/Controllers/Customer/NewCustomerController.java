package com.example.electricity_billing_system.Controllers.Customer;

import com.example.electricity_billing_system.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class NewCustomerController implements Initializable {
    public TextField user_name_fld;
    public TextField email_fld;
    public TextField region_fld;
    public TextField password_fld;
    public Button contract_file_btn;
    public Button submission_btn;
    public Button back_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        back_btn.setOnAction(event -> backToMain());
    }

    private void backToMain() {
        Model.getInstance().getBorderParent().setCenter(Model.getInstance().getViewFactory().getLoginMainView());
    }
}
