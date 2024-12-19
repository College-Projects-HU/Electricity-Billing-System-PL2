package com.example.electricity_billing_system.Controllers.Admin;

import com.example.electricity_billing_system.Models.OldCustomer;
import com.example.electricity_billing_system.Models.User;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditUserController {
    @FXML
    private TextField name_fld;
    @FXML
    private TextField email_fld;
    @FXML
    private TextField region_fld;

    private OldCustomer user;

    public void setUser(OldCustomer user) {
        this.user = user;
        name_fld.setText(user.getUserName());
        email_fld.setText(user.getEmail());
        region_fld.setText(user.getAddress());
    }

    @FXML
    public void saveUser() {
        user.setUserName(name_fld.getText());
        user.setEmail(email_fld.getText());
        user.setAddress(region_fld.getText());
        User userModel = new User(1);
        userModel.updateUser(user);
        closeWindow();
    }

    @FXML
    public void cancel() {
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) name_fld.getScene().getWindow();
        stage.close();
    }
}
