package com.example.electricity_billing_system.Models;

import java.util.ArrayList;

public class Admin extends User {
    
    // Dynamic lists to store bills and users
    private ArrayList<bill> regionBills = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    // View all bills for a specific region
    public ArrayList<bill> viewAllBills(String region) {
        ArrayList<bill> filteredBills = new ArrayList<>();

      /*  for (com.example.electricity_billing_system.Models.bill bill : regionBills) {
            if (bill.getRegion().equals(region)) {
                filteredBills.add(bill);
            }
        }
*/
        return filteredBills;
    }

    // View total collected for a specific region
    public double viewTotalCollected(String region) {
        double totalCollected = 0.0;

       /* for (com.example.electricity_billing_system.Models.bill bill : regionBills) {
            if (bill.getRegion().equals(region)) {
                totalCollected += bill.getAmountPaid();
            }
        }*/

        return totalCollected;
    }

    // Generate consumption statistics for a specific region
    public Statistics generateConsumptionStatistics(String region) {
        ArrayList<bill> filteredBills = new ArrayList<>();
        /*for (com.example.electricity_billing_system.Models.bill bill : regionBills) {
            if (bill.getRegion().equals(region)) {
                filteredBills.add(bill);
            }
        }*/

        if (filteredBills.isEmpty()) {
            System.out.println("No data available for the specified region.");
            return new Statistics(0, 0, 0, 0);
        }

        double totalConsumption = 0.0;
        double maxConsumption = Double.MIN_VALUE;
        double minConsumption = Double.MAX_VALUE;

        for (com.example.electricity_billing_system.Models.bill bill : filteredBills) {
            double consumption = bill.getConsumption();
            totalConsumption += consumption;
            maxConsumption = Math.max(maxConsumption, consumption);
            minConsumption = Math.min(minConsumption, consumption);
        }

        double averageConsumption = totalConsumption / filteredBills.size();

        return new Statistics(totalConsumption, averageConsumption, maxConsumption, minConsumption);
    }
    

    // Add a new user
    public void addUser(User user) {
        users.add(user);
        System.out.println("User added successfully: " + user.getUserName());
    }
    
    

    // Update an existing user
    public void updateUser(User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserID() == updatedUser.getUserID()) {
                users.set(i, updatedUser);
                System.out.println("User updated successfully: " + updatedUser.getUserName());
                return;
            }
        }
        System.out.println("User not found!");
    }

}

/*
// Supporting Class for Bill
class Bill {
    private double amountPaid;
    private double consumption;
    private String region;

    public Bill(double amountPaid, double consumption, String region) {
        this.amountPaid = amountPaid;
        this.consumption = consumption;
        this.region = region;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public double getConsumption() {
        return consumption;
    }

    public String getRegion() {
        return region;
    }
}
*/
// Supporting Class for Statistics

class Statistics {
    private double totalConsumption;
    private double averageConsumption;
    private double maxConsumption;
    private double minConsumption;

    public Statistics(double totalConsumption, double averageConsumption, double maxConsumption, double minConsumption) {
        this.totalConsumption = totalConsumption;
        this.averageConsumption = averageConsumption;
        this.maxConsumption = maxConsumption;
        this.minConsumption = minConsumption;
    }

    @Override
    public String toString() {
        return  "Total Consumption=" + totalConsumption +
                ", Average Consumption=" + averageConsumption +
                ", Max Consumption=" + maxConsumption +
                ", Min Consumption=" + minConsumption +
                '}';
    }
}

