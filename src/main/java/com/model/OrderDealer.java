package com.model;

import javax.persistence.*;

@Entity(name = "orderDealer")
public class OrderDealer {
    @Id
    private String idOrder;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,optional = true)
    @JoinColumn(name = "carLicense_fk")
    private Car car;
    private String numbercard;
    private String date;
    private String dniemployee;
    private String nameCustomer;

    protected OrderDealer(){

    }

    public OrderDealer( String idOrder,String numbercard,String date, String dniemployee,String nameCustomer)
    {
        this.idOrder= idOrder;
        this.car = car;
        this.numbercard = numbercard;
        this.date = date;
        this.dniemployee =dniemployee;
        this.nameCustomer =nameCustomer;
 }

    public OrderDealer( String idOrder,Car car,String numbercard,String date, String dniemployee,String nameCustomer)
    {
        this.idOrder= idOrder;
        this.car = car;
        this.numbercard = numbercard;
        this.date = date;
        this.dniemployee =dniemployee;
        this.nameCustomer =nameCustomer;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getNumbercard() {
        return numbercard;
    }

    public void setNumbercard(String numbercard) {
        this.numbercard = numbercard;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDniEmployee() {
        return dniemployee;
    }

    public void setDniEmployee(String dniemployee) {
        this.dniemployee = dniemployee;
    }

    public String getDniemployee() {
        return dniemployee;
    }

    public void setDniemployee(String dniemployee) {
        this.dniemployee = dniemployee;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    @Override
    public String toString() {
        return "OrderDealer{" +
                "idOrder='" + idOrder + '\'' +
                ", car=" + car +
                ", numbercard='" + numbercard + '\'' +
                ", date='" + date + '\'' +
                ", dniemployee='" + dniemployee + '\'' +
                ", nameCustomer='" + nameCustomer + '\'' +
                '}';
    }
}
