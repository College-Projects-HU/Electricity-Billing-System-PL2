package com.example.electricity_billing_system.Models;


import com.example.electricity_billing_system.Utils.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.List;

//bill class
public class bill {
    // Attributes (private to ensure encapsulation)

    private int billID;          // Unique identifier for the bill
    private int customerID;      // ID of the customer the bill is issued for
    private int reading;         // Monthly meter reading
    private double consumption;  // Electricity consumption (calculated in units)
    private double amount;       // Total bill amount
    private String issueDate;    // Date when the bill was issued
    private String dueDate;      // Due date for bill payment
    private String status;       // Current status of the bill (e.g., "Paid", "Unpaid", "Overdue")

    public bill() {}
    // Constructor to initialize the Bill object
    public bill(int billID, int customerID, int reading, double consumption, double amount, String issueDate, String dueDate, String status) {
        this.billID = billID;             // Set unique bill ID
        this.customerID = customerID;     // Set customer ID
        this.reading = reading;           // Set meter reading
        this.consumption = consumption;   // Set electricity consumption
        this.amount = amount;             // Set bill amount
        this.issueDate = issueDate;       // Set issue date
        this.dueDate = dueDate;           // Set due date
        this.status = status;             // Set initial status
    }
    public List<bill> readBillsData() {
        try {
                String billFile = System.getProperty("user.dir") + "\\src\\main\\resources\\" + "Data\\Bills.json";
            return JsonUtil.readFromJsonFile(billFile, new TypeReference<List<bill>>() {});

            } catch (IOException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
    }
    // Getters and Setters for all attributes
    // Allow controlled access and modification of private attributes
    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
// FIXME : UNIDENTIFIED VARIABLE : meterCode

//    public String getMeterCode() {
//        return meterCode;
//    }

//    public void setMeterCode(String meterCode) {
//        this.meterCode = meterCode;
//    }

    public int getReading() {
        return reading;
    }

    public void setReading(int reading) {
        this.reading = reading;
    }


    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Method to calculate the total bill amount based on consumption and tariff
    public void calculateBill(double tariff) {
        this.amount = this.consumption * tariff; // Multiply consumption by the tariff rate
        System.out.println("Bill calculated successfully. Total amount: " + this.amount);
    }



    private boolean saveToJson(List<bill> bills) {
        try {
            String billFile = System.getProperty("user.dir") + "\\src\\main\\resources\\" + "Data\\Bills.json";

            JsonUtil.writeToJsonFile(bills, billFile);
            return true;
        } catch (IOException e) {
            System.out.println("Failed to save customers to file: " + e.getMessage());
        }
        return false;
    }


    // Method to update the status of the bill (e.g., from "Unpaid" to "Paid")
   public void updateStatus(List<bill> AllBills,int billdID, String newStatus) {
        for (int i = 0; i < AllBills.size(); i++) {
            if (AllBills.get(i).getBillID() == billdID) {
                AllBills.get(i).setStatus(newStatus);
                saveToJson(AllBills);
                System.out.println("Bill updated successfully with id: " + billdID);
                return;
            }
        }
        this.status = newStatus; // Update the status
        System.out.println("Bill status updated to: " + this.status);
    }

   public void getAllBillsDetails(List<bill> AllBills){
       for (int i = 0; i < AllBills.size(); i++) {
           System.out.println("Bill Details:");
           System.out.println("Bill ID: " + billID);
           System.out.println("Customer ID: " + customerID);
           System.out.println("Reading: " + reading);
           System.out.println("Consumption: " + consumption + " units");
           System.out.println("Amount: " + amount);
           System.out.println("Issue Date: " + issueDate);
           System.out.println("Due Date: " + dueDate);
           System.out.println("Status: " + status);
       }
   }

    public void getSpecificBillDetails(List<bill> AllBills,int billdID) {
        for (int i = 0; i < AllBills.size(); i++) {
            if (AllBills.get(i).getBillID() == billdID) {
                System.out.println("Bill Details:");
                System.out.println("Bill ID: " + billID);
                System.out.println("Customer ID: " + customerID);
                System.out.println("Reading: " + reading);
                System.out.println("Consumption: " + consumption + " units");
                System.out.println("Amount: " + amount);
                System.out.println("Issue Date: " + issueDate);
                System.out.println("Due Date: " + dueDate);
                System.out.println("Status: " + status);
                return;
            }
        }
    }

    public void deletebill(list<bill>AllBills,int billID) {
        for (int i = 0; i < ALlBills.size(); i++) {
            if (ALlBills.get(i).getBillID() == billID) {
                ALlBills.remove(i);
                System.out.println("removed with id: " + i);
                saveToJson(ALlBills);
                return;
            }
        }
        System.out.println("User not found!");
    }

    public boolean addBill(list<bill>AllBills) {
        bill Bill = new Bill( int billID, int customerID, int reading, double consumption, double amount, String
        issueDate, String dueDate, String status);
        return saveToJson(AllBills);
    }




















    // Method to send a reminder if the bill is unpaid
    public void sendReminder() {
        if (this.status.equals("Unpaid")) { // Check if the status is "Unpaid"
            System.out.println("Reminder: Your bill is unpaid. Please pay before the due date: " + dueDate);
        }
    }





}