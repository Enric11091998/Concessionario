package com.model;

import javax.persistence.*;

@Entity(name="order")
public class Order {
    @Id
    private String idOrder;
    private String date;
    private String numberCard;
    @OneToOne(targetEntity = Car.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "carLicense")
    private String carLicense;
    private String nameEmployee;
    private String nameCustomer;

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

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
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
