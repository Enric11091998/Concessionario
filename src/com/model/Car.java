package com.model;

public class Car {
    String brand;
    String numberofdoors;
    String color;
    double km;
    String carLicense;
    String insurance;
    double price;
    //Hello
    //hello

    public String getCarLicense() {
        return carLicense;
    }

    //Constructor empty
    public Car(){}

    public Car(String brand, String numberofdoors, String color, double km, String carLicense, String insurance, double price){
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

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", numberofdoors=" + numberofdoors +
                ", color='" + color + '\'' +
                ", km=" + km +
                ", carLicense='" + carLicense + '\'' +
                ", insurance='" + insurance + '\'' +
                ", price=" + price +
                '}';
    }
}