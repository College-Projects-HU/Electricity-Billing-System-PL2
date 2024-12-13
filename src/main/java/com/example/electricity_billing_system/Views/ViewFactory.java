package com.example.electricity_billing_system.Views;

import com.example.electricity_billing_system.Controllers.Admin.AdminController;
import com.example.electricity_billing_system.Controllers.Customer.OldCustomerController;
import com.example.electricity_billing_system.Controllers.LoginController;
import com.example.electricity_billing_system.Controllers.Operator.OperatorController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class ViewFactory {
//    Register
    private AnchorPane RegisterView;

//    Login
    private AnchorPane LoginMainView;


//   -------------------- Operator  ---------- //
    private final StringProperty operatorSelectedMenuItem;
    private AnchorPane CollectPaymentView;
    private AnchorPane RegionBillsView;
    private AnchorPane TariffsView;
    private AnchorPane ManageCustomersView;



//  ------------  Admin --------------//
    private final StringProperty adminSelectedMenuItem;

    private AnchorPane ViewStatsView;
    private AnchorPane ViewBillsView;
    private AnchorPane UsersView;
    private AnchorPane AddUsersView;

    public ViewFactory() {
        this.adminSelectedMenuItem = new SimpleStringProperty("");
        this.operatorSelectedMenuItem = new SimpleStringProperty("");
    }



    public StringProperty getAdminSelectedMenuItem() {
        return adminSelectedMenuItem;
    }
    public AnchorPane getViewStatsView() {
        if(ViewStatsView == null){
            try {
                ViewStatsView = new FXMLLoader(getClass().getResource("/Fxml/Admin/ViewStats.fxml")).load();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return ViewStatsView;
    }
    public AnchorPane getViewBillsView() {
        if(ViewBillsView == null){
            try {
                ViewBillsView = new FXMLLoader(getClass().getResource("/Fxml/Admin/ViewBills.fxml")).load();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return ViewBillsView;
    }
    public AnchorPane getUsersView() {
        if(UsersView == null){
            try {
                UsersView = new FXMLLoader(getClass().getResource("/Fxml/Admin/Users.fxml")).load();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return UsersView;
    }
    public AnchorPane getAddUsersView() {
        if(AddUsersView == null){
            try {
                AddUsersView = new FXMLLoader(getClass().getResource("/Fxml/Admin/AddUsers.fxml")).load();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return AddUsersView;
    }

    public void showAdmin() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/Admin.fxml"));
        AdminController adminController = new AdminController();
        loader.setController(adminController);
        createStage(loader);
    }


//  ---------------------  Operator ----------- //
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


//  ------------  Old Customer -----------------

    public void getPayBillView() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Customer/PayBill.fxml"));
        createStage(loader);
    }

    public void showOldCustomerMainWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Customer/OldCustomer.fxml"));
        OldCustomerController MainController = new OldCustomerController();
        loader.setController(MainController);
        createStage(loader);
    }

//    New Customer

    public AnchorPane showNewCustomerMainWindow(){
        if(RegisterView == null){
            try {
                RegisterView = new FXMLLoader(getClass().getResource("/Fxml/Customer/NewCustomer.fxml")).load();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return RegisterView;
    }





//    Login
    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        LoginController loginController = new LoginController();
        loader.setController(loginController);
        createStage(loader);
    }
    public AnchorPane getLoginMainView() {
        if(LoginMainView == null){
            try {
                LoginMainView = new FXMLLoader(getClass().getResource("/Fxml/LoginMain.fxml")).load();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return LoginMainView;
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

