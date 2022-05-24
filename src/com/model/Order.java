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
