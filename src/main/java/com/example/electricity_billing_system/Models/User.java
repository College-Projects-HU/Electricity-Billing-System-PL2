package com.example.electricity_billing_system.Models;

import com.example.electricity_billing_system.Utils.JsonUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.*;

public class User {
    private String userName;
    private String userPassword;
    private String userRole;
    private int userID;
    @JsonIgnore
    private List<OldCustomer> allCustomers;
    @JsonIgnore
    private final String path = System.getProperty("user.dir") + "\\src\\main\\resources\\Data\\" + "Customer.json";

    // Static set to store unique userIDs
    //HashSet uses a hash table for storage, which provides constant
    //time (O(1)) complexity for lookups and insertions.

    // Constructor to initialize userID automatically
    public User(int initialize)  {
        try {
            allCustomers = JsonUtil.readFromJsonFile(path, new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public User(){}
    // Constructor to initialize userID automatically
    public User(int userID ,String userName,String userPassword,String userRole) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRole = userRole;
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
    public void setUserID(int id){
        this.userID = id;
    }
    

    // CreatAccount
    public boolean createAccount(String name, String password, String role,String Email , String Region) {
        OldCustomer customer = new OldCustomer();
        customer.setUserName(name);
        customer.setUserPassword(password);
        customer.setUserRole(role);
        customer.setEmail(Email);
        customer.setAddress(Region);
        customer.setUserID(allCustomers.size() + 1);
        allCustomers.add(customer);
        return saveToJson();
    }

    public List<OldCustomer> allCustomers() throws IOException {
        return allCustomers;
    }

    public void addComplaint(String userName, String complaint) {
        for (OldCustomer customer : allCustomers) {
            if (customer.getUserName().equals(userName)) {
                if (customer.getComplaints() == null) {
                    customer.setComplaints(new ArrayList<>());
                }
                customer.getComplaints().add(complaint);
                saveToJson();
                return;
            }
        }
        System.out.println("User not found!");
    }

    //Logout

    @JsonIgnore

    public List<OldCustomer> getCustomers() {
        return allCustomers;
    }
    @JsonIgnore

    public OldCustomer checkUserExist(String username, String password) {
        Optional<OldCustomer> customer = allCustomers.stream().filter(c -> c.getUserName().equals(username) && c.getUserPassword().equals(password))
                .findFirst();
        return customer.orElse(null);
    }

    public void addCustomer(OldCustomer customer) {
        allCustomers.add(customer);
        saveToJson();
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
    public void deleteUser(int userID) {
        for (int i = 0; i < allCustomers.size(); i++) {
            if (allCustomers.get(i).getUserID() == userID) {
                allCustomers.remove(i);
                System.out.println("removed with id: " + i);
                saveToJson();
                return;
            }
        }
        System.out.println("User not found!");
    }


    private boolean saveToJson() {
        try {
            JsonUtil.writeToJsonFile(allCustomers,path);
        } catch (IOException e) {
            System.out.println("errrorr" + e.getMessage());
            throw new RuntimeException(e);
        }
        return true;
    }
}

