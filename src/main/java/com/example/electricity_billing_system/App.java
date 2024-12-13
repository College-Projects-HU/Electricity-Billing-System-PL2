package com.example.electricity_billing_system;

import com.example.electricity_billing_system.Models.Model;
import com.example.electricity_billing_system.Models.bill;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Model.getInstance().getViewFactory().showLoginWindow();
<<<<<<< Updated upstream
//        bill billClass = new bill();
//        List<bill> allBills = billClass.readBillsData();
//        billClass.updateStatus(allBills,1,"paid");

=======
>>>>>>> Stashed changes
    }

}




/*
User:
-Get All Customers
-Get Custom Customer(id)
-Delete Customer
-*Edit Customer
-Add Customer
-GetNumberOfCustomers


Bills:
Get All Bills
Get Customer Bills(id)
Remove Bill
Add Bill
done:
updateStatus
Pay Bill(meter)


Meters:
Get All Meters
Get spec Meter
Remove spec Meter
Add spec Meter
Active ..
deactivate..
update reading

Opderator



Tarrifs



Admin




 */