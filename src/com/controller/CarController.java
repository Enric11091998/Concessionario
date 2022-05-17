package com.controller;

import com.model.Card;
import com.model.Customer;
import com.model.DataBase;
import com.utils.ValidatorData;


import java.util.Scanner;

public class CarController {
    public static void registerCar(Scanner reader){
        ValidatorData validator = new ValidatorData();
        String[] vars0 = new String[6];
        DatabaseController db = new DatabaseController();
        Customer customer ;
        Card card ;
        String listCustomerAndCard = ("car license?,brand?,number of doors?,color?,km?,insurance,price?");

        while(true){
            int count = 0;

                String[] listAll = listCustomerAndCard.split(",");

                for(String test2: listAll){
                    System.out.println(test2);
                    String a = reader.next();
                    vars0[count] = validator.selectValidatorCustomerAndCard(String.valueOf(test2),a);
                    boolean carLicenseExists = db.searchCarsTrueOrFalse(vars0[0]);
                    if(carLicenseExists){
                        System.out.println("this car license already exists");
                        break;
                    }
                    if (count ==7){
                        //Car car = new Car(vars0[0],numberofdoors,vars0[2],km,vars0[4],vars0[5],price);
                        db.addCar(vars0[0],vars0[1],vars0[2],Double.valueOf(vars0[3]),vars0[4],vars0[5],Double.valueOf(vars0[6]));
                        System.out.println(DataBase.getCars().toString());
                    }

                }
            break;
        }
    }
}
