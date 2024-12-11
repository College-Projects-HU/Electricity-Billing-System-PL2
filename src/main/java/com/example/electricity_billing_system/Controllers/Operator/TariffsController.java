package com.example.electricity_billing_system.Controllers.Operator;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class TariffsController implements Initializable {
    public TextField meter_code_fld;
    public Text error_msg;
    public Button show_tariff_btn;
    public Text meter_code_txt;
    public ChoiceBox tariffs_box;
    public Button change_tariff_btn;
    public Text tariff_name_txt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
