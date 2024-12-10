package com.example.electricity_billing_system.Controllers.Customer;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ComplaintFormController implements Initializable {
    public FontAwesomeIconView notification_btn;
    public FontAwesomeIconView profile_btn;
    public Button back_btn;
    public TextField name_fld;
    public TextField email_fld;
    public TextArea complain_desc_fld;
    public Button submit_complaint_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}


