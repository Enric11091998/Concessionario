package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class DataBase {

    static ArrayList<Customer> customers= new ArrayList<>();
    static  ArrayList<Car> cars = new ArrayList<>();

    public DataBase() {

    }

    ////--------------------methods search--------------

    public int searchCustomer(String dni){
        int b = 000000000000000000000000000000000000000000;
        int i ;
        for( i =0; i < customers.size(); i++){
            if(customers.get(i).getDNI().equals(dni)) {
                break;
            }else return b;
        }
        return i;
    }

    public boolean searchCustomersTrueOrFalse(String dni){

        for (Customer customer: customers){
            if(customer.getDNI().equals(dni)){
                break;
            }else return false;
        }return true;
    }

    public List<String> getListDNI() {
        List<String> dni = new ArrayList<>();
        for (Customer customer: this.getCustomers()) {
            dni.add(customer.getDNI());
        }
        return dni;
    }

    public  ArrayList<Customer> getCustomers() {
        return customers;
    }

    public  ArrayList<Car> getCars() {
        return cars;
    }

    ///--------------------methods add---------------
    public  void addCustomerWithouCard(String dni, String name, String surname, int age, String phone, String favoriteColorCar, String favoriteBrandCar){
        customers.add(new Customer(dni,name,surname,age,phone,favoriteColorCar,favoriteBrandCar));
    }
    public  void addCustomerWithouCard(Customer customer){
        customers.add(customer);
    }

    public void addCar(String brand, int numberofdoors, String color, double km, String carLicense,String insurance,double price){
        cars.add(new Car(brand,numberofdoors,color,km,carLicense,insurance,price));
    }

}
