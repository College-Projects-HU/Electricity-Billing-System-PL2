package com.example.electricity_billing_system.Controllers.Operator;
import com.example.electricity_billing_system.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

import javafx.scene.layout.Region;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewBillsController implements Initializable {
    public ChoiceBox region_select;
    public ListView bills_list;
    public Button back_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        back_btn.setOnAction(e -> backToMain());
    }

    private void backToMain() {
        if (Model.getInstance().getOperatorParent() != null) {
            Model.getInstance().getViewFactory().getOperatorSelectedMenuItem().set("Collect_Payments");
            Model.getInstance().getOperatorParent().setCenter(Model.getInstance().getViewFactory().getCollectPaymentView());
        } else {
            System.out.println("Operator parent is not initialized.");
        }
    }
}
