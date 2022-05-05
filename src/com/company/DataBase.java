package com.company;

import java.util.ArrayList;
import com.company.Customer;

public class DataBase {


    ArrayList<Customer> customers = new ArrayList();
    ArrayList<Car> cars = new ArrayList<>();

    public void addCustomer(String dni, String name, String surname, int age, String phone, String favoriteColorCar, String favoriteBrandCar){
            customers.add(new Customer(dni,name,surname,age,phone,favoriteColorCar,favoriteBrandCar));
    }
    public ArrayList<Customer> getCustomers() {
        return customers;
    }


}
