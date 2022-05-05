package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class DataBase {

    static ArrayList<Customer> customers= new ArrayList<>();
    static ArrayList<Employee> employees= new ArrayList<>();


    ArrayList<Car> cars = new ArrayList<>();

    public  void addCustomerWithouCard(String dni, String name, String surname, int age, String phone, String favoriteColorCar, String favoriteBrandCar){
        customers.add(new Customer(dni,name,surname,age,phone,favoriteColorCar,favoriteBrandCar));
    }
    public void addCustomersCard(String dni, String name, String surname, int age, String phone, String favoriteColorCar, String favoriteBrandCar, Card card){
        customers.add(new Customer(dni,name,surname,age,phone,favoriteColorCar,favoriteBrandCar,card));
    }
    public  ArrayList<Customer> getCustomers() {
        return customers;
    }


    public static Employee getSearchEmployee(String dni){ //method to return a specific employee
        for(int i=0; i < employees.size(); i++) {
            Employee searchedEmployee = new Employee();
            searchedEmployee = employees.get(i);
            if (dni.equals(searchedEmployee.getDni())) {
                return searchedEmployee;
            }
        }
        return null;
    }//method to return a specific employee
    public static void searchEmployee(String dni){ //method to search a specific employee
        Employee searchedEmployee = new Employee();
        for(int i=0; i < employees.size(); i++) {
            if (dni.equals(employees.get(i).getDni())) {
                searchedEmployee = employees.get(i);
                break;
            }
        }
        if(Objects.equals(searchedEmployee, new Employee())){
            System.out.println("Any Employee was found with this dni");
        } else{
            System.out.println("Employee found" + searchedEmployee);
        }
    }
}