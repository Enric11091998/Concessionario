package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Order {
    @Id
    String idOrder;
    String date;
    String numberCard;
    @OneToOne
    @JoinColumn(name = "car_car_license")
    Car car;
    String nameEmployee;
    String nameCustomer;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Order(){
    }
    public Order(String numberCard,Car car,String nameEmployee,String date, String idOrder, String nameCustomer){
        this.idOrder = idOrder;
        this.car = car;
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
                ", car=" + car +
                ", nameEmployee='" + nameEmployee + '\'' +
                ", nameCustomer='" + nameCustomer + '\'' +
                '}';
    }
}
