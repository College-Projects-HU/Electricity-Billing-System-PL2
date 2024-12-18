package com.example.electricity_billing_system.Models;


import java.util.ArrayList;

public class Operator {
    // ArrayList to manage meters
    private ArrayList<Meter> meters;

    // Constructor
    public Operator() {
        this.meters = new ArrayList<>();
    }

    // Method to collect payments from customer
    public void collectPayment(String meterCode, double amount) {
        Meter meter = findMeterByCode(meterCode);
        if (meter != null) {
            System.out.println("Payment of " + amount + " collected for meter: " + meterCode);
        } else {
            System.out.println("Meter with code " + meterCode + " not found.");
        }
    }

    // Method to print bill for a meter
    public void printBill(String meterCode) {
        Meter meter = findMeterByCode(meterCode);
        if (meter != null) {
            System.out.println("Bill for Meter Code: " + meter.getMeterCode());
            System.out.println("Region: " + meter.getRegion());
            System.out.println("Current Reading: " + meter.getMonthlyReading());
        } else {
            System.out.println("Meter with code " + meterCode + " not found.");
        }
    }

    // Method to view bills of a specific region
    public void viewBillsByRegion(String region) {
        boolean found = false;
        for (Meter meter : meters) {
            if (meter.getRegion().toString().equalsIgnoreCase(region)) {
                System.out.println(meter.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No meters found in region: " + region);
        }
    }

    // Method to validate reading with real consumption
    public void validateReading(String meterCode, double realConsumption) {
        Meter meter = findMeterByCode(meterCode);
        if (meter != null) {
            if (meter.getMonthlyReading() == realConsumption) {
                System.out.println("Reading for meter " + meterCode + " is valid.");
            } else {
                System.out.println("Discrepancy found for meter " + meterCode + ". Expected: " + realConsumption + ", Found: " + meter.getMonthlyReading());
            }
        } else {
            System.out.println("Meter with code " + meterCode + " not found.");
        }
    }

    // Method to define tariff for a customer
    public void defineTariff(String meterCode, double tariff) {
        Meter meter = findMeterByCode(meterCode);
        if (meter != null) {
            System.out.println("Tariff of " + tariff + " set for meter: " + meterCode);
        } else {
            System.out.println("Meter with code " + meterCode + " not found.");
        }
    }

    // Method to stop meter and cancel subscription
    public void stopMeter(String meterCode) {
        Meter meter = findMeterByCode(meterCode);
        if (meter != null) {
            meter.deactivateMeter();
            System.out.println("Meter " + meterCode + " has been stopped and subscription canceled.");
        } else {
            System.out.println("Meter with code " + meterCode + " not found.");
        }
    }

    // Method to add a meter
    public void addMeter(Meter meter) {
        if (findMeterByCode(meter.getMeterCode()) == null) {
            meters.add(meter);
            System.out.println("Meter " + meter.getMeterCode() + " added successfully.");
        } else {
            System.out.println("Meter with code " + meter.getMeterCode() + " already exists!");
        }
    }

    // Helper method to find a meter by its code
    private Meter findMeterByCode(String meterCode) {
        for (Meter meter : meters) {
            if (meter.getMeterCode().equals(meterCode)) {
                return meter;
            }
        }
        return null; // Return null if meter is not found
    }
}