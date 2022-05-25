package com.controller;

import com.manager_persistences.PersistenceEmployee;
import com.model.*;
import com.utils.Utilities;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabaseController {

    //--------------------Customer-------------//
    public static int  searchCustomer(String dni){
        int b = 000000000000000000000000000000000000000000;
        int i ;
        for( i =0; i < DataBase.getCustomers().size(); i++){
            if(DataBase.getCustomers().get(i).getDNI().equals(dni)) {
                return i;
            }
        }
        return b;
    }

    public static boolean searchCustomersTrueOrFalse(String dni){
        for (Customer customer: DataBase.getCustomers()){
            if(customer.getDNI().equals(dni)){
                return true;
            }
        }
        return false;
    }


    public static void addCustomerWithouCard(Customer customer){
        DataBase.getCustomers().add(customer);
    }

    public static void addCar(String brand, String numberofdoors, String color, double km, String carLicense,String insurance,double price, String year){
        DataBase.getCars().add(new Car(brand,numberofdoors,color,km,carLicense,insurance,price,year));
    }

    //--------------------Employee-------------//

    public Employee getSearchEmployee(String dni){ //method to return a specific employee
        for(int i=0; i < DataBase.getEmployees().size(); i++) {
            Employee searchedEmployee ;
            searchedEmployee = DataBase.getEmployees().get(i);
            if (dni.equals(searchedEmployee.getDni())) {
                return searchedEmployee;
            }
        }
        System.out.println("There is no employee with this dni");
        return null;
    }//method to return a specific employee

    public void searchEmployee(Scanner reader){ //method to search a specific employee
        String dni = Utilities.askInfo(reader,"Enter a dni");
        Employee searchedEmployee = PersistenceEmployee.searchEmployee(dni);
        if (searchedEmployee == null) {
            System.out.println("No Employee was found with this dni");
        } else {
            System.out.println("Employee found " + searchedEmployee);
        }
    }//method to search a specific employee

    public static List<String> getListDNIEmployee() {
        List<String> dni = new ArrayList<>();
        for (Employee employee: DataBase.getEmployees()) {
            dni.add(employee.getDni());
        }
        return dni;
    }

    public static void addEmployee(String dni, String name, String surname, int age, String rol, String salaryByMonth,String workedHours, String password){
        DataBase.getEmployees().add(new Employee(dni,name,surname,age,rol,salaryByMonth,workedHours,password));
    }
    ///-------------------methods of Car------------
    public static boolean searchCarsTrueOrFalse(String carlicense){
        for (Car car: DataBase.getCars()){
            if(car.getCarLicense().equals(carlicense)){
                return true;
            }
        }
        return false;
    }

    public static int  searchCars(String carlicense){
        int b = 000000000000000000000000000000000000000000;
        int i ;
        for( i =0; i < DataBase.getCars().size(); i++){
            if(DataBase.getCars().get(i).getCarLicense().equals(carlicense)) {
                return i;
            }
        }
        return b;
    }

    public static boolean searchCardTrueOrFalse(String cardNumber, Customer customer){

        for(int i = 0 ; i < customer.getCards().size(); i++){
            String cardnumber = String.valueOf(customer.getCards().get(i).getNumberCard());
            if(cardnumber.equals(cardNumber)){
                return true;
            }
        }
        return false;
    }
    public static void searchOrders (Scanner reader){
        String idOrder = Utilities.askInfo(reader,"Enter an id Order");
        Order searchedIdOrder = null;
        for (int i = 0; i < DataBase.getOrders().size(); i++) {
            if (idOrder.equals(DataBase.getOrders().get(i).getIdOrder())) {
                searchedIdOrder = DataBase.getOrders().get(i);
                break;
            }
        }
        if (searchedIdOrder == null) {
            System.out.println("No Order was found with this id Order");
        } else {
            System.out.println("Order found " + searchedIdOrder);
        }
    }
}
