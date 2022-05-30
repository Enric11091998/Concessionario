package com.model;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    static ArrayList<Customer> customers= new ArrayList<>();
    static  ArrayList<Car> cars = new ArrayList<>();
    static ArrayList<Employee> employees= new ArrayList<>();
    static ArrayList<Long> cards = new ArrayList<>();


    public DataBase() {

    }

    public  static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public  static  ArrayList<Car> getCars() {
        return cars;
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }


    public static ArrayList<Long> getCards() {
        return cards;
    }

}

