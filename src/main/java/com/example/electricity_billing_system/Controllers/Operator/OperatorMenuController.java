package com.example.electricity_billing_system.Controllers.Operator;

import com.example.electricity_billing_system.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class OperatorMenuController implements Initializable {
    public Button collect_payment_btn;
    public Button view_bills_btn;
    public Button set_tariffs_btn;
    public Button manage_customers_btn;
    public Button logout_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners(){
        collect_payment_btn.setOnAction(e -> onCollectPayments());
        view_bills_btn.setOnAction(e -> onViewBills());
    }


    private void onCollectPayments() {
        Model.getInstance().getViewFactory().getOperatorSelectedMenuItem().set("Collect_Payments");
    }

    private void onViewBills() {
        Model.getInstance().getViewFactory().getOperatorSelectedMenuItem().set("View_Bills");
    }

}
