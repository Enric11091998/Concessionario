package com.model;

import java.util.ArrayList;

public class DataBase {

    static ArrayList<Customer> customers= new ArrayList<>();
    static  ArrayList<Car> cars = new ArrayList<>();
    static ArrayList<Employee> employees= new ArrayList<>();
    static ArrayList<Order> orders = new ArrayList<>();
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

    public static ArrayList<Order> getOrders(){ return orders;}

    public static ArrayList<Long> getCards() {
        return cards;
    }
}
