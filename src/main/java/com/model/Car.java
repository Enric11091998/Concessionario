package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="car")
public class Car {
    @Id
    String carLicense;
    String brand;
    String numberOfDoors;
    String color;
    double km;
    String insurance;
    double price;
    String year;

    //Constructor empty
    public Car(){}

    public Car(String brand, String numberofdoors, String color, double km, String carLicense, String insurance, double price,String year){
        this.brand = brand;
        this.numberOfDoors = numberofdoors;
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

    public String getNumberOfDoors() {
        return numberOfDoors;
    }

    public double getKm() {
        return km;
    }

    public String getInsurance() {
        return insurance;
    }

    public double getPrice() {
        return price;
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
    @Override
    public String toString() {
        return "brand='" + brand + '\'' +
                ", numberOfDoors='" + numberOfDoors + '\'' +
                ", color='" + color + '\'' +
                ", km=" + km +
                ", carLicense='" + carLicense + '\'' +
                ", insurance='" + insurance + '\'' +
                ", price=" + price +
                ", year='" + year + '\'' ;
    }

}