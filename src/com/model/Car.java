package com.model;

public class Car {
    String brand;
    String numberofdoors;
    @Override
    public String toString() {
        return "brand='" + brand + '\'' +
                ", numberofdoors='" + numberofdoors + '\'' +
                ", color='" + color + '\'' +
                ", km=" + km +
                ", carLicense='" + carLicense + '\'' +
                ", insurance='" + insurance + '\'' +
                ", price=" + price +
                ", year='" + year + '\'' ;
    }

    String color;
    double km;
    String carLicense;
    String insurance;
    double price;
    String year;
    //Hello
    //hello


    //Constructor empty
    public Car(){}

    public Car(String brand, String numberofdoors, String color, double km, String carLicense, String insurance, double price,String year){
        this.brand = brand;
        this.numberofdoors = numberofdoors;
        this.color = color;
        this.km = km;
        this.carLicense = carLicense;
        this.insurance = insurance;
        this.price = price;
        this.year = year;

    }
    //method to modified km, carLicense, insurance and price
    public void setKLIP(double km, String carLicense, String insurance, double price){

    }

    public boolean checkExistsCarLicense(String carLicense){
        this.carLicense = carLicense;
        return  false;
    }

    public String getBrand() {
        return brand;
    }

    public String getYear() {
        return this.year;
    }
    public String getColor() {
        return color;
    }
    public String getCarLicense() {
        return carLicense;
    }

}