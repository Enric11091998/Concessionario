package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import com.company.DataBase;

public class Main {//Main
    static int choiceDealerMenu;
    static int choiceSellerMenu;
    static int choiceMainMenu;
    static int choiceCustomerMenu;


    public static void main(String[] args) { //void main

        Scanner reader = new Scanner(System.in);

        while(true) {
            displayMainMenu();
            choiceMainMenu = reader.nextInt();
            if (choiceMainMenu == 1) {
                while(true) {
                    displaySellerManagementMenu(reader);
                    if (choiceSellerMenu == 4) {
                        break;
                    }
                }
            } else if (choiceMainMenu == 2) {
                while(true) {
                    displayDealerManagementMenu(reader);
                    if (choiceDealerMenu == 5) {
                        break;
                    }
                }
            } else if (choiceMainMenu ==3)
                break;
            else{
                System.out.println("Please enter valid option");
            }
        }

    }//void main
    public static void displayMainMenu() {//Mainmenu
        System.out.println("1-Seller Management Menu\n2-Dealer Management Menu\n3-Quit\nOption?");
    }//Mainmenu
    public static  void  displaySellerManagementMenu(Scanner reader){//SellerManagementMenu
        System.out.println("1-Customer Menu" + "\n" +"2-Car Menu" + "\n" + "3-Make car sale Menu"+ "\n" + "4-Return"+ "\n" +"Option?");
        choiceSellerMenu = reader.nextInt();
        switch (choiceSellerMenu){
            case 1: {
                System.out.println("Customer");
                customersMenu(reader);
                break;
            }
            case 2: {
                carMenu(reader);
                break;
            }
            case 3: {
                makeCarSaleMenu(reader);
                break;
            }
            case 4: {
                System.out.println("Return");
                break;

            } default:{
                System.out.println("please enter valid option");
            }
        }
    }//SellerManagementMenu
    public static void customersMenu(Scanner reader){//customerMenu
        do {
            System.out.println("1-Register Customer" + "\n" +"2-Search Customer" + "\n" + "3-Remove Customer"+ "\n" + "4-Modify Customer"+ "\n" +"5-Return to SellerManagementMenu ?"+ "\n" +"Option?");

            choiceCustomerMenu = reader.nextInt();
            if(choiceCustomerMenu ==1){

                DataBase db = new DataBase();
                Customer customer = new Customer();
                String dni, name, surname, phone,favoriteColorCar,favoriteBrandCar,YorN,YorNCard;
                int age;
                Scanner scanner = new Scanner(System.in);



                System.out.println("Are you sure to register customer (Y or N)?");
                YorN = scanner.nextLine();
                if (YorN.equals("Y")){
                    System.out.println("dni?");
                     dni = scanner.nextLine();
                    System.out.println("name?");
                     name = scanner.nextLine();
                    System.out.println("surname?");
                     surname = scanner.nextLine();
                    System.out.println("age?");
                     age = Integer.valueOf(scanner.nextLine());
                    System.out.println("phone?");
                     phone = scanner.nextLine();
                    System.out.println("favorite color car?");
                     favoriteColorCar = scanner.nextLine();
                    System.out.println("favorite brand car?");
                     favoriteBrandCar = scanner.nextLine();
                    db.addCustomer(dni,name,surname,age,phone,favoriteColorCar,favoriteBrandCar);
                    System.out.println(db.customers.toString());


                    //-------------------------
                    System.out.println("Card(Y or N)?");
                     YorNCard = scanner.nextLine();
                    if (YorNCard.equals("Y")){
                        System.out.println("Number Card?");
                        long cardNumber = Long.valueOf(scanner.nextLine());
                        System.out.println("Expiration?");
                        String expiration = scanner.nextLine();
                        System.out.println("Type?");
                        String type = scanner.nextLine();
                        System.out.println("Security code?");
                        String securityCode = scanner.nextLine();
                    }
                    else System.out.println("Customer Registered Successfully");
                }


            }
            if(choiceCustomerMenu ==2){
                System.out.println("Search Customer");
            }
            if(choiceCustomerMenu ==3){
                System.out.println("Remove Customer");
            }
            if(choiceCustomerMenu ==4){
                System.out.println("Modify Customer");
            }
        }while (choiceCustomerMenu!=5);

    }//customerMenu
    public static void carMenu(Scanner reader){//carMenu
        do {
            System.out.println("1-Register car" + "\n" +"2-Search Car" + "\n" + "3-Remove Car"+ "\n" + "4-Modify Car"+ "\n" +"5-Return to SellerManagementMenu"+ "\n" +"Option?");

            choiceCustomerMenu = reader.nextInt();
            if(choiceCustomerMenu ==1){
                System.out.println("Register Car");
            }
            if(choiceCustomerMenu ==2){
                System.out.println("Search Car");
            }
            if(choiceCustomerMenu ==3){
                System.out.println("Remove Car");
            }
            if(choiceCustomerMenu ==4){
                System.out.println("Modify Car");
            }
        }while (choiceCustomerMenu!=5);
    }//carMenu
    public static void makeCarSaleMenu(Scanner reader){//makeCarSaleMenu
        do {
            System.out.println("1-Make Car Sale" + "\n" +"2-Search bought by ?" + "\n" + "3-Return to SellerManagementMenu"+ "\n" + "Option?");

            choiceCustomerMenu = reader.nextInt();
            if(choiceCustomerMenu ==1){
                System.out.println("Make Car Sale");
            }
            if(choiceCustomerMenu ==2){
                System.out.println("Search bought by ?");
            }
        }while (choiceCustomerMenu!=3);
    }//makeCarSaleMenu
    public static void displayDealerManagementMenu(Scanner reader) {//displayDealerManagementMenu
        System.out.println("1-Register Employee\n2-Search Employee\n3-Delete Employee\n4-Modify Employee\n5-Return \nOption?");
        choiceDealerMenu = reader.nextInt();
        switch(choiceDealerMenu) {
            case 1:
                System.out.println("Register Employee");
                break;
            case 2:
                System.out.println("Search Employee");
                break;
            case 3:
                System.out.println("Delete Employee");
                break;
            case 4:
                System.out.println("Modify Employee");
                break;
            case 5:
                System.out.println("Return");
                break;
            default:
                System.out.println("Please enter valid option");
        }
    }//displayDealerManagementMenu

}//Main
