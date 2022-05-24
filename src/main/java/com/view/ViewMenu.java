package com.view;
import java.util.Scanner;

public class ViewMenu {

    //show all main menus

    static int choiceDealerMenu,choiceSellerMenu,choiceMainMenu;

    public static  void MainMenu(Scanner reader){
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
                    int x = Menu.displayDealerManagementMenu(reader);
                    if (x == 6) {
                        break;
                    }
                }
            } else if (choiceMainMenu ==3)
                break;
            else{
                System.out.println("Please enter valid option");
            }
        }//Show main menu, call seller and management menu
    }

    public static  void displayMainMenu() {
        System.out.println("1-Seller Management Menu\n2-Dealer Management Menu\n3-Quit\nOption?");
    }

    public static  void  displaySellerManagementMenu(Scanner reader){
        System.out.println("1-Customer Menu" + "\n" +"2-Car Menu" + "\n" + "3-Make car sale Menu"+ "\n" + "4-Return"+ "\n" +"Option?");
        choiceSellerMenu = reader.nextInt();
        switch (choiceSellerMenu){
            case 1: {
                Menu.customersMenu(reader);
                break;
            }
            case 2: {
                Menu.carMenu(reader);
                break;
            }
            case 3: {
                Menu.makeCarSaleMenu(reader);
                break;
            }
            case 4: {
                System.out.println("Return");
                break;

            } default:{
                System.out.println("please enter valid option");
            }
        }
    }//Call customer, car, makeCarSale menus



}
