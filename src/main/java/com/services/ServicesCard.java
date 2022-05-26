package com.services;

import com.model.Customer;
import com.model.DataBase;

import java.util.HashMap;
import java.util.Random;

public class ServicesCard {
    static Random random = new Random();
    public static void showCards(Customer customer){
        for(int i = 0; i < customer.getCards().size(); i++ ){
            System.out.println(i +"- "+ customer.getCards().get(i).getNumberCard());
        }
    }
    public static  HashMap<Long,Integer> hashmapCardnumberStatus(Customer customer){
        HashMap<Long,Integer> cardsMap = new HashMap<>();
        for(int i = 0; i < customer.getCards().size(); i++){
            Long key= DataBase.getCards().get(i);
            int value = random.nextInt(2);
            cardsMap.put(key,value);
        }
        return cardsMap;
    }
}
