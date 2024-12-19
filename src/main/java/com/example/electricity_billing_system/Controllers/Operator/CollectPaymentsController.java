package com.example.electricity_billing_system.Controllers.Operator;

import com.example.electricity_billing_system.Models.Meter;
import com.example.electricity_billing_system.Models.bill;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class CollectPaymentsController implements Initializable {
    public TextField meter_code_fld;
    public Text error_msg;
    public Button calculate_btn;
    public Text reading_txt;
    public Text consumption_txt;
    public Text difference_txt;
    public Button collect_btn;
    public Button print_bill_btn;
    public Text bill_amount_txt;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        calculate_btn.setOnAction(event -> calculate());
        collect_btn.setOnAction(event -> payBill());

    }


    /*
    * TODO :Start Here
    * */
    private void calculate() {
        String meterCode = meter_code_fld.getText();
        /*
        * TODO:  get monthly reading , real consumption for meter by code
        * */
        Meter m = new Meter(1);
        Meter currentMeter = m.checkMeterExist(meterCode);
        if (currentMeter != null) {
            reading_txt.setText("" + currentMeter.getMonthlyReading());
            consumption_txt.setText(""+currentMeter.getMonthlyConsumption());
             double differencePercentage = ((currentMeter.getMonthlyReading() - currentMeter.getMonthlyConsumption()) / currentMeter.getMonthlyReading()) * 100;
                difference_txt.setText(String.format("%.2f", differencePercentage));
            bill billClass = new bill(1);
            bill_amount_txt.setText("" + billClass.getAllMeterBillsAmount(currentMeter.getMeterCode()));
        }else{
            error_msg.setText("Not Found");
        }
            /*
        * TODO : get meter bill by code
        * */

    }

    private void payBill() {
        /*
        * TODO: Set bill to paid in json
        * */

        bill_amount_txt.setText("");
    }



}
