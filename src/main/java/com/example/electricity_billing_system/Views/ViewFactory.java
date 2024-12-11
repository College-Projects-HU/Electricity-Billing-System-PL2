package com.example.electricity_billing_system.Views;

import com.example.electricity_billing_system.Controllers.Customer.OldCustomerMainController;
import com.example.electricity_billing_system.Controllers.Operator.OperatorController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class ViewFactory {
    private final StringProperty operatorSelectedMenuItem;
    private AnchorPane CollectPaymentView;
    private AnchorPane RegionBillsView;
    private AnchorPane TariffsView;
    private AnchorPane ManageCustomersView;


    public ViewFactory() {
        this.operatorSelectedMenuItem = new SimpleStringProperty("");
    }

    public StringProperty getOperatorSelectedMenuItem() {
        return operatorSelectedMenuItem;
    }

    public AnchorPane getManageCustomersView() {
        if(ManageCustomersView == null){
            try {
                ManageCustomersView = new FXMLLoader(getClass().getResource("/Fxml/Operator/ManageCustomers.fxml")).load();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return ManageCustomersView;
    }

    public AnchorPane getCollectPaymentView() {
        if(CollectPaymentView == null){
            try {
                CollectPaymentView = new FXMLLoader(getClass().getResource("/Fxml/Operator/CollectPayments.fxml")).load();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return CollectPaymentView;
    }

    public AnchorPane getRegionBillsView() {
        if(RegionBillsView == null){
            try {
                RegionBillsView = new FXMLLoader(getClass().getResource("/Fxml/Operator/ViewBills.fxml")).load();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return RegionBillsView;
    }

    public AnchorPane getTariffsView() {
        if(TariffsView == null){
            try {
                TariffsView = new FXMLLoader(getClass().getResource("/Fxml/Operator/Tariffs.fxml")).load();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return TariffsView;
    }

    public void showOperator(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Operator/Operator.fxml"));
        OperatorController operatorController = new OperatorController();
        loader.setController(operatorController);
        createStage(loader);
    }

    public void getPayBillView() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Customer/PayBill.fxml"));
        createStage(loader);
    }

    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
    }

    public void showOldCustomerMainWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Customer/OldCustomerMain.fxml"));
        OldCustomerMainController MainController = new OldCustomerMainController();
        loader.setController(MainController);
        createStage(loader);
    }



    //    To avoid redundancy
    private void createStage(FXMLLoader loader){
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Electricity Billing System");
        stage.show();
    }
    public void closeStage(Stage stage){
        stage.close();
    }

}

