package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class DataBase {

    static  ArrayList<Customer> customers= new ArrayList<>();
    static  ArrayList<Employee> employees= new ArrayList<>();
    static  ArrayList<Car> cars = new ArrayList<>();



    public  void addCustomerWithouCard(String dni, String name, String surname, int age, String phone, String favoriteColorCar, String favoriteBrandCar){
        customers.add(new Customer(dni,name,surname,age,phone,favoriteColorCar,favoriteBrandCar));
    }

    public void addCustomersCard(String dni, String name, String surname, int age, String phone, String favoriteColorCar, String favoriteBrandCar, Card card){
        customers.add(new Customer(dni,name,surname,age,phone,favoriteColorCar,favoriteBrandCar,card));
    }

    public void addCar(String brand, int numberofdoors, String color, double km, String carLicense,String insurance,double price){
        cars.add(new Car(brand,numberofdoors,color,km,carLicense,insurance,price));
    }

    public  ArrayList<Customer> getCustomers() {
        return customers;
    }

    public List<String> getListDNI() {
        List<String> dni = new ArrayList<String>();
        for (Customer customer: this.getCustomers()) {
            dni.add(customer.getDNI());
        }
        return dni;
    }
    public  ArrayList<Car> getCars() {
        return cars;
    }

    public static Customer getSearchCustomer(String dni){ //method to return a specific employee
        for(int i=0; i < customers.size(); i++) {
            Customer searchedCustomer = new Customer();
            searchedCustomer = customers.get(i);
            if (dni.equals(searchedCustomer.getDNI())) {
                return searchedCustomer;
            }
        }
        System.out.println("There is no customer with this dni");
        return null;
    }//method to return a specific employee

    public static void searchCustomer(String dni){ //method to search a specific employee
        Customer searchedCustomer = null;
        for(int i=0; i < customers.size(); i++) {
            if (dni.equals(customers.get(i).getDNI())) {
                searchedCustomer = customers.get(i);
                break;
            }
        }
        if(searchedCustomer == null){
            System.out.println("Any Customer was found with this dni");
        } else{
            System.out.println("Customer found" + searchedCustomer);
        }
    }
}
