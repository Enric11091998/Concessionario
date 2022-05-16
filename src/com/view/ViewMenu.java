package com.view;

import com.controller.DatabaseController;
import com.model.DataBase;
import com.controller.EmployeeController;
import java.util.Scanner;
import com.utils.Utilitys;


public class ViewMenu {
    static int choiceDealerMenu,choiceSellerMenu,choiceMainMenu;

    public static  void Mainmenu(Scanner reader){
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
                    if (choiceDealerMenu == 6) {
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
                System.out.println("Customer");
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

    public static void displayDealerManagementMenu(Scanner reader) {//displayDealerManagementMenu
        System.out.println("1-Register Employee\n2-Search Employee\n3-Delete Employee\n4-Modify Employee\n5-Show all employees\n6-Return \nOption?");
        DatabaseController db = new DatabaseController();
        choiceDealerMenu = reader.nextInt();
        switch(choiceDealerMenu) {
            case 1:
                System.out.println("Register Employee");
                if(Utilitys.actionVerification(reader,"Register Employee").equals("Y")) {
                    EmployeeController.registerEmployee(reader);
                }
                break;
            case 2:
                System.out.println("Search Employee");
                if(Utilitys.actionVerification(reader,"Search Employee").equals("Y")){
                    System.out.println("Enter a dni");
                    String dniToSearch = reader.next();
                    db.searchEmployee(dniToSearch);
                }
                break;
            case 3:
                System.out.println("Delete Employee");
                if(Utilitys.actionVerification(reader,"Delete Employee").equals("Y")) {
                    System.out.println("Enter a dni");
                    String dniToDelete = reader.next();
                    EmployeeController.deleteEmployee(reader, dniToDelete);
                }
                break;
            case 4:
                System.out.println("Modify Employee");
                if(Utilitys.actionVerification(reader,"Modify Employee").equals("Y")) {
                    System.out.println("Enter a dni");
                    String dniToModify = reader.next();
                    EmployeeController.modifyEmployee(reader, dniToModify);
                }
                break;
            case 5:
                System.out.println("Show all employees");
                System.out.println(DataBase.getEmployees());
                break;
            case 6:
                System.out.println("Return");
                break;
            default:
                System.out.println("Please enter valid option");
        }
    }//displayDealerManagementMenu

}
