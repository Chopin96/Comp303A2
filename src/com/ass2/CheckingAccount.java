package com.ass2;

public class CheckingAccount implements IBankAccount {

    private double balance;
    private Customer owner;


    public CheckingAccount(double balance,Customer customer) {
        this.setOwner(customer);
        this.setBalance(balance);
    }

    @Override
    public void withdraw(double amount) {
        this.balance =- amount;

        //Deduct withdrawal fee from account
        this.balance =- (1-this.owner.getDiscountPercentage());

    }

    @Override
    public void deposit(double amount) {
        this.balance =+ amount;

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
            other.deposit(transferAmount);

        } else {

            // Destination account is not owned by the customer, deny transfer.
            System.out.println("Transfer failed, unauthorized transfer");

        }
    }
}
