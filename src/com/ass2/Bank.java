package com.ass2;

import java.util.HashMap;
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
                System.out.println("Please Enter Customer Informations: name, ID, discount rate");
                String newName = scanner.next();
                int newId = scanner.nextInt();
                double newDiscountPercentage = Double.parseDouble(scanner.next());
                customerDatabase.add(new Customer(newName,newId,newDiscountPercentage));
            }
            else if(userInput==2){
                System.out.println("Please Enter a Customer ID");
                int customerID = scanner.nextInt();

                System.out.println("Press S for saving account C for checking Account");

            }
            else if(userInput==3){
                System.out.println("Please Enter a Customer ID ");
                System.out.println("Please Enter Bank ID");

            }
            else if(userInput==4){
                System.out.println("Please Enter Customer ID");
                System.out.println("Please Enter Bank ID");
                System.out.println("Please Enter Amount");

            }
            else if(userInput==5){
                System.out.println("Please Enter Customer ID");
                System.out.println("Please Enter Source Bank ID");
                System.out.println("Please Enter Destination Bank ID");
                System.out.println("Please Enter Transfer Amount");


            }
            else if(userInput==6){

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
        System.out.println("5.Make a Transfer");
        System.out.println("6.Quit");

    }


}
