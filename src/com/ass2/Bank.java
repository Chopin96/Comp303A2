package com.ass2;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args){
        System.out.println("hello world");

        Scanner scanner = new Scanner(System.in);

        int userInput = scanner.nextInt();

        if( userInput == 1) System.out.println("Create Customer Selected");

        else if (userInput ==2) System.out.println("Create Bank Account Selected");
    }
}
