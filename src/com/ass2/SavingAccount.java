package com.ass2;

public class SavingAccount {
    private double balance;

    public void withdrawMoney(double amount){
        if(amount>=1000) {
            this.balance = this.balance - amount;
        }
    }

}
