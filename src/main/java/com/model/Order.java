package com.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name= "order")
public class Order  {

    @Id
    private String idOrder;
    private String date;
    private String numbercard;
    private String id_license;
    private String dniEmployee;
    private String nameCustomer;


    protected Order(){
    }


    public Order(String idOrder, String numbercard, String date, String id_license, String dniEmployee, String dniCustomer){
        this.idOrder = idOrder;
        this.id_license = id_license;
        this.numbercard = numbercard;
       this.date = date;
        this.dniEmployee = dniEmployee;

   }
//    public Order(String numberCard,String nameEmployee,String date, String nameCustomer, String idOrder){
//        this.idOrder = idOrder;
//        this.numberCard = numberCard;
//        this.date = date;
//        this.nameEmployee = nameEmployee;
//        this.nameCustomer = nameCustomer;
//
//    }
    public String getCarLicense() {
        return id_license;
    }

    public void setCarLicense(String carLicense) {
        this.id_license = carLicense;
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
        return numbercard;
    }

    public void setNumberCard(String numberCard) {
        this.numbercard = numberCard;
    }

    public String getNameEmployee() {
        return dniEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.dniEmployee = nameEmployee;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }



    @Override
    public String toString() {
        return "Order{" +
                "date='" + date + '\'' +
                ", idOrder='" + idOrder + '\'' +
                ", number_card='" + numbercard + '\'' +
                ", id_license=" + id_license +
                ", dniEmployee='" + dniEmployee + '\'' +
                ", nameCustomer='" + nameCustomer + '\'' +
                '}';
    }
}
