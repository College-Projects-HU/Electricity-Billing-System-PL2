package com.example.electricity_billing_system.Controllers.Operator;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ManageCustomersController implements Initializable {
    public Text customer_name_txt;
    public TextField meter_code_fld;
    public Button search_btn;
    public Text meter_status_txt;
    public ChoiceBox status_list;
    public Button change_status_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
