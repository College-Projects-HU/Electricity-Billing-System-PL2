package com.example.electricity_billing_system.Controllers.Operator;

import com.example.electricity_billing_system.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class OperatorController implements Initializable {
    public BorderPane operator_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getOperatorSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal){
                case "View_Bills" -> operator_parent.setCenter(Model.getInstance().getViewFactory().getRegionBillsView());
                default -> operator_parent.setCenter(Model.getInstance().getViewFactory().getCollectPaymentView());
            }
        } );
    }
}
