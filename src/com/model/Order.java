package com.model;

import java.util.ArrayList;
import java.util.Date;

public class Order {

    String date;
    String idOrder;
    String numberCard;
    Car car;
    Employee employee;

    public Order(){
    }
    public Order(String numberCard,Car car,Employee employee,String date, String idOrder){
        this.idOrder = idOrder;
        this.car = car;
        this.numberCard = numberCard;
        this.date = date;
        this.employee = employee;
    }
}
