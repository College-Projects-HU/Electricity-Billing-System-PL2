package com.example.electricity_billing_system.Controllers.Customer;

import com.example.electricity_billing_system.Models.Model;
import com.example.electricity_billing_system.Models.User;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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
    public Text error_msg;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        back_btn.setOnAction(event -> backToMain());
        submit_complaint_btn.setOnAction(event -> addComplaint());

    }

    private void addComplaint() {
        String username = name_fld.getText();
        String complain = complain_desc_fld.getText();
        User user = new User(1);
        user.addComplaint(username,complain);
        error_msg.setText("Complaint submitted successfully");
    }

    private void backToMain() {
        Model.getInstance().getBorderParent().setCenter(Model.getInstance().getViewFactory().getOldCustomerMainView());
    }
}


