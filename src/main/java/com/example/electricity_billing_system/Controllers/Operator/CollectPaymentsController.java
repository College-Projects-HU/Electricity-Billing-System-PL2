package com.example.electricity_billing_system.Controllers.Operator;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class CollectPaymentsController implements Initializable {
    public TextField meter_code_fld;
    public Button calculate_btn;
    public Text reading_txt;
    public Text consumption_txt;
    public Text difference_txt;
    public Button collect_btn;
    public Button print_bill_btn;
    public Text bill_amount_txt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
