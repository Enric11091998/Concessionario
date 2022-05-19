package com.model;

public class Order {
    String date;
    String idOrder;
    String numberCard;
    Car car;
    String nameEmployee;
    String nameCustomer;

    public Order(){
    }
    public Order(String numberCard,Car car,String employee,String date, String idOrder, String nameCustomer){
        this.idOrder = idOrder;
        this.car = car;
        this.numberCard = numberCard;
        this.date = date;
        this.nameEmployee = employee;
        this.nameCustomer = nameCustomer;
    }
}
