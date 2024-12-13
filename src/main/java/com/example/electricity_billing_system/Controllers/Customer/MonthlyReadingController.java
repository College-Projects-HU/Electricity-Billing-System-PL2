package com.example.electricity_billing_system.Controllers.Customer;

import com.example.electricity_billing_system.Models.Model;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class MonthlyReadingController implements Initializable {
    public FontAwesomeIconView notification_btn;
    public FontAwesomeIconView profile_btn;
    public Button back_btn;
    public TextField monthly_reading_fld;
    public Text estimated_bill_txt;
    public Button submit_reading_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        back_btn.setOnAction(event -> backToMain());
    }

    private void backToMain() {
        Model.getInstance().getBorderParent().setCenter(Model.getInstance().getViewFactory().getOldCustomerMainView());
    }
}
