package com.ass2;

public interface IBankAccount {

    void withdraw(double amount);

    void deposit(double amount);

    void setBalance(double amount);

    double getBalance();

    void setOwner(Customer customer);

    Customer getOwner();

    void transferMoney(double amount,IBankAccount other);
}
