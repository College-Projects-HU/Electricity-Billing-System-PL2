package com.example.electricity_billing_system.Controllers.Customer;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OldCustomerController implements Initializable {
    public Button logout_btn;
    public FontAwesomeIconView notification_btn;
    public FontAwesomeIconView profile_btn;
    public Button pay_bill_btn;
    public Button bill_details_btn;
    public Button monthly_reading_btn;
    public Button complaint_btn;
    public Label meter_code_lbl;
    public TextField meter_code_fld;
    public Text welcome_message_txt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void handleLogoutButton(ActionEvent event) throws Exception {
        try {
            // Load Old Customer FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
            Parent root = loader.load();

            // Get Current Stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the Scene to Old Customer
            stage.setScene(new Scene(root));
            stage.setTitle("Old Customer");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
