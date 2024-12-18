package com.example.electricity_billing_system.Controllers.Customer;
import com.example.electricity_billing_system.Models.bill;
import com.example.electricity_billing_system.Models.Model;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BillHistoryController implements Initializable {
    public ListView<String> bills_history_list;
    public Button back_btn;
    public FontAwesomeIconView profile_btn;
    public FontAwesomeIconView notification_btn;
    String meterCode;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        back_btn.setOnAction(event -> backToMain());
        meterCode = Model.getInstance().getMeter().getMeterCode();

        List<bill> Bills = new bill(1).getMeterBills(meterCode);
        ObservableList<String> items = FXCollections.observableArrayList();
        for (bill bill : Bills) {
            String item = "Bill ID: " + bill.getBillID() +
                    ", Amount: " + bill.getAmount() +
                    ", Issue Date: " + bill.getIssueDate() +
                    ", Due Date: " + bill.getDueDate() +
                    ", Status: " + bill.getStatus();
            items.add(item);
        }
        bills_history_list.setItems(items);
    }
    private void backToMain() {
        Model.getInstance().getBorderParent().setCenter(Model.getInstance().getViewFactory().getOldCustomerMainView());
    }
}
