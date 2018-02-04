package com.ass2;

public class CheckingAccount implements IBankAccount {

    private int accountID;
    private double balance;
    private Customer owner;


    public CheckingAccount(int accountID,double balance,Customer customer) {
        this.setAccountID(accountID);
        this.setOwner(customer);
        this.setBalance(balance);
    }

    @Override
    public void withdraw(double amount) {
        this.balance = this.balance - amount;

        //Deduct withdrawal fee from account
        this.balance = this.balance - (1-this.owner.getDiscountPercentage());

    }

    @Override
    public void deposit(double amount) {
        this.balance = this.balance + amount;

    }

    @Override
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    @Override
    public int getAccountID() {
        return this.accountID;
    }

    @Override
    public void setBalance(double amount) {
        this.balance = amount;
    }

    @Override
    public double getBalance() {
        return  this.balance;
    }

    @Override
    public void setOwner(Customer customer) {
        this.owner = customer;
    }

    @Override
    public Customer getOwner() {
        return this.owner;
    }

    @Override
    public void transferMoney(double transferAmount, IBankAccount other) {
        if(this.getOwner().isSame(other.getOwner())) {

            // Destination account is owned by the same customer, proceed with transfer operation.
            this.withdraw(transferAmount);
            other.deposit(transferAmount);

        } else {

            // Destination account is not owned by the customer, deny transfer.
            System.out.println("Transfer failed, unauthorized action");

        }
    }
}
