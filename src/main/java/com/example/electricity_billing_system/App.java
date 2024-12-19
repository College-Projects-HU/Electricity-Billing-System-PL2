package com.example.electricity_billing_system;

import com.example.electricity_billing_system.Models.Model;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

     /*
     * The app starts here
     * */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Model.getInstance().getViewFactory().showLoginWindow();
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
Active
deactivate
update reading

Operator
*/