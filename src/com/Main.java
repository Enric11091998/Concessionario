package com;

import java.util.ArrayList;
import java.util.Scanner;

import com.model.Card;
import com.model.Customer;
import com.model.DataBase;
import com.controller.DatabaseController;
import com.view.ViewMenu;

public class Main {//Main
    public static void main(String[] args) {
        fakeusers();
        Scanner reader = new Scanner(System.in);
        ViewMenu.Mainmenu(reader);

    }
    public static void fakeusers(){
        ArrayList<Card> cards1 = new ArrayList<>(),  cards2 = new ArrayList<>(), cards3 = new ArrayList<>();
        cards1.add(new Card(5555748587548754L,"052022","visa","693"));
        cards1.add(new Card(5588888587548754L,"092022","mastercard","451"));
        cards2.add(new Card(4512748587548754L,"052026","mastercard","745"));
        cards2.add(new Card(4566666666648754L,"052027","visa","920"));
        cards3.add(new Card(5563748587548754L,"082024","visa","693"));
        Customer c1 = new Customer("12345678Q","JOSE","PEREZ","23","626745258","BLUE","FORD",cards1);
        Customer c2 = new Customer("12345678S","DANIEL","PAEZ","22","696245258","RED","LEXUS",cards2);
        Customer c3 = new Customer("12345678E","CARLOS","CASTILLO","20","698541258","GREEN","TOYOTA",cards3);
        Customer c4 = new Customer("12345678L","MIGUEL","MENDOZA","26","620963258","YELLOW","FORD");
        Customer c5 = new Customer("12345678V","JOSE","DIAZ","24","695145258","BLUE","BMW");

        Customer[] objects = new Customer[5];
        objects[0] = c1;
        objects[1] = c2;
        objects[2] = c3;
        objects[3] = c4;
        objects[4] = c5;
        for(int i = 0; i < 5; i++){
            DatabaseController.addCustomerWithouCard(objects[i]);
        }

    }

}//Main