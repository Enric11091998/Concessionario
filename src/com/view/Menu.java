package com.view;

import java.util.Scanner;

import com.controller.*;

public class Menu {
    //Show and call methods

    static  int choice;

    public static void customersMenu(Scanner reader){//Register, Search, delete, modify and modifyCard Customers
        do {
            System.out.println("1-Register Customer" + "\n" +"2-Search Customer" + "\n" + "3-Delete Customer"+ "\n" + "4-Modify Customer"+"\n" +"5-Modifiy Cards Customer"+ "\n" +"6-Return to SellerManagementMenu"+ "\n" +"Option?");
            choice = reader.nextInt();
            if(choice ==1){
                CustomerController.registerCustomer(reader);
            }
            if(choice ==2){
                CustomerController.searchCustomer(reader);
            }
            if(choice ==3){
                CustomerController.deleteCustomer(reader);
            }
            if(choice ==4){
                CustomerController.modifyCustomer(reader);
            }
            if(choice ==5){
                CustomerController.modifyCardCustomer(reader);
            }
        }while (choice!=6);

    }//customerMenu

    public static void carMenu(Scanner reader){//carMenu
        do {
            System.out.println("1-Search Car" + "\n" +"2-Delete Car" + "\n" + "3-Return to SellerManagement Menu" + "\n" +"Option?");

            choice = reader.nextInt();
            if(choice ==1){
                CarController.searchCar(reader);
            }
            if(choice ==2){
                CarController.deleteCar(reader);
            }
        }while (choice!=3);
    }

    public static void makeCarSaleMenu(Scanner reader){//makeCarSaleMenu
        do {
            System.out.println("1-Make Car Sale" + "\n" +"2-Search bought by ?" + "\n" + "3-Return to SellerManagementMenu"+ "\n" + "Option?");

            choice = reader.nextInt();
            if(choice ==1){
                OrderController.makeCarSale();
            }
            if(choice ==2){
                System.out.println("Search bought by ?");
            }
        }while (choice!=3);
    }

    public static int displayDealerManagementMenu(Scanner reader) {//displayDealerManagementMenu
        do {
            System.out.println("1-Register Employee\n2-Search Employee\n3-Delete Employee\n4-Modify Employee\n5-Show all employees\n6-Return \nOption?");
            DatabaseController db = new DatabaseController();
            choice = reader.nextInt();
            if(choice ==1){
                EmployeeController.registerEmployee(reader);
            }
            if(choice ==2){
                db.searchEmployee(reader);
            }
            if(choice ==3){
                EmployeeController.deleteEmployee(reader);
            }
            if(choice ==4){
                EmployeeController.modifyEmployee(reader);
            }
            if(choice ==5){
                EmployeeController.showAllEmployee();
            }
        }while (choice!=6);
        return choice;
    }//displayDealerManagementMenu
}
