package com.example.electricity_billing_system.Controllers.Operator;

import com.example.electricity_billing_system.Views.Tariffs;
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
    public ChoiceBox<Tariffs> tariffs_box;
    public Button change_tariff_btn;
    public Text tariff_name_txt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tariffs_box.getItems().addAll(Tariffs.values());
        show_tariff_btn.setOnAction(event -> showTariff());
        change_tariff_btn.setOnAction(event -> changeTariff());
    }


    private void showTariff(){
        String meterCode = meter_code_fld.getText();

        meter_code_txt.setText(meterCode);

        tariff_name_txt.setText("tariffName");
    }


    private void changeTariff() {
        String tariffName = tariffs_box.getValue().toString();
    }

}
