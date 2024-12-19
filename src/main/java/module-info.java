module com.example.electricity_billing_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires com.fasterxml.jackson.databind;
    requires jakarta.mail;
    opens com.example.electricity_billing_system.Models to com.fasterxml.jackson.databind;
    opens com.example.electricity_billing_system.Controllers.Admin to javafx.fxml;

    opens com.example.electricity_billing_system to javafx.fxml;
    exports com.example.electricity_billing_system;
    exports com.example.electricity_billing_system.Controllers;
    exports com.example.electricity_billing_system.Controllers.Admin;
    exports com.example.electricity_billing_system.Controllers.Customer;
    exports com.example.electricity_billing_system.Controllers.Operator;
    exports com.example.electricity_billing_system.Models;
    exports com.example.electricity_billing_system.Views;
}