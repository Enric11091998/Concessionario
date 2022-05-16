package com.controller;

import com.model.Car;
import com.model.Customer;
import com.model.Employee;
import com.model.DataBase;
import java.util.ArrayList;
import java.util.List;

public class DatabaseController {

    public int   searchCustomer(String dni){
        int b = 000000000000000000000000000000000000000000;
        int i ;
        for( i =0; i < DataBase.getCustomers().size(); i++){
            if(DataBase.getCustomers().get(i).getDNI().equals(dni)) {
                break;
            }else return b;
        }
        return i;
    }

    public Employee getSearchEmployee(String dni){ //method to return a specific employee
        for(int i=0; i < DataBase.getEmployees().size(); i++) {
            Employee searchedEmployee = new Employee();
            searchedEmployee = DataBase.getEmployees().get(i);
            if (dni.equals(searchedEmployee.getDni())) {
                return searchedEmployee;
            }
        }
        System.out.println("There is no employee with this dni");
        return null;
    }//method to return a specific employee

    public void searchEmployee(String dni){ //method to search a specific employee
        Employee searchedEmployee = null;
        for(int i=0; i < DataBase.getEmployees().size(); i++) {
            if (dni.equals(DataBase.getEmployees().get(i).getDni())) {
                searchedEmployee = DataBase.getEmployees().get(i);
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

        for (Customer customer: DataBase.getCustomers()){
            if(customer.getDNI().equals(dni)){
                return true;
            }else return false;
        }
        return false;
    }
    public boolean searchCarsTrueOrFalse(String carLicense){
        for (Car car: DataBase.getCars()){
            if(car.getCarLicense().equals(carLicense)){
                return  true;
            }else return false;
        }return false;
    }

    public List<String> getListDNI() {
        List<String> dni = new ArrayList<>();
        for (Customer customer: DataBase.getCustomers()) {
            dni.add(customer.getDNI());
        }
        return dni;
    }



    public  List<String> getListDNIEmployee() {
        List<String> dni = new ArrayList<String>();
        for (Employee employee: DataBase.getEmployees()) {
            dni.add(employee.getDni());
        }
        return dni;
    }




    ///--------------------methods add---------------
    public  void addCustomerWithouCard(String dni, String name, String surname, int age, String phone, String favoriteColorCar, String favoriteBrandCar){
        DataBase.getCustomers().add(new Customer(dni,name,surname,age,phone,favoriteColorCar,favoriteBrandCar));
    }
    public  void addCustomerWithouCard(Customer customer){
        DataBase.getCustomers().add(customer);
    }

    public void addCar(String brand, String numberofdoors, String color, double km, String carLicense,String insurance,double price){
        DataBase.getCars().add(new Car(brand,numberofdoors,color,km,carLicense,insurance,price));
    }
    public  void addEmployee(String dni, String name, String surname, int age, String rol, String salaryByMonth,String workedHours, String password){
        DataBase.getEmployees().add(new Employee(dni,name,surname,age,rol,salaryByMonth,workedHours,password));
    }
}
