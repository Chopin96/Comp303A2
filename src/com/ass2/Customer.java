package com.ass2;

import java.util.Iterator;
import java.util.LinkedList;

public class Customer {
    private  String name;
    private  int customerID;
    private double discountPercentage;

    private LinkedList<IBankAccount> accountList = new LinkedList<>(); //List of bank accounts belonging to customer;

    public Customer(String name, int customerID, double discountPercentage) {
        this.setName(name);
        this.setCustomerID(customerID);
        this.setDiscountPercentage(discountPercentage);
    }


    public String getCustomerName() {
        return this.name;
    }

    public int getCustomerID() {
        return this.customerID;
    }

    public double getDiscountPercentage() {
        return this.discountPercentage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setDiscountPercentage(double discountPercentage) {

        //Discount rate must be a value between 0 and 1

        if(discountPercentage >= 0 && discountPercentage <= 1) this.discountPercentage = discountPercentage;

        else System.out.println("Invalid discount percentage");
    }
    //Add a saving account linked to the customer
    public void createSavingAccount(int newAccountID,double initialBalance){
        this.accountList.add(new SavingAccount(newAccountID,initialBalance,this));
    }

    //Add a checking account linked to the customer
    public void createCheckingAccount(int newAccountID,double initialBalance){
        this.accountList.add(new CheckingAccount(newAccountID,initialBalance,this));
    }


    public LinkedList<IBankAccount> getAccountList() {
        return accountList;
    }

    //Function printing all the accounts belonging to a customer, used for debugging.

    /*public void printAllAccounts(){
        Iterator<IBankAccount> itr;
        itr = this.accountList.listIterator();

        while(itr.hasNext()){

            IBankAccount next = itr.next();

            System.out.println(Integer.toString(next.getAccountID())+' '+Double.toString(next.getBalance()));


        }
    }*/

    //Function to verify whether two customers are the same.
    //Used during money transfer.
    public boolean isSame(Customer other){
        if(this.getCustomerID() == other.getCustomerID()) return true;
        else return false;
    }

}
