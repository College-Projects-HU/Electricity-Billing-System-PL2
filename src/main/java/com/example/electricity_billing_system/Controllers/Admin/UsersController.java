package com.example.electricity_billing_system.Controllers.Admin;

import com.example.electricity_billing_system.Models.OldCustomer;
import com.example.electricity_billing_system.Models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class UsersController implements Initializable {
    public ListView<OldCustomer> users_list; // ListView to display user details
    public Button edit_btn;
    public Button delete_btn;
    public TextField search_fld; // Field for search input
    public Button search_btn;

    private List<OldCustomer> allUsers; // Holds all customers
    private ObservableList<OldCustomer> displayedUsers; // For ListView

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize users
        allUsers = new User(1).getCustomers();
        displayedUsers = FXCollections.observableArrayList(allUsers);
        users_list.setItems(displayedUsers);

        // Custom cell factory to show detailed user information
        users_list.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(OldCustomer user, boolean empty) {
                super.updateItem(user, empty);
                if (empty || user == null) {
                    setText(null);
                } else {
                    setText(String.format("Name: %s   |   Email: %s   |   Region: %s   | Role: %s",
                            user.getUserName(), user.getEmail(), user.getAddress() , user.getUserRole()));
                }
            }
        });

        // Add listener for search field
        search_fld.textProperty().addListener((observable, oldValue, newValue) -> searchUsers());

        // Set up actions for buttons
        delete_btn.setOnAction(event -> deleteSelectedUser());
        edit_btn.setOnAction(event -> editSelectedUser());
    }

    // Method to search users
    private void searchUsers() {
        String query = search_fld.getText().toLowerCase();
        List<OldCustomer> filteredUsers = allUsers.stream()
                .filter(user -> user.getUserName().toLowerCase().contains(query) ||
                        user.getEmail().toLowerCase().contains(query) ||
                        user.getAddress().toLowerCase().contains(query))
                .collect(Collectors.toList());

        displayedUsers.setAll(filteredUsers); // Update ListView
    }

    // Method to delete the selected user
    private void deleteSelectedUser() {
        OldCustomer selectedUser = users_list.getSelectionModel().getSelectedItem();
        if (selectedUser == null) {
            showAlert("Error", "No user selected!", Alert.AlertType.ERROR);
            return;
        }

        // Remove from allUsers and update ListView
        User userModel = new User(1);
        userModel.deleteUser(selectedUser.getUserID());
        displayedUsers.remove(selectedUser);

        showAlert("Success", "User deleted successfully!", Alert.AlertType.INFORMATION);
    }

    // Method to edit the selected user
    private void editSelectedUser() {
        OldCustomer selectedUser = users_list.getSelectionModel().getSelectedItem();
        if (selectedUser == null) {
            showAlert("Error", "No user selected!", Alert.AlertType.ERROR);
            return;
        }

        try {
            // Load the edit dialog
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/EditUserView.fxml"));
            DialogPane editDialog = loader.load();

            // Pass the selected user to the edit controller
            EditUserController controller = loader.getController();
            controller.setUser(selectedUser);

            // Show the dialog
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(editDialog);
            dialog.setTitle("Edit User");
            dialog.initModality(Modality.APPLICATION_MODAL);

            // Process the result
            dialog.showAndWait().ifPresent(result -> {
                if (result == ButtonType.OK) {
                    controller.saveUser(); // Apply changes to the user
                }
            });
            users_list.refresh(); // Refresh the ListView to show updated data

        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Could not load the edit dialog.", Alert.AlertType.ERROR);
        }
    }

    // Utility method to show alerts
    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
