package com.example.electricity_billing_system.Controllers;


import com.example.electricity_billing_system.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController  implements Initializable {

    public TextField user_name_fld;
    public TextField password_fld;
    public Label error_lbl;
    public Button login_btn;
    public Button register_btn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_btn.setOnAction(event -> login());
    }

    private void login() {
        Stage stage = (Stage)error_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showOperator();
    }

}