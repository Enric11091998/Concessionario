package com.company;

public class Car {
    String brand;
    int numberofdoors;
    String color;
    double km;
    String carLicense;
    String insurance;
    double price;
    //Hello

    //Constructor empty
    public Car(){}

    public Car(String brand, int numberofdoors, String color, double km, String carLicense, String insurance, double price){
        this.brand = brand;
        this.numberofdoors = numberofdoors;
        this.color = color;
        this.km = km;
        this.carLicense = carLicense;
        this.insurance = insurance;
        this.price = price;

    }
    //method to modified km, carLicense, insurance and price
    public void setKLIP(double km, String carLicense, String insurance, double price){

    }

    public boolean checkExistsCarLicense(String carLicense){
        this.carLicense = carLicense;
        return  false;
    }




}
