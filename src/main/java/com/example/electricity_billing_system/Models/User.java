package com.example.electricity_billing_system.Models;

import com.example.electricity_billing_system.Models.OldCustomer;
import com.example.electricity_billing_system.Utils.JsonUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class User {
    private String userName;
    private String userPassword;
    private String userRole;
    private int userID;
    @JsonIgnore
    private List<OldCustomer> allCustomers;
    @JsonIgnore
    private final String path = System.getProperty("user.dir") + "\\src\\main\\resources\\data\\" + "Customers.json";

    // Static set to store unique userIDs
    //HashSet uses a hash table for storage, which provides constant
    //time (O(1)) complexity for lookups and insertions.

    // Constructor to initialize userID automatically
    public User() {}
    // Constructor to initialize userID automatically
    public User(int userID ,String userName,String userPassword) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRole = "user";
    }
    
    
    
    // Mutators
    public void setUserName(String userName){
        this.userName=userName;
    }
    public void setUserPassword(String userPassword){
        this.userPassword=userPassword;
    }
    public void setUserRole(String userRole){
        this.userRole=userRole;
    }

    
    // Accessors
    public String getUserName(){
       return userName;
    }
    public String getUserPassword(){
       return userPassword;
    }
    public String getUserRole(){
       return userRole;
    }
    public int getUserID(){
       return userID;
    }
    

    // CreatAccount
    public boolean createAccount(String name, String password, String role) {
        OldCustomer customer = new OldCustomer();
        customer.setUserName(name);
        customer.setUserPassword(password);
        customer.setUserRole(role);
        allCustomers.add(customer);
        return saveToJson();
    }

    public List<OldCustomer> allCustomers() throws IOException {
        allCustomers = JsonUtil.readFromJsonFile(path, new TypeReference<>() {});
        return allCustomers;
    }



    //Logout













    public int getLAST_ID() {
        return allCustomers.size();
    }

    public List<OldCustomer> getCustomers() {
        return allCustomers;
    }
    public OldCustomer getCustomerById(int id) {
        Optional<OldCustomer> customer = allCustomers.stream().filter(c -> c.getUserID() == (id))
                .findFirst();
        return customer.orElse(null);
    }

    public boolean addCustomer(OldCustomer customer) {
        allCustomers.add(customer);
        return saveToJson();
    }

    // Update an existing user
    public boolean updateUser(OldCustomer updatedUser) {
        for (int i = 0; i < allCustomers.size(); i++) {
            if (allCustomers.get(i).getUserID() == updatedUser.getUserID()) {
                allCustomers.set(i, updatedUser);
                return saveToJson();
            }
        }
        return false;
    }

    // Delete a user by their userID
    public boolean deleteUser(int userID) {
        for (int i = 0; i < allCustomers.size(); i++) {
            if (allCustomers.get(i).getUserID() == userID) {
                allCustomers.remove(i);
                return saveToJson();
            }
        }
        System.out.println("User not found!");
        return false;
    }

  /*  public List<bill> getCustomerBills(int id) {
        BillingService billingService = new BillingService();
        return billingService.getAllBills()
                .stream()
                .filter(b -> b.getCustomerID() ==(id))
                .sorted(Comparator.comparing(bill::getDueDate)) // Sort by due date
                .collect(Collectors.toList());
    }*/
    private boolean saveToJson() {
        try {
            JsonUtil.writeToJsonFile(allCustomers,path);
            return true;
        } catch (IOException e) {
            System.out.println("Failed to save customers to file: " + e.getMessage());
        }
        return false;
    }
}

