package com.example.electricity_billing_system;

import com.example.electricity_billing_system.Models.Model;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Model.getInstance().getViewFactory().showLoginWindow();
    }

}
/*
Customer:










Bills:











 */