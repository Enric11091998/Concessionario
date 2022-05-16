package com.view;

import java.util.Scanner;
import com.controller.CustomerController;
import com.controller.CarController;

public class Menu {
    static  int choice;
    public static void customersMenu(Scanner reader){//Register, Search, Remove and Modify Customers
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
            System.out.println("1-Register car" + "\n" +"2-Search Car" + "\n" + "3-Remove Car"+ "\n" + "4-Modify Car"+ "\n" +"5-Return to SellerManagementMenu"+ "\n" +"Option?");

            choice = reader.nextInt();
            if(choice ==1){
                CarController.registerCar(reader);
            }
            if(choice ==2){
                System.out.println("Search Car");
            }
            if(choice ==3){
                System.out.println("Remove Car");
            }
            if(choice ==4){
                System.out.println("Modify Car");
            }
        }while (choice!=5);
    }

    public static void makeCarSaleMenu(Scanner reader){//makeCarSaleMenu
        do {
            System.out.println("1-Make Car Sale" + "\n" +"2-Search bought by ?" + "\n" + "3-Return to SellerManagementMenu"+ "\n" + "Option?");

            choice = reader.nextInt();
            if(choice ==1){
                System.out.println("Make Car Sale");
            }
            if(choice ==2){
                System.out.println("Search bought by ?");
            }
        }while (choice!=3);
    }
}
