package com.example.electricity_billing_system.Controllers.Operator;

import com.example.electricity_billing_system.Models.Meter;
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
    Meter meterModel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        meterModel = new Meter(1);
        tariffs_box.getItems().addAll(Tariffs.values());
        show_tariff_btn.setOnAction(event -> showTariff());
        change_tariff_btn.setOnAction(event -> changeTariff());
    }

    private void showTariff() {
        String meterCode = meter_code_fld.getText().trim();
        Meter currentMeter = meterModel.checkMeterExist(meterCode);
        if (meterCode.isEmpty()  || currentMeter == null) {
            error_msg.setText("Please enter a meter code.");
            return;
        }

        meter_code_txt.setText(meterCode);

        tariff_name_txt.setText(currentMeter.getTariff());
    }

    private void changeTariff() {
        String meterCode = meter_code_fld.getText().trim();
        if (meterCode.isEmpty()) {
            error_msg.setText("Please enter a meter code.");
            return;
        }

        Tariffs selectedTariff = tariffs_box.getValue();
        if (selectedTariff == null) {
            error_msg.setText("Please select a tariff.");
            return;
        }

        Meter meterModel = new Meter(1); // Pass the appropriate meter ID
        Meter currentMeter = meterModel.checkMeterExist(meterCode);
        if (currentMeter != null) {
            meterModel.setTariffForMeter(currentMeter, selectedTariff.toString()); // Set the selected tariff for the meter
            error_msg.setText("Tariff changed successfully.");
        } else {
            error_msg.setText("Meter not found.");
        }
    }
}
