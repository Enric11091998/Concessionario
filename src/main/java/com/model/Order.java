package com.model;

import javax.persistence.*;

@Entity(name="order")
public class Order {
    @Id
    String idOrder;
    String date;
    String numberCard;
    @OneToOne
    @JoinColumn(name = "carLicense")
    String carLicense;
    String nameEmployee;
    String nameCustomer;

//    public Car getCar() {
//        return car;

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }
//    }

//    public void setCar(Car car) {
//        this.car = car;
//    }

    protected Order(){
    }
    public Order(String numberCard,String carLicense,String nameEmployee,String date, String idOrder, String nameCustomer){
        this.idOrder = idOrder;
        this.carLicense = carLicense;
        this.numberCard = numberCard;
        this.date = date;
        this.nameEmployee = nameEmployee;
        this.nameCustomer = nameCustomer;
    }
    public String getIdOrder() {
        return idOrder;
    }

    @Override
    public String toString() {
        return "Order{" +
                "date='" + date + '\'' +
                ", idOrder='" + idOrder + '\'' +
                ", numberCard='" + numberCard + '\'' +
                ", carLicense=" + carLicense +
                ", nameEmployee='" + nameEmployee + '\'' +
                ", nameCustomer='" + nameCustomer + '\'' +
                '}';
    }
}
