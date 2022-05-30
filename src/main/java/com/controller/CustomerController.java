package com.controller;

import com.manager_persistences.PersistenceCustomer;
import com.model.Card;
import com.model.Customer;
import com.model.Employee;
import com.services.ValidatorData;
import com.utils.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerController {

    public CustomerController() {
    }

    public static void registerCustomer(Scanner reader){
        ValidatorData validator = new ValidatorData();
        String[] vars0 = new String[11];
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
                if(count==0){
                    boolean dniExists = PersistenceCustomer.existsCustomer(vars0[0]);
                    if(dniExists){
                        System.out.println("this DNI already exists");
                        break;
                    }
                }
                count++;
                if(count==7){
                    if(!Utilities.actionVerification(reader,"Register Card").equals("Y")){
                        customer = new Customer(vars0[0],vars0[1],vars0[2],(vars0[3]),vars0[4],vars0[5],vars0[6]);
                        PersistenceCustomer.customerPersistence(customer);
                        System.out.println(customer);
                        break;
                    }
                }
                if(count>10){
                    List<Card> cards = new ArrayList<>();
                    card =new Card(Long.parseLong(vars0[7]),vars0[8],vars0[9],vars0[10]);
                    cards.add(card);
                    customer = new Customer(vars0[0],vars0[1],vars0[2],(vars0[3]),vars0[4],vars0[5],vars0[6],cards);
                    PersistenceCustomer.customerPersistence(customer);
                    System.out.println(customer);
                    break;
                }
            }
            break;
        }
    }

    public static void searchCustomer(Scanner reader){
        Customer customer;
        String dni = Utilities.askInfo(reader,"Enter a dni");
        customer = PersistenceCustomer.findCustomer(dni);
        if(customer == null){
            System.out.println("this customer no exists");
        }
        else System.out.println(customer);
    }

    public static void deleteCustomer(Scanner reader){
        Customer customer;
        String dni = Utilities.askInfo(reader,"Enter a dni");
        customer = PersistenceCustomer.findCustomer(dni);
        if(customer == null){
            System.out.println("this customer no exists");
        }
        else {
            System.out.println(customer);
            PersistenceCustomer.removeCustomer(customer);
        }
    }

    public static void modifyCustomer(Scanner reader){
        ValidatorData validator = new ValidatorData();
        int i;
        Customer customer;
        String dni = Utilities.askInfo(reader,"Enter a dni");
        customer = PersistenceCustomer.findCustomer(dni);
        if(customer == null){
            System.out.println("this customer no exists");
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
                PersistenceCustomer.modifyDataCustomer(customer);
            }else if(i==2){
                System.out.println("Enter a new Favorite color car");
                String a = reader.next();
                a = validator.checkColorCar(a);
                customer.setFavoriteColorCar(a);
                PersistenceCustomer.modifyDataCustomer(customer);
                customer = PersistenceCustomer.findCustomer(customer.getDNI());
                System.out.println(customer);
            }else if(i==3){
                System.out.println("Enter a new Favorite brand car");
                String a = reader.next();
                a = validator.checkCarBrand(a);
                customer.setFavoriteBrandCar(a);
                System.out.println(customer);
                PersistenceCustomer.modifyDataCustomer(customer);
            }
        }while(i!=4);
    }

    public static void modifyCardCustomer(Scanner reader){
        int i;
        ValidatorData validator = new ValidatorData();
        Customer customer;
        String dni = Utilities.askInfo(reader,"Enter a dni");
        customer = PersistenceCustomer.findCustomer(dni);
        if(customer == null){
            System.out.println("this customer no exists");
        }
        else do{
            int count=0;
            System.out.println("1-Show cards\n"+"2-Add card\n"+"3-Delete card\n"+"4-Return");//for
            i = reader.nextInt();
            if(i==1){
                customer = PersistenceCustomer.findCustomer(dni);
                if(customer == null){
                    System.out.println("this custome no exists");
                }
                else {
                    System.out.println(customer.getCards().toString());
                }
            }else if(i==2){
                String[] vars0 = new String[4];
                String listAddCard = ("numberCard?,expiration?,type?,securityCode?");
                String[] listCard  = listAddCard.split(",");
                for(String test: listCard){
                    System.out.println(test);
                    String a = reader.next();
                    vars0[count] = validator.selectValidatorCustomerAndCard(String.valueOf(test),a);
                    if(count==0){
                        boolean cardNumberExists =  PersistenceCustomer.searchCard(Long.parseLong(vars0[0]));
                        if(cardNumberExists){
                            System.out.println("this numbercard already exists");
                            break;
                        }
                    }
                    if(count == 3 ){
                        Card card = new Card(Long.parseLong(vars0[0]),vars0[1],vars0[2],vars0[3]);
                        customer.getCards().add(card);
                        System.out.println(customer);
                        PersistenceCustomer.modifyDataCustomer(customer);
                    }
                    count++;
                }
            }else if(i==3){
                String b = Utilities.askInfo(reader,"Enter a Card number");
                boolean cardNumberExists =  PersistenceCustomer.searchCard(Long.parseLong(b));
                if(cardNumberExists){
                    customer.deleteCards(customer,b);
                    System.out.println(customer);
                    PersistenceCustomer.modifyDataCustomer(customer);
                }
                else System.out.println("this card no exists");
            }
        }while(i!=4);

    }
}
