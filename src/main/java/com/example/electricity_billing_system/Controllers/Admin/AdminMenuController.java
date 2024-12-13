package com.example.electricity_billing_system.Controllers.Admin;

import com.example.electricity_billing_system.Models.Model;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminMenuController implements Initializable {
    public Button view_stat_btn;
    public Button view_bill_btn;
    public Button users_btn;
    public Button add_user_btn;
    public Button logout_btn;

    @Override
    public void initialize(java.net.URL url, java.util.ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {
        view_stat_btn.setOnAction(event -> onViewStats());
        view_bill_btn.setOnAction(event -> onViewBills());
        users_btn.setOnAction(event -> onUsers());
        add_user_btn.setOnAction(event -> onAddUsers());
        logout_btn.setOnAction(event -> logout());
    }




    private void onViewStats() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set("View_Stats");
    }

    private void onViewBills() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set("View_Bills");
    }

    private void onUsers() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set("Users");
    }

    private void onAddUsers() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set("Add_Users");
    }

    private void logout() {
        Stage stage = (Stage)logout_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }

}


