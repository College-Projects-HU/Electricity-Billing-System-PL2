package com.example.electricity_billing_system.Controllers.Customer;

import com.example.electricity_billing_system.Models.Model;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class BillHistoryController implements Initializable {
    public ListView bills_history_list;
    public Button back_btn;
    public FontAwesomeIconView profile_btn;
    public FontAwesomeIconView notification_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        back_btn.setOnAction(event -> backToMain());

    }
    private void backToMain() {
        Model.getInstance().getBorderParent().setCenter(Model.getInstance().getViewFactory().getOldCustomerMainView());
    }
}
