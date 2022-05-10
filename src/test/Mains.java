package test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import com.company.Card;
import com.company.Customer;
import com.company.DataBase;

public class Mains {//Main
    static int choiceDealerMenu,choiceSellerMenu,choiceMainMenu,choice,numberofdoors,age,securityCode;
    static long numberCard;
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
                    if (choiceDealerMenu == 5) {
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
    //-----------------methods for menu------------//
    public static void customersMenu(Scanner reader){//Register, Search, Remove and Modify Customers
        do {
            System.out.println("1-Register Customer" + "\n" +"2-Search Customer" + "\n" + "3-Remove Customer"+ "\n" + "4-Modify Customer"+ "\n" +"5-Return to SellerManagementMenu ?"+ "\n" +"Option?");
            choice = reader.nextInt();
            if(choice ==1){
                registerCustomer(reader);
            }
            if(choice ==2){
                searchCustomer(reader);
            }
            if(choice ==3){
                removeCustomer(reader);
            }
            if(choice ==4){
                modifyCustomer(reader);
            }
        }while (choice!=5);

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
    }

    //-----------------methods for customer------------//
    public static void registerCustomer(Scanner reader){
        Scanner scanner = new Scanner(System.in);
        String[] vars0 = new String[7];
        String[] vars1 = new String[4];
        DataBase db = new DataBase();
        String[] chainWhithoutCard = new String[] {"dni?", "name?", "surname?","age?", "phone?", "favorite color car?", "favorite brand car?"};
        String[] chainCard = new String[] {"numberCard?","expiration?","type?","securityCode?"};

        while(true){
            System.out.println("Are you sure to modify the customer (Y or N)?");
            String inputYorN = reader.next();
            if(inputYorN.equals("Y")){
                for(int i = 0, y = 0; i < chainWhithoutCard.length ; i++, y++) {
                    System.out.println(chainWhithoutCard[y]);
                    vars0[i] = scanner.nextLine();
                    boolean dniExists = db.getListDNI().contains(vars0[i]);
                    if(dniExists){
                        System.out.println("this DNI already exists");
                        break;
                    }
                    if(i==6){
                        System.out.println("Card(Y or N)?");
                        String input = scanner.nextLine();
                        if(input.equals("Y")){
                            for(int x= 0, z= 0; x < chainCard.length;  x++, z++){
                                System.out.println(chainCard[z]);
                                vars1[x] = scanner.nextLine();
                                if(x ==3){
                                Card card =new Card(Long.parseLong(vars1[0]),vars1[1],vars1[2],Integer.parseInt(vars1[3]));
                                    db.addCustomersCard(vars0[0],vars0[1],vars0[2],Integer.parseInt(vars0[3]),vars0[4],vars0[5],vars0[6],card);
                                    System.out.println(db.getCustomers().toString());
                                    break;
                                }
                            }
                        }
                        if(input.equals("N")){
                            db.addCustomerWithouCard(vars0[0],vars0[1],vars0[2],Integer.parseInt(vars0[3]),vars0[4],vars0[5],vars0[6]);
                            System.out.println(db.getCustomers().toString());
                            break;
                        }
                    }
                }
            }else break;
        }
    }

    public static void searchCustomer(Scanner reader){
        DataBase db = new DataBase();
        System.out.println("Please enter a DNI");
        String search = reader.next();
        for(int i = 0 ; i < db.getListDNI().size(); i++){
            if(db.getListDNI().get(i) == search){
                for(Customer customer : db.getCustomers()) {
                    if(customer.getDNI().equals(search)){
                        System.out.println(customer);
                        break;
                    }
                }
            }else  {
                System.out.println("Not exists this dni");
                break;
            }
        }
    }

    public static void removeCustomer(Scanner reader){
        DataBase db = new DataBase();
        while(true){
            System.out.println("Are you sure to remove the customer (Y or N)?");
            String inputYorN = reader.next();
            if(inputYorN.equals("Y")){
                System.out.println("Please enter a DNI");
                String search = reader.next();
                for(Customer customer : db.getCustomers()) {
                    if (customer.getDNI().equals(search)){
                        db.getCustomers().remove((customer));
                        break;
                    }
                }
            }else break;
        }
    }

    public static void modifyCustomer(Scanner reader){
        Customer customer = new Customer();
        DataBase db = new DataBase();
        boolean find ;
        String[] vars0 = new String[3];
        String[] vars1 = new String[4];
        String[] chainModifyCustomer = new String[] {"phone?","colorFavoriteCar?","brandCarFavorite?"};
        String[] chainModifyCardOfCustomer = new String[] {"number Card?","expiration?","type?","securityCode?"};
        while(true){
            System.out.println("Are you sure to register the customer (Y or N)?");
            String inputYorN = reader.next();
            if(inputYorN.equals("Y")){
                System.out.println("Please enter a DNI");
                String search = reader.next();
                for(int i = 0; i < db.getCustomers().size(); i++) {
                    find = db.getCustomers().get(i).getDNI().equals(search);
                    if(find){
                        int a = i;
                        System.out.println(db.getCustomers().get(a).toString());
                        for(int w = 0, y = 0; w < chainModifyCustomer.length ; w++, y++){
                            System.out.println(chainModifyCustomer[y]);
                            vars0[w] = reader.next();
                            if(w>1){
                                db.getCustomers().get(a).setPhoneFavoriteColorBrand(vars0[0],vars0[1],vars0[2]);
                                System.out.println(db.getCustomers().get(a).toString());
                                System.out.println("Card(Y or N)?");
                                String input = reader.next();
                                if(input.equals("Y")){
                                    for(int t= 0, p= 0; t < chainModifyCardOfCustomer.length;  t++, p++){
                                        System.out.println(chainModifyCardOfCustomer[p]);
                                        if(chainModifyCardOfCustomer[p].equals("numberCard?")){
                                            vars1[t] = reader.next();
                                            numberCard = Long.parseLong(vars1[t]);
                                        }
                                        else if (chainModifyCardOfCustomer[p].equals("securityCode?")){
                                            vars1[t] = reader.next();
                                            securityCode = Integer.parseInt(vars1[t]);
                                        }
                                        else if (!"numberCard?".equals(chainModifyCardOfCustomer[p]) && !"securityCode?".equals(chainModifyCardOfCustomer[p])){
                                            vars1[t] = reader.next();
                                        }
                                        if (t>2){
                                            Card card = new Card(numberCard,vars1[1],vars1[2],securityCode);
                                            db.getCustomers().get(a).setCard(card);
                                            System.out.println(db.getCustomers().get(a).toString());
                                            break;
                                        }
                                    }
                                }
                                else break;
                            }
                        }
                    }
                }
            }else break;
        }



    }

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


}//Main