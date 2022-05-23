package com.controller;

import com.model.Card;
import com.model.DataBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CardController {
    public CardController() {
    }

    public static void getCardNumber(){
        for(int i = 0; i< DataBase.getCustomers().size(); i++){
            for(int x =0;x < DataBase.getCustomers().get(i).getCards().size();x++){
                DataBase.getCards().add(DataBase.getCustomers().get(i).getCards().get(x).getNumberCard());
            }
        }
        //t.stream().map(p -> p.getNumberCard()).collect(Collectors.toList());
    }
}
