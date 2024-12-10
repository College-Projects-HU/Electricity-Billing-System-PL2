package com.example.electricity_billing_system.Controllers.Customer;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class PayBillController  implements Initializable {
    public FontAwesomeIconView notification_btn;
    public FontAwesomeIconView profile_btn;
    public Button back_btn;
    public Text bill_amount_txt;
    public TextField card_number_fld;
    public TextField exp_date_fld;
    public TextField cvv_fld;
    public Button submit_btn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        OldCustomerMainController oldCustomerMainController = new OldCustomerMainController();


    }
}
