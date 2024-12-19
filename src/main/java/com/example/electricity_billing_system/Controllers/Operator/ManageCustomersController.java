package com.example.electricity_billing_system.Controllers.Operator;

import com.example.electricity_billing_system.Models.Meter;
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
    public ChoiceBox<String> status_list;
    public Button change_status_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize status choices
        status_list.getItems().addAll("Active", "Inactive");

        // Set default value to "Active"
        status_list.setValue("Not Selected");

        search_btn.setOnAction(event -> {searchMeter();});
        change_status_btn.setOnAction(event -> changeMeterStatus());
    }

    public void searchMeter() {
        String meterCode = meter_code_fld.getText().trim();
        if (meterCode.isEmpty()) {
            meter_status_txt.setText("Please enter a meter code.");
            return;
        }

        Meter meterModel = new Meter(1);
        Meter currentMeter = meterModel.checkMeterExist(meterCode);

        if (currentMeter != null) {
            meter_status_txt.setText(currentMeter.getIsActive() ? "Active" : "Inactive");
        } else {
            meter_status_txt.setText("Meter not found.");
        }
    }

    public void changeMeterStatus() {
        String meterCode = meter_code_fld.getText().trim();
        if (meterCode.isEmpty()) {
            meter_status_txt.setText("Please enter a meter code.");
            return;
        }

        Meter meterModel = new Meter(1);
        Meter currentMeter = meterModel.checkMeterExist(meterCode);

        if (currentMeter != null) {
            String newStatus = status_list.getValue();

             meterModel.updateMeterStatus(currentMeter, newStatus.equals("Active"));

             meter_status_txt.setText("Status updated successfully.");

        } else {
            meter_status_txt.setText("Meter not found.");
        }
    }
}
