package com.ass2;

public class Customer {
    private String name;
    private int customerID;
    private double discountPercentage;

    public Customer(String name, int customerID, double discountPercentage) {
        this.name = name;
        this.customerID = customerID;
        this.discountPercentage = discountPercentage;
    }

    public String getName() {
        return name;
    }

    public int getCustomerID() {
        return customerID;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }
}
