package com.controller;

import com.model.DataBase;

public class CardController {

    public static void getCardNumber(){
        for(int i = 0; i< DataBase.getCustomers().size(); i++){
            for(int x =0;x < DataBase.getCustomers().get(i).getCards().size();x++){
                DataBase.getCards().add(DataBase.getCustomers().get(i).getCards().get(x).getNumberCard());
            }
        }
    }
    public CardController() {
    }
}
