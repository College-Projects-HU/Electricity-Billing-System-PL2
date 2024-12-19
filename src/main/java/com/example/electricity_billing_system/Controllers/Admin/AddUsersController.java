package com.example.electricity_billing_system.Controllers.Admin;

import com.example.electricity_billing_system.Models.OldCustomer;
import com.example.electricity_billing_system.Models.User;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddUsersController implements Initializable {
    public ChoiceBox<String> role_selection;
    public TextField user_name_fld;
    public TextField email_fld;
    public TextField region_fld;
    public TextField password_fld;
    public Button add_user_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize role choices
        role_selection.getItems().addAll("Customer","Admin", "Operator");

        // Example of initializing a default value (if needed)
        role_selection.setValue("Customer");

        add_user_btn.setOnAction(event -> {addUser();});
    }

    public void addUser() {
        // Validate the input
        if (isInputValid()) {
            // Create a new User object with the provided data
            String role = role_selection.getValue();
            String userName = user_name_fld.getText().trim();
            String email = email_fld.getText().trim();
            String region = region_fld.getText().trim();
            String password = password_fld.getText().trim();

            User userModel = new User(1);
            userModel.createAccount(userName, password,role, email, region);
            System.out.println("User added successfully.");
        } else {
            // Show validation error message
            System.err.println("Invalid input. Please check your fields.");
        }
    }

    private boolean isInputValid() {
        // Check if any required field is empty
        return !(user_name_fld.getText().isEmpty() || email_fld.getText().isEmpty() || region_fld.getText().isEmpty() || password_fld.getText().isEmpty());
    }

}
