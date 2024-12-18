package com.example.electricity_billing_system.Controllers.Customer;

import com.example.electricity_billing_system.Models.Meter;
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
    public Button submit_reading_btn;
    public Text status_txt;
    String meterCode;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        meterCode = Model.getInstance().getMeter().getMeterCode();

        back_btn.setOnAction(event -> backToMain());
        submit_reading_btn.setOnAction(event -> confirmNewReading(Double.parseDouble(monthly_reading_fld.getText())));
        status_txt.setText("");
    }

    private void confirmNewReading(double monthlyReading) {
        Meter meter = new Meter(1);
        Meter curmeter = meter.checkMeterExist(meterCode);
        meter.updateReading(curmeter , monthlyReading);
        status_txt.setText("Reading Updated");
    }

    private void backToMain() {
        Model.getInstance().getBorderParent().setCenter(Model.getInstance().getViewFactory().getOldCustomerMainView());
    }
}
