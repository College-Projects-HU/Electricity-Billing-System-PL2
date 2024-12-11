package com.example.electricity_billing_system.Controllers.Admin;

import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewStatsController  implements Initializable {
    public ChoiceBox select_region;
    public Text total_collected_txt;
    public ListView consumption_list;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
