package com.view;

import java.util.Scanner;
import com.controller.*;
import com.services.ServicesEmployee;

public class Menu {

    static  int choice;

    public static void customersMenu(Scanner reader){//Register, Search, delete, modify and modifyCard Customers
        CustomerController cc = new CustomerController();
        do {
            System.out.println("1-Register Customer" + "\n" +"2-Search Customer" + "\n" + "3-Delete Customer"+ "\n" + "4-Modify Customer"+"\n" +"5-Modifiy Cards Customer"+ "\n" +"6-Return to SellerManagementMenu"+ "\n" +"Option?");
            choice = reader.nextInt();
            if(choice ==1){
                cc.register(reader);
            }
            if(choice ==2){
                cc.search(reader);
            }
            if(choice ==3){
                cc.delete(reader);
            }
            if(choice ==4){
                cc.modify(reader);
            }
            if(choice ==5){
                cc.modifyCard(reader);
            }
        }while (choice!=6);

    }

    public static void carMenu(Scanner reader){//carMenu
        do {
            System.out.println("1-Search Car" + "\n" +"2-Delete Car" + "\n" + "3-Return to SellerManagement Menu" + "\n" +"Option?");

            choice = reader.nextInt();
            if(choice ==1){
               // CarController.searchCar(reader);
            }
            if(choice ==2){
               // CarController.deleteCar(reader);
            }
        }while (choice!=3);
    }

    public static void makeCarSaleMenu(Scanner reader){//makeCarSaleMenu
        do {
            System.out.println("1-Make Car Sale" + "\n" +"2-Search an Order" + "\n" + "3-Return to SellerManagementMenu"+ "\n" + "Option?");

            choice = reader.nextInt();
            if(choice ==1){
                OrderController.makeCarSale(reader);
            }
            if(choice ==2){
                //DatabaseController.searchOrders(reader);
            }
        }while (choice!=3);
    }

    public static int displayDealerManagementMenu(Scanner reader) {//displayDealerManagementMenu
        do {
        System.out.println("1-Register Employee\n2-Search Employee\n3-Delete Employee\n4-Modify Employee\n5-Show all employees\n6-Return \nOption?");

        choice = reader.nextInt();
            if(choice ==1){
                EmployeeController.registerEmployee(reader);
            }
            if(choice ==2){
                ServicesEmployee.searchEmployee(reader);
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
