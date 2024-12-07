package com.example.electricity_billing_system.Models;

public class Region {
    private String Region;
    private String regionCode;
    private String regionName;
    private String customerID;
    
    // Mutators
    public void setRegion(String Region){
        this.Region=Region;
    }
    public void setRegionCode(String regionCode){
        this.regionCode=regionCode;
    }
    public void setRegionName(String regionName){
        this.regionName=regionName;
    }
    public void setCustomerID(String customerID){
        this.customerID=customerID;
    }
    
    // Accessors
    public String getRegion(){
        return Region;
    }
    public String getRegionCode(){
        return regionCode;
    }
    public String getRegionName(){
        return regionName;
    }
    public String getCustomerID(){
        return customerID;
    }
    
    public void addCustomer(String customerID , String Region){
        setCustomerID(customerID);
        setRegion( Region);
        System.out.println("Customer with ID : " + customerID + " " + "add to region " + Region);
    }
    
    
}
