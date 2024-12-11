package com.example.electricity_billing_system.Controllers.Admin;

import com.example.electricity_billing_system.Models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    public BorderPane Admin_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal){
                case "View_Bills" -> Admin_parent.setCenter(Model.getInstance().getViewFactory().getViewBillsView());
                case "Users" -> Admin_parent.setCenter(Model.getInstance().getViewFactory().getUsersView());
                case "Add_Users" ->  Admin_parent.setCenter(Model.getInstance().getViewFactory().getAddUsersView());
                default -> Admin_parent.setCenter(Model.getInstance().getViewFactory().getViewStatsView());
            }
        } );
    }
}
