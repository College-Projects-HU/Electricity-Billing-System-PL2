package com.example.electricity_billing_system.Controllers;


import com.example.electricity_billing_system.Models.Model;
import com.example.electricity_billing_system.Models.OldCustomer;
import com.example.electricity_billing_system.Models.User;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;
public class LoginMainController implements Initializable {

    public TextField user_name_fld;
    public TextField password_fld;
    public Label error_lbl;
    public Button login_btn;
    public Button register_btn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_btn.setOnAction(event -> login());
        register_btn.setOnAction(event -> register());
    }


    private void login() {
        /*
        *  TODO: Check username and password , role
        * */
        String username = user_name_fld.getText();
        String password = password_fld.getText();
        User user = new User(1);
        OldCustomer userfound = user.checkUserExist(username, password);
        if(userfound != null){
            Stage stage = (Stage)error_lbl.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            switch (userfound.getUserRole()){
                case "Customer" -> Model.getInstance().getViewFactory().showOldCustomerMainWindow();
                case "Admin" -> Model.getInstance().getViewFactory().showAdmin();
                case "Operator" -> Model.getInstance().getViewFactory().showOperator();
            }
        }
        else {
            error_lbl.setText("Wrong User or Password ");
        }
//        showAlert(Alert.AlertType.INFORMATION, "Login Successful!", "Welcome ");

    }

    private void register(){
        Model.getInstance().getBorderParent().setCenter(Model.getInstance().getViewFactory().getNewCustomerView());
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}