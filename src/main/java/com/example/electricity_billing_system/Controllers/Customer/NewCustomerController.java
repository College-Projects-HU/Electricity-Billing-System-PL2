package com.example.electricity_billing_system.Controllers.Customer;

import com.example.electricity_billing_system.Models.Model;
import com.example.electricity_billing_system.Models.User;
import com.example.electricity_billing_system.Utils.EmailUtil;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class NewCustomerController implements Initializable {
    public TextField user_name_fld;
    public TextField email_fld;
    public TextField region_fld;
    public TextField password_fld;
    public Button contract_file_btn;
    public Button submission_btn;
    public Button back_btn;
    public Text file_name;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        back_btn.setOnAction(event -> backToMain());

        submission_btn.setOnAction(event -> submitNewUser());

        Stage stage = new Stage();
        stage.setTitle("Insert File");
        contract_file_btn.setOnAction(event ->{ file_name.setText(selectFile(stage).getName());});

    }

    public static File selectFile(Stage stage) {
        // Create a FileChooser instance
        FileChooser fileChooser = new FileChooser();

        // Set extension filters (optional)
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );

        // Show the open file dialog
        return fileChooser.showOpenDialog(stage);
    }

    private void submitNewUser(){

        User newUser = new User(1);
        String username = user_name_fld.getText();
        String email = email_fld.getText();
        String region = region_fld.getText();
        String password = password_fld.getText();
        newUser.createAccount(username, password,"Customer", email, region);
//        String mailSubject = "Confirm Meter Email";
//        String messageBody = "Hello " + username + "Thank you for using our system :)\n" +
//                "We are confirming that's your meter working now.\n" +
//                "Thank you. Electric company -:)";
//        EmailUtil.sendEmail(email,mailSubject,messageBody);
        user_name_fld.clear();
        email_fld.clear();
        region_fld.clear();
        password_fld.clear();
        file_name.setText("");
    }
    private void backToMain() {
        Model.getInstance().getBorderParent().setCenter(Model.getInstance().getViewFactory().getLoginMainView());
    }
}
