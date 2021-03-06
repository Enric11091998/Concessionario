package com.controller;

import com.manager_persistences.PersistenceCEOCR;
import com.model.Card;
import com.model.Customer;
import com.services.ValidatorData;
import com.utils.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerController implements CRUD_CE {

    public CustomerController()  {
    }

    public  void register(Scanner reader){
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
                    boolean dniExists = PersistenceCEOCR.exists(vars0[0],1);
                    if(dniExists){
                        System.out.println("this DNI already exists");
                        break;
                    }
                }
                count++;
                if(count==7){
                    if(!Utilities.actionVerification(reader,"Register Card").equals("Y")){
                        customer = new Customer(vars0[0],vars0[1],vars0[2],(vars0[3]),vars0[4],vars0[5],vars0[6]);
                        PersistenceCEOCR.persistence(customer);
                        System.out.println(customer);
                        break;
                    }
                }
                if(count>10){
                    List<Card> cards = new ArrayList<>();
                    card =new Card(Long.parseLong(vars0[7]),vars0[8],vars0[9],vars0[10]);
                    cards.add(card);
                    customer = new Customer(vars0[0],vars0[1],vars0[2],(vars0[3]),vars0[4],vars0[5],vars0[6],cards);
                    PersistenceCEOCR.persistence(customer);
                    System.out.println(customer);
                    break;
                }
            }
            break;
        }
    }

    public  void search(Scanner reader){
        Customer customer;
        String dni = Utilities.askInfo(reader,"Enter a dni");
        customer = PersistenceCEOCR.find(dni,1);
        if(customer == null){
            System.out.println("this customer no exists");
        }
        else System.out.println(customer);
    }

    public  void delete(Scanner reader){
        Customer customer;
        String dni = Utilities.askInfo(reader,"Enter a dni");
        customer = PersistenceCEOCR.find(dni,1);
        if(customer == null){
            System.out.println("this customer no exists");
        }
        else {
            System.out.println(customer);
            PersistenceCEOCR.remove(customer,customer.getDNI(),1);
        }
    }

    public  void modify(Scanner reader){
        ValidatorData validator = new ValidatorData();
        int i;
        Customer customer;
        String dni = Utilities.askInfo(reader,"Enter a dni");
        customer = PersistenceCEOCR.find(dni,1);
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
                PersistenceCEOCR.modifyData(customer);
            }else if(i==2){
                System.out.println("Enter a new Favorite color car");
                String a = reader.next();
                a = validator.checkColorCar(a);
                customer.setFavoriteColorCar(a);
                PersistenceCEOCR.modifyData(customer);
                customer = PersistenceCEOCR.find(customer.getDNI(),1);
                System.out.println(customer);
            }else if(i==3){
                System.out.println("Enter a new Favorite brand car");
                String a = reader.next();
                a = validator.checkCarBrand(a);
                customer.setFavoriteBrandCar(a);
                System.out.println(customer);
                PersistenceCEOCR.modifyData(customer);
            }
        }while(i!=4);
    }

    public  void modifyCard(Scanner reader){
        int i;
        ValidatorData validator = new ValidatorData();
        Customer customer;
        String dni = Utilities.askInfo(reader,"Enter a dni");
        customer = PersistenceCEOCR.find(dni,1);
        if(customer == null){
            System.out.println("this customer no exists");
        }
        else do{
            int count=0;
            System.out.println("1-Show cards\n"+"2-Add card\n"+"3-Delete card\n"+"4-Return");//for
            i = reader.nextInt();
            if(i==1){
                customer = PersistenceCEOCR.find(dni,1);
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
                        boolean cardNumberExists =  PersistenceCEOCR.searchCard(Long.parseLong(vars0[0]));
                        if(cardNumberExists){
                            System.out.println("this numbercard already exists");
                            break;
                        }
                    }
                    if(count == 3 ){
                        Card card = new Card(Long.parseLong(vars0[0]),vars0[1],vars0[2],vars0[3]);
                        customer.getCards().add(card);
                        System.out.println(customer);
                        PersistenceCEOCR.modifyData(customer);
                    }
                    count++;
                }
            }else if(i==3){
                String b = Utilities.askInfo(reader,"Enter a Card number");
                boolean cardNumberExists =  PersistenceCEOCR.searchCard(Long.parseLong(b));
                if(cardNumberExists){
                    customer.deleteCards(customer,b);
                    System.out.println(customer);
                    PersistenceCEOCR.modifyData(customer);
                }
                else System.out.println("this card no exists");
            }
        }while(i!=4);

    }
}
