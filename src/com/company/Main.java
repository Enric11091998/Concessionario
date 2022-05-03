package com.company;

import java.util.Scanner;

public class Main {
    static int choiceSellerMenu;
    static int choiceMainMenu;
    static int choiceCustomerMenu;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        while (true){
            displayMainMenu();
            choiceMainMenu = reader.nextInt();
            if (choiceMainMenu ==1){
                do{
                    displaySellerManagementMenu(reader);
                }while (choiceSellerMenu !=4 );
            }else if (choiceMainMenu ==2){
                System.out.println("Dealer Management Menu");
            }else if (choiceMainMenu ==3)
                break;
            else{
                System.out.println("Please enter valid option");
            }
        }








    }
    public static  void displayMainMenu(){
        System.out.println("1-Seller Management Menu" + "\n" + "2-Dealer Management Menu"+ "\n" + "3-Quit"+ "\n" + "Option?");

    }
    public static  void  displaySellerManagementMenu(Scanner reader){
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




    }
    public static void customersMenu(Scanner reader){
        do {
            System.out.println("1-Register Customer" + "\n" +"2-Search Customer" + "\n" + "3-Remove Customer"+ "\n" + "4-Modify Customer"+ "\n" +"5-Return to SellerManagementMenu ?"+ "\n" +"Option?");

            choiceCustomerMenu = reader.nextInt();
            if(choiceCustomerMenu ==1){
                System.out.println("Register Customer");
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

    }
    //biaggio 04-05
    public static void carMenu(Scanner reader){
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


    }
    public static void makeCarSaleMenu(Scanner reader){
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



    }
    //biaggio 04-05
}