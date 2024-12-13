package com.example.electricity_billing_system.Controllers.Customer;

import com.example.electricity_billing_system.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class OldCustomerMainController implements Initializable {
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
        bill_details_btn.setOnAction(event -> viewBillDetails());
        monthly_reading_btn.setOnAction(event -> viewMonthlyReading());
        complaint_btn.setOnAction(event -> viewComplaintForm());
    }




    private void viewPayBill() {
        Model.getInstance().getBorderParent().setCenter(Model.getInstance().getViewFactory().getPayBillView());
    }

    private void viewBillDetails() {
        Model.getInstance().getBorderParent().setCenter(Model.getInstance().getViewFactory().getBillDetailsView());

    }
    private void viewMonthlyReading() {
        Model.getInstance().getBorderParent().setCenter(Model.getInstance().getViewFactory().getMonthlyReadingView());
    }
    private void viewComplaintForm() {
        Model.getInstance().getBorderParent().setCenter(Model.getInstance().getViewFactory().getComplaintForm());
    }


}
