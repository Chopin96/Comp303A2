package com.ass2;

import java.util.LinkedList;
import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {

        LinkedList<Customer> customerDatabase = new LinkedList<>();

        while(true){
            printMessage();
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();

            if(userInput==1){
                System.out.println("Please Enter Customer Information: name, ID, discount rate");
                String newName = scanner.next();
                int newId = scanner.nextInt();
                double newDiscountPercentage = Double.parseDouble(scanner.next());

                if (!isExistingCustomer(newId,customerDatabase)) {
                    customerDatabase.add(new Customer(newName, newId, newDiscountPercentage));
                }
                else {
                    System.out.println("Error: The Customer Already Exists");
                }

            }
            else if(userInput==2){
                System.out.println("Please Enter a Customer ID");
                int customerID = scanner.nextInt();
                System.out.println("Press S for saving account C for checking Account");
                String input = scanner.next();
                System.out.println("Please Enter Bank ID");
                int bankID = scanner.nextInt();
                System.out.println("Please Enter Initial Balance");
                double initialBalance = Double.parseDouble(scanner.next());

                Customer owner = findCustomer(customerID,customerDatabase);

                if(input.equals("s") && owner != null){
                    owner.createSavingAccount(bankID,initialBalance);

                } else if( input.equals("c") && owner != null){
                    owner.createCheckingAccount(bankID,initialBalance);

                } else {
                    System.out.println("Wrong Input or Invalid CustomerID");

                }

                //owner.printAllAccounts();


            }
            else if(userInput==3){

                System.out.println("Please Enter a Customer ID ");
                int customerID = scanner.nextInt();
                System.out.println("Please Enter Bank ID");
                int bankID = scanner.nextInt();

                Customer owner = findCustomer(customerID,customerDatabase);
                IBankAccount account = findBankAccount(bankID,owner.getAccountList());

                if (owner != null){
                    if(account != null) System.out.println(Double.toString(account.getBalance()));
                    else System.out.println("Bank account does not exist");

                } else System.out.println("Customer does not exist");

                //owner.printAllAccounts();



            }
            else if(userInput==4){

                System.out.println("Please Enter a Customer ID ");
                int customerID = scanner.nextInt();
                System.out.println("Please Enter Bank ID");
                int bankID = scanner.nextInt();
                System.out.println("Please Enter Deposit Amount");
                double depositAmount = Double.parseDouble(scanner.next());

                Customer owner = findCustomer(customerID,customerDatabase);
                IBankAccount account = findBankAccount(bankID,owner.getAccountList());

                if (owner != null){
                    if(account != null) account.deposit(depositAmount);
                    else System.out.println("Bank account does not exist");

                } else System.out.println("Customer does not exist");

                //owner.printAllAccounts();

            }
            else if(userInput==5){
                System.out.println("Please Enter Customer ID");
                int customerID = scanner.nextInt();
                System.out.println("Please Enter Bank ID");
                int bankID = scanner.nextInt();
                System.out.println("Please Enter Withdraw Amount");
                double withdrawAmount = Double.parseDouble(scanner.next());

                Customer owner = findCustomer(customerID,customerDatabase);
                IBankAccount account = findBankAccount(bankID,owner.getAccountList());

                if (owner != null){
                    if(account != null) account.withdraw(withdrawAmount);
                    else System.out.println("Bank account does not exist");

                } else System.out.println("Customer does not exist");

                //owner.printAllAccounts();


            }
            else if(userInput==6){

                System.out.println("Please Enter Customer ID");
                int customerID = scanner.nextInt();
                System.out.println("Please Enter Source Bank ID");
                int sourceBankID = scanner.nextInt();
                System.out.println("Please Enter Destination Bank ID");
                int destBankID = scanner.nextInt();
                System.out.println("Please Enter Transfer Amount");
                double transferAmount = Double.parseDouble(scanner.next());

                Customer owner = findCustomer(customerID,customerDatabase);

                IBankAccount sourceAccount = findBankAccount(sourceBankID,owner.getAccountList());
                IBankAccount destAccount = findBankAccount(destBankID,owner.getAccountList());

                if (owner != null) {
                    if (sourceAccount != null && destAccount != null){
                        sourceAccount.transferMoney(transferAmount,destAccount);

                    } else System.out.println("Account(s) does not exist");
                } else System.out.println("Customer does not exist");

                //owner.printAllAccounts();



            }

            else if(userInput==7){
                System.exit(0);

            }
            else {
                System.out.println("Invalid input");
            }


        }


    }

    public static void printMessage(){
        System.out.println("Welcome to the Bank");
        System.out.println("1.Create Customer");
        System.out.println("2.Create Bank Account");
        System.out.println("3.Get Balance");
        System.out.println("4.Deposit");
        System.out.println("5.Withdraw");
        System.out.println("6.Transfer Fund");
        System.out.println("7.Quit");

    }

    //Verify if customer is in the data base

    public static boolean isExistingCustomer(int id,LinkedList<Customer> customerDatabase){
        boolean isExisting = false;
        for(Customer c : customerDatabase){
            if(c.getCustomerID()== id) {
                isExisting = true;
            }
        }
        return isExisting;
    }

    //Verify if bank account is in customers account list

    public static boolean isExistingAccount(int id,LinkedList<IBankAccount> bankAccounts){
        boolean isExisting = false;
        for(IBankAccount b : bankAccounts){
            if (b.getAccountID() ==id){
                isExisting = true;
            }
        }
        return  isExisting;
    }
    //Traverse the linked list of customers and find the customer given an ID

    public static Customer findCustomer(int id,LinkedList<Customer> customerLinkedList) {
        if(isExistingCustomer(id,customerLinkedList)){
            for (Customer c : customerLinkedList){

                if (c.getCustomerID() == id) return c;
            }
        } else System.out.println("Customer does not exist");

        return null;
    }
    //Traverse the linked list of accounts and find the account given account ID

    public static IBankAccount findBankAccount(int id,LinkedList<IBankAccount> bankAccounts){
        if(isExistingAccount(id,bankAccounts)){
            for (IBankAccount b : bankAccounts){
                if (b.getAccountID()== id) return b;
            }
        } else System.out.println("Bank does not exist");

        return null;
    }




}
