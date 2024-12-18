package com.example.electricity_billing_system.Models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class OldCustomer extends User {
    private String address;
    private String email;
    private String phoneNumber;
    private String meterNumber;
    private double outstandingBillAmount;

    @JsonProperty("complaints") // Ensure Jackson recognizes this field when deserializing from JSON
    private List<String> complaints;
    public OldCustomer(){
        super();
    }
    public OldCustomer(String address, String email, String phoneNumber, String meterNumber) {
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.meterNumber = meterNumber;
        this.outstandingBillAmount = 0.0;
        this.complaints = new ArrayList<>();
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

    public void setComplaints(List<String> complaints) {
        this.complaints = complaints;
    }

    public List<String> getComplaints() {
        return this.complaints;
    }


    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    public double getOutstandingBillAmount() {
        return outstandingBillAmount;
    }


    @Override
    public String getUserName() {
        return super.getUserName();
    }

    @Override
    public String getUserPassword() {
        return super.getUserPassword();
    }

    @Override
    public int getUserID() {
        return super.getUserID();
    }
    @Override
    public void setUserName(String name) {
        super.setUserName(name);
    }

    @Override
    public void setUserPassword(String password) {
        super.setUserPassword(password);
    }
    @Override
    public void setUserRole(String role) {
        super.setUserRole(role);
    }
    public void setUserID(int Id) {
        super.setUserID(Id);
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
        super.setUserName(name);
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
}

