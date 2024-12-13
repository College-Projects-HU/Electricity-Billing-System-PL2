package com.example.electricity_billing_system.Controllers.Operator;

import com.example.electricity_billing_system.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class OperatorMenuController implements Initializable {
    public Button collect_payment_btn;
    public Button view_bills_btn;
    public Button tariffs_btn;
    public Button manage_customers_btn;
    public Button logout_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners(){
        collect_payment_btn.setOnAction(e -> onCollectPayments());
        view_bills_btn.setOnAction(e -> onViewBills());
        tariffs_btn.setOnAction(e -> onTariffs());
        manage_customers_btn.setOnAction(e -> onManageCustomers());
        logout_btn.setOnAction(event -> logout());

    }


    private void onManageCustomers() {
        Model.getInstance().getViewFactory().getOperatorSelectedMenuItem().set("Manage_Customers");
    }


    private void onCollectPayments() {
        Model.getInstance().getViewFactory().getOperatorSelectedMenuItem().set("Collect_Payments");
    }

    private void onViewBills() {
        Model.getInstance().getViewFactory().getOperatorSelectedMenuItem().set("View_Bills");
    }

    private void onTariffs() {
        Model.getInstance().getViewFactory().getOperatorSelectedMenuItem().set("View_Tariffs");
    }
    private void logout() {
        Stage stage = (Stage)logout_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }


}
