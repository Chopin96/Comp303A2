package com.ass2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.HashMap;

public class Customer {
    private String name;
    private int customerID;
    private double discountPercentage;
    private LinkedList<IBankAccount> accounts;


    public String getCustomerName() {
        return name;
    }

    public int getCustomerID() {
        return customerID;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setDiscountPercentage(double discountPercentage) {
        if(discountPercentage > 0 && discountPercentage < 1) {

            this.discountPercentage = discountPercentage;

        } else {

            System.out.println("Invalid discount percentage");

        }
    }


    public boolean isSame(Customer other){
        if(this.getCustomerID() == other.getCustomerID()) return true;
        else return false;
    }

}
