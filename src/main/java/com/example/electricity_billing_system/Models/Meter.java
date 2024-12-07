package com.example.electricity_billing_system.Models;

public class Meter {
    // Attributes (fields)
    private String meterCode; // رمز العداد
    private Region region;     // المنطقة التي ينتمي لها العداد (تم تغييرها إلى Region)
    private double currentReading; // القراءة الحالية للعداد
    private boolean isActive; // حالة العداد (نشط أو متوقف)

    // Constructor
    public Meter(String meterCode, Region region) {
        this.meterCode = meterCode;
        this.region = region;
        this.currentReading = 0.0; // القراءة الافتراضية
        this.isActive = true;      // العداد نشط افتراضيًا
    }

    // Getters and Setters
    public String getMeterCode() {
        return meterCode;
    }

    public void setMeterCode(String meterCode) {
        this.meterCode = meterCode;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region; 
    }

    public double getCurrentReading() {
        return currentReading;
    }

    public void setCurrentReading(double currentReading) {
        this.currentReading = currentReading;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    // Methods
    public void updateReading(double newReading) {
        if (newReading >= currentReading) {
            this.currentReading = newReading;
        } else {
            System.out.println("Error: New reading cannot be less than the current reading!");
        }
    }

    public void deactivateMeter() {
        this.isActive = false;
        System.out.println("Meter " + meterCode + " has been deactivated.");
    }

    public void activateMeter() {
        this.isActive = true;
        System.out.println("Meter " + meterCode + " has been activated.");
    }

    @Override
    public String toString() {
        return "Meter Code: " + meterCode +
               ", Region: " + region.toString() +  // نستخدم toString() من فئة Region
               ", Current Reading: " + currentReading +
               ", Active: " + isActive;
    }
}