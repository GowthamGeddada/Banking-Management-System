package com.bank.controller;

import com.bank.exception.AccountNotFoundException;
import com.bank.model.Account;
import com.bank.service.AccountService;
import com.bank.service.AccountServiceImpl;

import java.util.List;
import java.util.Scanner;

public class AccountController {

    public static void main(String[] args) {

        AccountService service = new AccountServiceImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Banking Management System ---");
            System.out.println("1. Open Account");
            System.out.println("2. View Account By ID");
            System.out.println("3. Deposit Amount");
            System.out.println("4. Withdraw Amount");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter Account ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Holder Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Account Type: ");
                        String type = sc.nextLine();

                        System.out.print("Enter Initial Balance: ");
                        double bal = sc.nextDouble();

                        try{service.openAccount(
                            new Account(id, name, type, bal));
                        }catch(Exception e) {
                        System.out.println(e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.print("Enter Account ID: ");
                        int accId = sc.nextInt();

                        Account acc = service.fetchAccount(accId);
                        System.out.println(acc);
                        break;

                    case 3:
                        System.out.print("Enter Account ID: ");
                        int depId = sc.nextInt();

                        System.out.print("Enter Amount to Deposit: ");
                        double depAmt = sc.nextDouble();

                        service.creditAmount(depId, depAmt);
                        System.out.println("Amount deposited successfully");
                        break;

                    case 4:
                        System.out.print("Enter Account ID: ");
                        int witId = sc.nextInt();

                        System.out.print("Enter Amount to Withdraw: ");
                        double witAmt = sc.nextDouble();

                        service.debitAmount(witId, witAmt);
                        System.out.println("Amount withdrawn successfully");
                        break;

                    case 5:
                        List<Account> list = service.viewAllAccounts();
                        if (list.isEmpty()) {
                            System.out.println("No accounts found");
                        } else {
                            list.forEach(System.out::println);
                        }
                        break;

                    case 6:
                        System.out.println("Thank you!");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice");
                }
            } catch (AccountNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}

