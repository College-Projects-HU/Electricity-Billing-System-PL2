package com.example.electricity_billing_system.Models;

import com.example.electricity_billing_system.Views.ViewFactory;
import javafx.scene.layout.BorderPane;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private BorderPane operatorParent;


    private Model() {
        this.viewFactory = new ViewFactory();
    }


    public static synchronized Model getInstance(){
        if(model == null){
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public void setOperatorParent(BorderPane operatorParent) {
        this.operatorParent = operatorParent;
    }

    public BorderPane getOperatorParent() {
        return operatorParent;
    }
}
