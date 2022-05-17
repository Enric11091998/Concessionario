package com.controller;

import com.model.Card;
import com.model.Customer;
import com.model.DataBase;
import com.utils.ValidatorData;
import com.utils.Utilitys;

import java.util.Scanner;

public class CustomerController {
    public static void registerCustomer(Scanner reader){
        ValidatorData validator = new ValidatorData();
        String[] vars0 = new String[11];
        DatabaseController db = new DatabaseController();
        Customer customer ;
        Card card ;
        String listCustomerAndCard = ("dni?,name?,surname?,age?,phone?,favorite color car?,favorite brand car?,numberCard?,expiration?,type?,securityCode?");
        while(true){
            int count = 0;
            String[] listAll = listCustomerAndCard.split(",");
            for(String test2: listAll){
                System.out.println(test2);
                String a = reader.next();
                vars0[count] = validator.selectValidatorCustomerAndCard(String.valueOf(test2),a);
                boolean dniExists = DatabaseController.searchCustomersTrueOrFalse(vars0[0]);
                if(dniExists){
                    System.out.println("this DNI already exists");
                    break;
                }
                count++;
                if(count==7){
                    if(!Utilitys.actionVerification(reader,"Register Card").equals("Y")){
                        customer = new Customer(vars0[0],vars0[1],vars0[2],Integer.parseInt(vars0[3]),vars0[4],vars0[5],vars0[6]);
                        db.addCustomerWithouCard(customer);
                        System.out.println(customer);
                        break;
                    }
                }
                if(count>10){
                    customer = new Customer(vars0[0],vars0[1],vars0[2],Integer.parseInt(vars0[3]),vars0[4],vars0[5],vars0[6]);
                    card =new Card(Long.parseLong(vars0[7]),vars0[8],vars0[9],vars0[10]);
                    db.addCustomerWithouCard(customer);
                    customer.addCard(card);
                    System.out.println(customer);
                    break;
                }
            }
        break;
        }
    }

    public static void searchCustomer(Scanner reader){
        DataBase db = new DataBase();
        Customer customer;
        System.out.println("Enter a dni");
        String dni = reader.next();
        boolean c = DatabaseController.searchCustomersTrueOrFalse(dni);
        if(c){
            int w = DatabaseController.searchCustomer(dni);
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
        boolean c = DatabaseController.searchCustomersTrueOrFalse(dni);
        if(c){
            int w = DatabaseController.searchCustomer(dni);
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
        boolean c = DatabaseController.searchCustomersTrueOrFalse(search);
        int w = DatabaseController.searchCustomer(search);
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
        boolean c = DatabaseController.searchCustomersTrueOrFalse(dni);
        int i;
        do{
            if(!c) {
                break;
            }
            int w = DatabaseController.searchCustomer(dni);
            customer= db.getCustomers().get(w);
            System.out.println(customer);
            int count=0;
            System.out.println("1-Show cards\n"+"2-Add card\n"+"3-Delete card\n"+"4-Return");//for
            i = reader.nextInt();
            if(i==1){
                customer.showCards(customer);
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
}
