package com.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="car")
public class Car  {
    @Id
    @OneToOne(targetEntity = Order.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "idOrder")
    private String carLicense;
    private  String brand;
    private String numberOfDoors;
    private String color;
    private double km;
    private String insurance;
    private double price;
    private String year;

    //Constructor empty
    protected Car(){}

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
    public void setKLIP(double km, String carLicense, String insurance, double price){

    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setNumberOfDoors(String numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setYear(String year) {
        this.year = year;
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