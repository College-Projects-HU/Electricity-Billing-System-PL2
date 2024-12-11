package com.example.electricity_billing_system.Controllers.Customer;

import com.example.electricity_billing_system.Models.Model;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class OldCustomerController implements Initializable {
    public Button pay_bill_btn;
    public Button bill_details_btn;
    public Button monthly_reading_btn;
    public Button complaint_btn;
    public TextField meter_code_fld;
    public Text welcome_message_txt;
    public Text error_msg;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pay_bill_btn.setOnAction(event -> viewPayBill());
    }

    private void viewPayBill() {
        Stage stage = (Stage)error_msg.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().getPayBillView();
    }


}
