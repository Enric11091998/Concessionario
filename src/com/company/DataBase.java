package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class DataBase {

    static ArrayList<Customer> customers= new ArrayList<>();
    static  ArrayList<Car> cars = new ArrayList<>();
    static ArrayList<Employee> employees= new ArrayList<>();

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

    public Employee getSearchEmployee(String dni){ //method to return a specific employee
        for(int i=0; i < employees.size(); i++) {
            Employee searchedEmployee = new Employee();
            searchedEmployee = employees.get(i);
            if (dni.equals(searchedEmployee.getDni())) {
                return searchedEmployee;
            }
        }
        System.out.println("There is no employee with this dni");
        return null;
    }//method to return a specific employee

    public void searchEmployee(String dni){ //method to search a specific employee
        Employee searchedEmployee = null;
        for(int i=0; i < employees.size(); i++) {
            if (dni.equals(employees.get(i).getDni())) {
                searchedEmployee = employees.get(i);
                break;
            }
        }
        if(searchedEmployee == null){
            System.out.println("No Employee was found with this dni");
        } else{
            System.out.println("Employee found " + searchedEmployee);
        }
    }//method to search a specific employee

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

    public List<String> getListDNIEmployee() {
        List<String> dni = new ArrayList<String>();
        for (Employee employee: employees) {
            dni.add(employee.getDni());
        }
        return dni;
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
    public  void addEmployee(String dni, String name, String surname, int age, String rol, String salaryByMonth,String workedHours, String password){
        employees.add(new Employee(dni,name,surname,age,rol,salaryByMonth,workedHours,password));
    }

}