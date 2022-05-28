package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "orderDealer")
public class OrderDealer {
    @Id
    private String idOrder;
    private String carLicense;
    private String numbercard;
    private String date;
    private String dniemployee;
    private String nameCustomer;
    protected OrderDealer(){

    }

    public OrderDealer( String idOrder,String carLicense,String numbercard,String date, String dniemployee,String nameCustomer)
    {
        this.idOrder= idOrder;
        this.carLicense = carLicense;
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

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
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
                ", carLicense='" + carLicense + '\'' +
                ", numbercard='" + numbercard + '\'' +
                ", date='" + date + '\'' +
                ", dniemployee='" + dniemployee + '\'' +
                ", nameCustomer='" + nameCustomer + '\'' +
                '}';
    }
}
