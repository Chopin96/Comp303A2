package com.ass2;

import java.util.LinkedList;
import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        System.out.println("Welcome to the Bank");

        LinkedList<Customer> customerDatabase = new LinkedList<>();

        customerDatabase.add(new Customer("Xuan",1234,0));

        customerDatabase.get(0).createCheckingAccount(599,50000);

        customerDatabase.get(0).createSavingAccount(589,10000);

        customerDatabase.get(0).printAllAccounts();

        customerDatabase.get(0).getAccountList().get(0).transferMoney(10,customerDatabase.get(0).getAccountList().get(1));

        customerDatabase.get(0).printAllAccounts();


    }

}
