package com.example.electricity_billing_system.Controllers.Admin;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddUsersController implements Initializable {
    public ChoiceBox role_selection;
    public TextField user_name_fld;
    public TextField email_fld;
    public TextField region_fld;
    public TextField password_fld;
    public Button add_user_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
