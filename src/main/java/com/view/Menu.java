package com.view;

import java.util.Scanner;
import com.controller.*;
import com.manager_persistences.PersistenceCEOCR;
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
        CarController cc = new CarController();
        do {
            System.out.println("1-Search Car" + "\n" +"2-Remove Car" + "\n" + "3-Return to SellerManagement Menu" + "\n" +"Option?");

            choice = reader.nextInt();
            if(choice ==1){
                menuSearchCar(reader);
            }
            if(choice ==2){
                cc.removeCar(reader);
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

    public static  void menuSearchCar(Scanner reader){
        CarController cc = new CarController();
        do {
            System.out.println("1-By license" + "\n" +"2-By color and year" + "\n" + "3-By brand and year" + "\n" +"4-By color and brand" + "\n" + "5-Return" + "\n"+"Option?");

            choice = reader.nextInt();
            if(choice ==1){
                cc.searchCarbyLincese(reader);
            }
            if(choice ==2){
                cc.searchCarbyColorandYear(reader);
            }
            if(choice ==3){
                cc.searchCarbyBrandandYear(reader);
            }
            if(choice ==4){
                cc.searchCarbyColorandBrand(reader);
            }
        }while (choice!=5);
    }


}
