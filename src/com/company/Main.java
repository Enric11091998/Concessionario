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
            }else if (choiceMainMenu ==3)break;
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
                System.out.println("Car");
                break;

            }
            case 3: {
                System.out.println("Make car sale");
                break;

            }
            case 4: {
                System.out.println("Return");
                break;

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
        }while (choiceCustomerMenu!=5);

    }
}