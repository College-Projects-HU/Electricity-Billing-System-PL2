package com.example.electricity_billing_system.Models;

import com.example.electricity_billing_system.Utils.JsonUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.List;

public class Meter {

    // Attributes (fields)
    private String meterCode; // رمز العداد
    private String region;     // المنطقة التي ينتمي لها العداد (تم تغييرها إلى Region)
    private double monthlyReading; // القراءة الحالية للعداد
    private double monthlyConsumption;
    private boolean isActive; // حالة العداد (نشط أو متوقف)
    private String tariff;
    @JsonIgnore
    private List<Meter> meters;
    @JsonIgnore
    private final String path = System.getProperty("user.dir") + "\\src\\main\\resources\\Data\\" + "Meters.json";

    // Static set to store unique userIDs
    //HashSet uses a hash table for storage, which provides constant
    //time (O(1)) complexity for lookups and insertions.

    // Constructor to initialize userID automatically
    public Meter(int initialize) {
        try {
            meters = JsonUtil.readFromJsonFile(path, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Meter() {
    }

    // Constructor
    public Meter(String meterCode, String region, double monthlyReading, boolean isActive, String tariff) {
        this.meterCode = meterCode;
        this.region = region;
        this.monthlyReading = 0.0; // القراءة الافتراضية
        this.isActive = true;      // العداد نشط افتراضيًا
        this.tariff = tariff;
    }

    // Getters and Setters
    public String getMeterCode() {
        return meterCode;
    }

    public void setMeterCode(String meterCode) {
        this.meterCode = meterCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getMonthlyReading() {
        return monthlyReading;
    }

//    public double getMonthlyReadingByCode(Meter meter) {
//        for (int i = 0; i < meters.size(); i++) {
//            if (meters.get(i).getMeterCode().equals(meter.getMeterCode())) {
//                return meter.getMonthlyReading();
//            }
//        }
//        return 0.0;
//    }


    public void setMonthlyReading(double monthlyReading) {
        this.monthlyReading = monthlyReading;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    // Methods
    public void updateReading(Meter meter,double newReading) {
        for (int i = 0; i < meters.size(); i++) {
            if (meters.get(i).getMeterCode().equals(meter.getMeterCode())) {
                meters.get(i).setMonthlyReading(newReading);
                saveToJson();
            }
        }
        if (newReading >= monthlyReading) {
            this.monthlyReading = newReading;
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

    /*
     *  TODO : Check
     */


    private boolean saveToJson() {
        try {
            JsonUtil.writeToJsonFile(meters, path);
        } catch (IOException e) {
            System.out.println("errrorr" + e.getMessage());
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public String toString() {
        return "Meter Code: " + meterCode +
                ", Region: " + region.toString() +  // نستخدم toString() من فئة Region
                ", Current Reading: " + monthlyReading +
                ", Active: " + isActive;
    }

    public void getAllMetersDetails(List<Meter> meters) {
        for (int i = 0; i < meters.size(); i++) {
            System.out.println("Meter Details:");
            System.out.println("Meter code: " + meterCode);
            System.out.println("Region: " + region);
            System.out.println("current Reading: " + monthlyReading);
            System.out.println("isActive: " + isActive);

        }
    }

    public Meter checkMeterExist(String meterCode) {
        for (Meter meter : meters) {
            if (meter.getMeterCode().equals(meterCode)) {
                return meter;
            }
        }
        return null;
    }

    public double getMonthlyConsumption() {
        return monthlyConsumption;
    }

    public void setMonthlyConsumption(double monthlyConsumption) {
        this.monthlyConsumption = monthlyConsumption;
    }

    public void updateMeterStatus(Meter currentMeter, boolean active) {
        for (int i = 0; i < meters.size(); i++) {
            if (meters.get(i).getMeterCode().equals(currentMeter.getMeterCode())) {
                meters.get(i).setIsActive(active);
                saveToJson();
            }
        }
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public void setTariffForMeter(Meter currentMeter, String tariff) {
        for (int i = 0; i < meters.size(); i++) {
            if (meters.get(i).getMeterCode().equals(currentMeter.getMeterCode())) {
                meters.get(i).setTariff(tariff);
                saveToJson();
            }
        }
    }
}
