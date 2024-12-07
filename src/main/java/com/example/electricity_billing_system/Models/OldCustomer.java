package com.example.electricity_billing_system.Models;


import java.util.ArrayList;
import java.util.List;

class OldCustomer {
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private String meterNumber;
    private double outstandingBillAmount;
    private final List<String> complaints;

    public OldCustomer(String name, String address, String email, String phoneNumber, String meterNumber) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.meterNumber = meterNumber;
        this.outstandingBillAmount = 0.0;
        this.complaints = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    public double getOutstandingBillAmount() {
        return outstandingBillAmount;
    }

    // Method to view the bill
    public void viewBill() {
        System.out.println("Bill Details for Meter Number: " + meterNumber);
        System.out.println("Outstanding Bill Amount: " + outstandingBillAmount);
    }

    // Method to pay the bill
    public void payBill(int billID, double amount) {
        if (amount >= outstandingBillAmount) {
            System.out.println("Bill ID " + billID + " paid successfully. Amount paid: " + amount);
            outstandingBillAmount = 0.0;
        } else {
            System.out.println("Amount paid is less than the bill. Remaining balance: " + (outstandingBillAmount - amount));
            outstandingBillAmount -= amount;
        }
    }

    // Method to update the customer's details
    public void updateDetails(String name, String address, String email, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        System.out.println("Customer details updated successfully.");
    }

    // Method to enter meter reading
    public void enterReading(double reading) {
        System.out.println("Meter reading recorded: " + reading);
    }

    // Method to lodge a complaint about a bill
    public void complainAboutBill(int billID, String complaint) {
        String complaintMessage = "Complaint for Bill ID " + billID + ": " + complaint;
        complaints.add(complaintMessage);
        System.out.println("Complaint lodged successfully: " + complaintMessage);
    }


    // Main method for testing
    public static void main(String[] args) {
        OldCustomer customer1 = new OldCustomer("John Doe", "123 Elm Street", "johndoe@email.com", "123-456-7890", "MTR123456");

        // Viewing the bill
        customer1.viewBill();

        // Paying the bill
        customer1.payBill(101, 50.0);

        // Updating customer details
        customer1.updateDetails("Johnathan Doe", "456 Oak Street", "johnathan@email.com", "987-654-3210");

        // Entering a meter reading
        customer1.enterReading(350.0);

        // Lodging a complaint
        customer1.complainAboutBill(101, "Incorrect billing amount. Too high.");


    }
}

