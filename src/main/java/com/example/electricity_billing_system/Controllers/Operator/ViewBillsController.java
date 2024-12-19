package com.example.electricity_billing_system.Controllers.Operator;

import com.example.electricity_billing_system.Models.Meter;
import com.example.electricity_billing_system.Models.Region;
import com.example.electricity_billing_system.Models.bill;
import com.example.electricity_billing_system.Views.Regions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ViewBillsController implements Initializable {
    public ChoiceBox<String> region_select;
    public ListView<String> bills_list;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bill billClass = new bill(1);
        List<bill> bills = billClass.getBills();
        List<String> allRegions = billClass.getAllBillsRegion();
        allRegions.addFirst("All Regions");
        ObservableList<String> regionListView = FXCollections.observableArrayList(allRegions);
        region_select.setItems(regionListView);
        region_select.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                Meter m = new Meter(1);
                List<String> filteredBills = bills.stream()
                        .filter(bill -> newValue.equals(m.checkMeterExist(bill.getMeterCode()).getRegion()) || newValue.equals("All Regions"))
                        .map(bill -> "Bill ID: " + bill.getBillID() +
                                ", Amount: " + bill.getAmount() +
                                ", Issue Date: " + bill.getIssueDate() +
                                ", Due Date: " + bill.getDueDate() +
                                ", Status: " + bill.getStatus())
                        .collect(Collectors.toList());

                ObservableList<String> billsObservableList = FXCollections.observableArrayList(filteredBills);
                bills_list.setItems(billsObservableList);
            }
        });
    }
}
