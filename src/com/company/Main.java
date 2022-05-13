package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {//Main
    static int choiceDealerMenu,choiceSellerMenu,choiceMainMenu,choice,numberofdoors;
    static double km, price;


    public static void main(String[] args) {
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
    //-----------------methods for displaymenu------------//
    public static void displayMainMenu() {
        System.out.println("1-Seller Management Menu\n2-Dealer Management Menu\n3-Quit\nOption?");
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
    }//Call customer, car, makeCarSale menus

    public static void displayDealerManagementMenu(Scanner reader) {//displayDealerManagementMenu
        System.out.println("1-Register Employee\n2-Search Employee\n3-Delete Employee\n4-Modify Employee\n5-Show all employees\n6-Return \nOption?");
        DataBase db = new DataBase();
        choiceDealerMenu = reader.nextInt();
        switch(choiceDealerMenu) {
            case 1:
                System.out.println("Register Employee");
                if(actionVerification(reader,"Register Employee").equals("Y")) {
                    registerEmployee(reader);
                }
                break;
            case 2:
                System.out.println("Search Employee");
                if(actionVerification(reader,"Search Employee").equals("Y")){
                    System.out.println("Enter a dni");
                    String dniToSearch = reader.next();
                    db.searchEmployee(dniToSearch);
                }
                break;
            case 3:
                System.out.println("Delete Employee");
                if(actionVerification(reader,"Delete Employee").equals("Y")) {
                    System.out.println("Enter a dni");
                    String dniToDelete = reader.next();
                    deleteEmployee(reader, dniToDelete);
                }
                break;
            case 4:
                System.out.println("Modify Employee");
                if(actionVerification(reader,"Modify Employee").equals("Y")) {
                    System.out.println("Enter a dni");
                    String dniToModify = reader.next();
                    modifyEmployee(reader, dniToModify);
                }
                break;
            case 5:
                System.out.println("Show all employees");
                System.out.println(DataBase.employees);
                break;
            case 6:
                System.out.println("Return");
                break;
            default:
                System.out.println("Please enter valid option");
        }
    }//displayDealerManagementMenu

    //-----------------methods for menu------------//
    public static void customersMenu(Scanner reader){//Register, Search, Remove and Modify Customers
        do {
            System.out.println("1-Register Customer" + "\n" +"2-Search Customer" + "\n" + "3-Delete Customer"+ "\n" + "4-Modify Customer"+"\n" +"5-Modifiy Cards Customer"+ "\n" +"6-Return to SellerManagementMenu"+ "\n" +"Option?");
            choice = reader.nextInt();
            if(choice ==1){
                registerCustomer(reader);
            }
            if(choice ==2){
                searchCustomer(reader);
            }
            if(choice ==3){
               deleteCustomer(reader);
            }
            if(choice ==4){
                modifyCustomer(reader);
            }
            if(choice ==5){
               modifyCardCustomer(reader);
            }
        }while (choice!=6);

    }//customerMenu

    public static void carMenu(Scanner reader){//carMenu
        do {
            System.out.println("1-Register car" + "\n" +"2-Search Car" + "\n" + "3-Remove Car"+ "\n" + "4-Modify Car"+ "\n" +"5-Return to SellerManagementMenu"+ "\n" +"Option?");

            choice = reader.nextInt();
            if(choice ==1){
                registerCar();
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

    //-----------------methods for customer------------//
    public static void registerCustomer(Scanner reader){
        ValidatorData validator = new ValidatorData();
        String[] vars0 = new String[11];
        DataBase db = new DataBase();
        Customer customer ;
        Card card ;
        String listCustomerAndCard = ("dni?,name?,surname?,age?,phone?,favorite color car?,favorite brand car?,numberCard?,expiration?,type?,securityCode?");

        while(true){
            int count = 0;
            if(actionVerification(reader,"registerCustomer").equals("Y")){
                String[] listAll = listCustomerAndCard.split(",");

                for(String test2: listAll){
                    System.out.println(test2);
                    String a = reader.next();
                    vars0[count] = validator.selectValidatorCustomerAndCard(String.valueOf(test2),a);
                    boolean dniExists = db.searchCustomersTrueOrFalse(vars0[0]);
                    if(dniExists){
                        System.out.println("this DNI already exists");
                        break;
                    }
                    count++;
                    if (count==7){
                        if(!actionVerification(reader,"Register Card").equals("Y")){
                            customer = new Customer(vars0[0],vars0[1],vars0[2],Integer.parseInt(vars0[3]),vars0[4],vars0[5],vars0[6]);
                            db.addCustomerWithouCard(customer);
                            System.out.println(customer);
                            break;
                        }
                    }
                    if (count>10){
                        customer = new Customer(vars0[0],vars0[1],vars0[2],Integer.parseInt(vars0[3]),vars0[4],vars0[5],vars0[6]);
                        card =new Card(Long.parseLong(vars0[7]),vars0[8],vars0[9],vars0[10]);
                        db.addCustomerWithouCard(customer);
                        customer.addCard(card);
                        System.out.println(customer);
                        break;
                    }
                }
            }else break;
        }
    }

    public static void searchCustomer(Scanner reader){
        DataBase db = new DataBase();
        Customer customer;
        System.out.println("Enter a dni");
        String dni = reader.next();
        boolean c = db.searchCustomersTrueOrFalse(dni);
        if(c){
            int w = db.searchCustomer(dni);
            customer= db.getCustomers().get(w);
            System.out.println(customer);
        }
        else System.out.println("this dni no exists");
    }

    public static void deleteCustomer(Scanner reader){
        DataBase db = new DataBase();
        Customer customer;
        System.out.println("Enter a dni");
        String dni = reader.next();
        boolean c = db.searchCustomersTrueOrFalse(dni);
        if(c){
            int w = db.searchCustomer(dni);
            customer= db.getCustomers().get(w);
            System.out.println(" this " + customer + "is deleted");
            db.getCustomers().remove(customer);
        }
        else System.out.println("this dni no exists");
    }

    public static void modifyCustomer(Scanner reader){
        DataBase db = new DataBase();
        ValidatorData validator = new ValidatorData();
        Customer customer ;
        System.out.println("Please enter a DNI");
        String search = reader.next();
        boolean c = db.searchCustomersTrueOrFalse(search);
        int w = db.searchCustomer(search);
        customer= db.getCustomers().get(w);
        int i;
        System.out.println(customer);
        if(!c) {
            System.out.println("This dni no exists");
        }
        else  do{
            System.out.println("1-Phone\n" + "2-Favorite color car\n" + "3-Favorite brand car\n" + "4-Return");//for
            i = reader.nextInt();
            if(i==1){
                System.out.println("Enter a new phone");
                String a = reader.next();
                a = validator.checkPhone(a);
                customer.setPhone(a);
                System.out.println(customer);
            }else if(i==2){
                System.out.println("Enter a new Favorite color car");
                String a = reader.next();
                a = validator.checkColorCar(a);
                customer.setFavoriteColorCar(a);
                System.out.println(customer);
            }else if(i==3){
                System.out.println("Enter a new Favorite brand car");
                String a = reader.next();
                a = validator.checkCarBrand(a);
                customer.setFavoriteBrandCar(a);
                System.out.println(customer);
            }
        }while(i!=4);
    }

    public static void modifyCardCustomer(Scanner reader){
        ValidatorData validator = new ValidatorData();
        DataBase db = new DataBase();
        Customer customer;
        System.out.println("Enter a dni");
        String dni = reader.next();
        boolean c = db.searchCustomersTrueOrFalse(dni);
        int i;
        do{
                if(!c) {
                    break;
                }
                int w = db.searchCustomer(dni);
                customer= db.getCustomers().get(w);
                System.out.println(customer);
                int count=0;
                System.out.println("1-Show cards\n"+"2-Add card\n"+"3-Delete card\n"+"4-Return");//for
                i = reader.nextInt();
                if(i==1){
                    customer.showCard(customer);
                }else if(i==2){
                    String[] vars0 = new String[4];
                    String listAddCard = ("numberCard?,expiration?,type?,securityCode?");
                    String[] listCard  = listAddCard.split(",");
                    for(String test: listCard){
                        System.out.println(test);
                        String a = reader.next();
                        vars0[count] = validator.selectValidatorCustomerAndCard(String.valueOf(test),a);
                        boolean cardNumberExists =  customer.existsCards(customer,vars0[0]);
                        if(cardNumberExists){
                            System.out.println("this numbercard already exists");
                            break;
                        }
                        if(count == 3 ){
                            Card card = new Card(Long.parseLong(vars0[0]),vars0[1],vars0[2],vars0[3]);
                            customer.addCard(card);
                            System.out.println(customer);
                        }
                        count++;
                    }
                }else if(i==3){
                    System.out.println("Enter a numbercard");
                    String b = validator.checkNumberCard(reader.next());
                    customer.deleteCards(customer,b);
                    System.out.println(customer);
                }
            }while(i!=4);

    }
    //---------methods for employee------------
    public static void registerEmployee(Scanner reader){ //method that return a new object Employee with attributes //para hacer
        String[] vars0 = new String[9];
        DataBase db = new DataBase();
        ValidatorData vd = new ValidatorData();
        String listEmployee = ("dni?,name?,surname?,age?,rol?,salary by month?,worked hours?,Enter password:\n1. Password must contain at least one digit [0-9].\n2. Password must contain at least one lowercase Latin character [a-z].\n3. Password must contain at least one uppercase Latin character [A-Z].\n4. Password must contain at least one special character like ! @ # & ( ) – { } : ; ' ? / * ~ $ ^ + = < >\n5. Password must contain a length of at least 6 characters and a maximum of 12 characters.,Confirm password");

        while(true){
            int count = 0;
            if(actionVerification(reader,"registerEmployee").equals("Y")){
                String[] listAll = listEmployee.split(",");

                for(String test2: listAll){
                    System.out.println(test2);
                    String a = reader.next();
                    vars0[count] = vd.selectValidatorEmployee(String.valueOf(test2),a);
                    boolean dniExists = db.getListDNIEmployee().contains(vars0[0]);
                    if(dniExists){
                        System.out.println("this DNI already exists");
                        break;
                    }
                    count++;
                    if (count>8){
                        if(!vars0[8].equals(vars0[7])){
                            System.out.println("Wrong password");
                            break;
                        }
                        Employee employee = new Employee(vars0[0],vars0[1],vars0[2],Integer.parseInt(vars0[3]),vars0[4],vars0[5],vars0[6],vars0[7]);
                        DataBase.employees.add(employee);
                        System.out.println(DataBase.employees.toString());
                        break;
                    }
                }
            }else break;
        }
    }//method that return a new object Employee with attributes

    public static void deleteEmployee(Scanner reader, String dni){ //method to delete an Employee
        Employee employeeToDelete = new Employee ();
        DataBase db = new DataBase();
        employeeToDelete = db.getSearchEmployee(dni);
        System.out.println(employeeToDelete);
        if(actionVerification(reader,"Delete Employee").equals("Y")) {
            DataBase.employees.remove(employeeToDelete);
        } else {
            System.out.println("employee not deleted");
        }
    }//method to delete an Employee

    //-----------------methods for car------------//
    public static  void registerCar(){


        Scanner scanner = new Scanner(System.in);
        String[] vars0 = new String[7];


        DataBase db = new DataBase();
        String[] chaincar = new String[] {"brand?","number of doors?","color?", "km?","car license?", "insurance","price?"};

        for(int i = 0, y = 0; i < chaincar .length ; i++, y++) {
            System.out.println(chaincar[y]);
            if (chaincar[y].equals("number of doors?")){
                vars0[i] = scanner.nextLine();
                numberofdoors = Integer.parseInt(vars0[i]);
            }else if (chaincar[y].equals("km?")){
                vars0[i] = scanner.nextLine();
                km = Double.parseDouble(vars0[i]);
            }else if (chaincar[y].equals("price?")){
                vars0[i] = scanner.nextLine();
                price = Double.parseDouble(vars0[i]);
            }else if(!"number of doors?".equals(chaincar[y]) && !"km?".equals(chaincar[y])  &&  !"price?".equals(chaincar[y]) ){
                vars0[i] = scanner.nextLine();
            }
            if (i>5){
                    //Car car = new Car(vars0[0],numberofdoors,vars0[2],km,vars0[4],vars0[5],price);
                    db.addCar(vars0[0],numberofdoors,vars0[2],km,vars0[4],vars0[5],price);
                    System.out.println(db.getCars().toString());
            }
        }
    }//Regiser car

    public static void modifyEmployee(Scanner reader, String dni){//method to modify an Employee
        Employee employeeToModify = new Employee ();
        DataBase db = new DataBase();
        ValidatorData vd = new ValidatorData();
        employeeToModify = db.getSearchEmployee(dni);
        if(!employeeToModify.equals("null")) {
            System.out.println(employeeToModify);
            System.out.println("If you want to modify the rol enter the new rol if not write null");
            String newRol = reader.next();
            newRol = vd.checkRol(newRol);
            if (!newRol.equals("null")) {
                employeeToModify.setRol(newRol);
            }
            System.out.println("If you want to modify the salary by month enter the new salary if not write null");
            String newSalary = reader.next();
            newSalary = vd.checkSalaryByMonth(newSalary);
            if (!(newSalary.equals("null"))) {
                employeeToModify.setSalaryByMonth(newSalary);
            }
            System.out.println("If you want to modify the worked hours enter the hours worked if not write null");
            String newHoursWorked = reader.next();
            newHoursWorked =vd.checkWorkedHours(newHoursWorked);
            if (!(newHoursWorked.equals("null"))) {
                employeeToModify.setWorkedHours(newHoursWorked);
            }
            System.out.println(employeeToModify);
        }
    }//method to modify an Employee

    public static String actionVerification (Scanner reader, String actionToConfirm){//method to verification if you want to execute another method
        System.out.println("Are you sure you want to " + actionToConfirm + " (Y/N)");
        String verification = reader.next();
        if(verification.equals("Y")){
            return verification;
        } else {
            verification = "N";
            return verification;
        }
    }//met


}//Main