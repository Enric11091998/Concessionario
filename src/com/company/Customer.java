package com.company;

public class Customer {
    public String dni;
    public String name;
    public String surname;
    public int age;
    public String phone;
    public String favoriteColorCar;
    public String favoriteBrandCar;
    public Card card;

    // empty constructor
    public Customer() {

    }

    //constructor with card
    public Customer (String dni, String name, String surname, int age, String phone, String favoriteColorCar, String favoriteBrandCar, Card card){
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.favoriteColorCar = favoriteColorCar;
        this.favoriteBrandCar = favoriteBrandCar;
        this.card = card;
    }
}