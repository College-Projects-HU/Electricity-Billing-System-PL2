package com.example.electricity_billing_system.Models;

public class Newcustomer {
    // Attributes for the customer information and contract copy
    private String name;
    private String address;
    private String email;
    private String phone;
    private String contractCopy;

    // Constructor (optional, can be used to initialize if needed)
    public Newcustomer() {
        // Default constructor, initialize attributes to default values if necessary
    }

    // Method to fill in customer information
    public void fillInformation(String name, String address, String email, String phone) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        System.out.println("Customer information filled successfully.");
    }

    // Method to attach the contract copy
    public void attachContractCopy(String contractCopy) {
        this.contractCopy = contractCopy;
        System.out.println("Contract copy attached: " + contractCopy);
    }

    
    // Getter methods (optional, for accessing private variables if needed)
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getContractCopy() {
        return contractCopy;
    }
