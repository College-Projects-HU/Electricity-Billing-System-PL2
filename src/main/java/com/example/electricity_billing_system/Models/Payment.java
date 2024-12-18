package com.example.electricity_billing_system.Models;

public class Payment {
    // Attributes: These store information about the payment
    private int paymentID;        // Unique ID for the payment
    private int customerID;       // ID of the customer making the payment
    private double amount;        // Payment amount
    private String paymentDate;   // Date of the payment
    private String status;        // Current status of the payment (e.g., "Pending", "Completed")

    // Constructor: Initializes the Payment object with given details
    public Payment(int paymentID, int customerID, double amount, String paymentDate, String paymentMethod) {
        this.paymentID = paymentID;           // Set unique payment ID
        this.customerID = customerID;         // Set customer ID
        this.amount = amount;                 // Set payment amount
        this.paymentDate = paymentDate;       // Set payment date
        this.status = "pending";                 // Set initial status (e.g., "Pending")
    }

    // Getters and Setters: Allow controlled access to private attributes
    public int getPaymentID() { return paymentID; }
    public void setPaymentID(int paymentID) { this.paymentID = paymentID; }

    public int getCustomerID() { return customerID; }
    public void setCustomerID(int customerID) { this.customerID = customerID; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getPaymentDate() { return paymentDate; }
    public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Method: Validates if the payment amount is sufficient to cover the bill
    public int validatePayment(double billAmount) {
        // Check if the payment amount is greater than or equal to the bill amount
        if (this.amount >= billAmount) {
            System.out.println("Payment is valid."); // Validation success message
            return 1; // Return 1 if validation succeeds
        } else {
            System.out.println("Payment amount is less than the bill amount."); // Validation failure message
            return 0; // Return 0 if validation fails
        }
    }

    // Method: Processes the payment after validation
    public void processPayment(double billAmount) {
        // Validate the payment amount
        int validation = validatePayment(billAmount);

        // Check if the payment status is "Pending"
        if (this.status.equals("Pending")) {
            // If validation is successful, update status to "Completed"
            if (validation == 1) {
                this.status = "Completed";
                System.out.println("Payment processed successfully."); // Payment success message
            } else {
                // If validation fails, notify the user
                System.out.println("Please check the payment validation.");
            }
        } else {
            // If payment is not "Pending", notify that it's already completed
            System.out.println("Payment already completed.");
        }
    }

    // Method: Prints the details of the payment
    public void getPaymentDetails() {
        System.out.println("Payment ID: " + paymentID);         // Display payment ID
        System.out.println("Customer ID: " + customerID);       // Display customer ID
        System.out.println("Amount: " + amount);               // Display payment amount
        System.out.println("Payment Date: " + paymentDate);     // Display payment date
        System.out.println("Status: " + status);               // Display payment status
    }
}
