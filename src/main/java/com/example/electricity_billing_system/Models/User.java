package com.example.electricity_billing_system.Models;

import java.util.*;
public class User {
    private String userName;
    private String userPassword;
    private String userRole;
    private int userID;
    private static int nextUserID = 1;
    
    // Static set to store unique userIDs
    //HashSet uses a hash table for storage, which provides constant
    //time (O(1)) complexity for lookups and insertions.
    private static Set<Integer> userIDs = new HashSet<>();
    
    // Constructor to initialize userID automatically
    public User() {
        this.userID = generateUniqueUserID();
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
    
    // Method to generate a unique userID by incrementing the counter
    // TODO : Check cases
    private int generateUniqueUserID() {
        int newUserID = nextUserID;

        // Ensure the ID is unique
        while (userIDs.contains(newUserID)) {
            newUserID++;
        }
        userIDs.add(newUserID);
        nextUserID = newUserID + 1;

        return newUserID;
    }
    
    // CreatAccount
    public void createAccount(String name, String password, String role) {
        setUserName(name);
        setUserPassword(password);
        setUserRole(role);
        System.out.println("Account Created Successfully :) ");
    }

    
    //Login
    public boolean Login(String name, String password) {
        if (userName == null || userPassword == null) {
            System.out.println("Account does not exist. Please create an account first.");
            return false;
        }

        if (this.userName.equals(name) && this.userPassword.equals(password)) {
            System.out.println("Login Successful :)");
            return true;
        } else {
            System.out.println("Invalid UserName or Password, please try again :( ");
            return false;
        }
}

    
    //Logout
    public void Logout(){
        System.out.println("Logged Out Successfully :)");
    }
}

