package com.model;

import java.util.ArrayList;

public class Customer {
    public String dni;
    public String name;
    public String surname;
    public int age;
    public String phone;
    public String favoriteColorCar;
    public String favoriteBrandCar;
    public ArrayList<Card> cards = new ArrayList<>();

    // empty constructor
    public Customer() {

    }
    //constructor with card
    public Customer(String dni, String name, String surname, int age, String phone, String favoriteColorCar, String favoriteBrandCar, ArrayList<Card> cards){
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.favoriteColorCar = favoriteColorCar;
        this.favoriteBrandCar = favoriteBrandCar;
        this.cards = cards;
    }

    //constructor without card
    public Customer(String dni, String name, String surname, int age, String phone, String favoriteColorCar, String favoriteBrandCar) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.favoriteColorCar = favoriteColorCar;
        this.favoriteBrandCar = favoriteBrandCar;
    }

    ////--------------------methods get---------------
    public String getDNI(){
        return this.dni;
    }

    public ArrayList<Long> getCardNumber(Customer customer){
        ArrayList<Long> temp = new ArrayList<>();
        for(int i = 0; i< this.cards.size(); i++){
            temp.add(customer.cards.get(i).getNumberCard());
        }
        return temp;
    }

    ////--------------------methods set---------------

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFavoriteColorCar(String favoriteColorCar) {
        this.favoriteColorCar = favoriteColorCar;
    }

    public void setFavoriteBrandCar(String favoriteBrandCar) {
        this.favoriteBrandCar = favoriteBrandCar;
    }

    ////--------------------methods show---------------
    public void showCards(Customer customer){
        for(Card card: customer.cards ){
            System.out.println(card);
        }

    }

    @Override
    public String toString() {
        return "Customer{" +
                "dni='" + this.dni + '\'' +
                ", name='" + this.name + '\'' +
                ", surname='" + this.surname + '\'' +
                ", age=" + this.age +
                ", phone='" + this.phone + '\'' +
                ", favoriteColorCar='" + this.favoriteColorCar + '\'' +
                ", favoriteBrandCar='" + this.favoriteBrandCar + '\'' +
                ", cards=" + this.cards +
                '}';
    }

    public ArrayList<Card> printCard(){
        for(Card card : this.cards){
            System.out.println(card);
        }
        return cards;
    }
    ////--------------------methods add---------------
    public ArrayList<Card> addCard(Card card){
        this.cards.add(card);
        return cards;
    }
    ////--------------------methods add---------------
    public void deleteCards(Customer customer, String b){
        for(int i = 0; i < this.cards.size(); i++){
            String nc = String.valueOf(customer.cards.get(i).getNumberCard());
            if(nc.equals(b)){
                customer.cards.remove(i);
            }
        }
    }

    public boolean existsCards(Customer customer, String b){
        for(int i = 0; i < this.cards.size(); i++){
            String nc = String.valueOf(customer.cards.get(i).getNumberCard());
            if(nc.equals(b)){
                return true;
            }
        }return  false;
    }


}