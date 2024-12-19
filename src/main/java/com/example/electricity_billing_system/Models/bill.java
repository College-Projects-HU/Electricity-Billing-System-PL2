package com.example.electricity_billing_system.Models;


import com.example.electricity_billing_system.Utils.JsonUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

//bill class
public class bill {
    // Attributes (private to ensure encapsulation)
    private String meterCode;       // رمز العداد
    private int billID;          // Unique identifier for the bill
    private int customerID;      // ID of the customer the bill is issued for
    private int reading;         // Monthly meter reading
    private double consumption;  // Electricity consumption (calculated in units)
    private double amount;       // Total bill amount
    private String issueDate;    // Date when the bill was issued
    private String dueDate;      // Due date for bill payment
    private String status;       // Current status of the bill (e.g., "Paid", "Unpaid", "Overdue")
    @JsonIgnore
    private List<bill> Bills;
    @JsonIgnore
    private final String path = System.getProperty("user.dir") + "\\src\\main\\resources\\Data\\" + "Bills.json";

    // Static set to store unique userIDs
    //HashSet uses a hash table for storage, which provides constant
    //time (O(1)) complexity for lookups and insertions.

    // Constructor to initialize userID automatically
    public bill(int initialize) {
        try {
            Bills = JsonUtil.readFromJsonFile(path, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public bill() {}
    // Constructor to initialize the Bill object
    public bill(int billID,String meterCode, int customerID, int reading, double consumption, double amount, String issueDate, String dueDate, String status) {
        this.billID = billID;             // Set unique bill ID
        this.customerID = customerID;     // Set customer ID
        this.reading = reading;           // Set meter reading
        this.consumption = consumption;   // Set electricity consumption
        this.amount = amount;             // Set bill amount
        this.issueDate = issueDate;       // Set issue date
        this.dueDate = dueDate;           // Set due date
        this.status = status;             // Set initial status
        this.meterCode = meterCode;
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
    public List<bill> getBills() {
        return Bills;
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
//
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


    public double getAllMeterBillsAmount(String meterCode){
        double total = 0;
        for(bill bl : Bills){
            if (bl.getMeterCode().equals(meterCode) && !bl.getStatus().equals("paid"))
                total+=bl.getAmount();
        }
        return total;
    }
    public List<bill> getMeterBills(String meterCode) {
        return Bills
                .stream()
                .filter(b -> b.getMeterCode().equals(meterCode))
                .sorted(Comparator.comparing(bill::getDueDate)) // Sort by due date
                .collect(Collectors.toList());
    }

    public List<String> getAllBillsRegion() {
        Set<String> regionSet = new HashSet<>();
        Meter m = new Meter(1);
        for (bill b : Bills) {
            String region = m.checkMeterExist(b.getMeterCode()).getRegion();
            regionSet.add(region);
        }
        return new ArrayList<>(regionSet); // Convert Set back to List
    }
    public void setAllBillsPaidForMeter(String meterCode) {
        double total = 0;
        for (int i = 0; i < Bills.size(); i++) {
            if (Bills.get(i).getMeterCode().equals(meterCode)) {
                Bills.get(i).setStatus("paid");
                saveToJson(Bills);
                return;
            }
        }
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

    public void deletebill(List<bill> AllBills,int billID) {
        for (int i = 0; i < AllBills.size(); i++) {
            if (AllBills.get(i).getBillID() == billID) {
                AllBills.remove(i);
                System.out.println("removed with id: " + i);
                saveToJson(AllBills);
                return;
            }
        }
        System.out.println("User not found!");
    }

    public boolean addBill(List<bill>AllBills ,int billID,int customerID, int reading, double consumption, double amount, String issueDate, String dueDate, String status) {
        bill Bill = new bill();
        Bill.setBillID(billID);
        Bill.setCustomerID(customerID);
        Bill.setReading(reading);
        Bill.setConsumption(consumption);
        Bill.setAmount(amount);
        Bill.setIssueDate(issueDate);
        Bill.setDueDate(dueDate);
        Bill.setStatus(status);
        return saveToJson(AllBills);
    }



    // Method to send a reminder if the bill is unpaid
    public void sendReminder() {
        if (this.status.equals("Unpaid")) { // Check if the status is "Unpaid"
            System.out.println("Reminder: Your bill is unpaid. Please pay before the due date: " + dueDate);
        }
    }


    public String getMeterCode() {
        return meterCode;
    }

    public void setMeterCode(String meterCode) {
        this.meterCode = meterCode;
    }

}