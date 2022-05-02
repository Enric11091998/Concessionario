package com.company;

public class SellerManagement {
    String dni;
    String name;
    int age;
    String rol;
    double salary;
    String workhours;

    //Constructor empty
    public SellerManagement() {}

    public SellerManagement(String dni, String name, int age, String rol, double salary, String workhours) {
        this.dni = dni;
        this.name = name;
        this.age = age;
        this.rol = rol;
        this.salary = salary;
        this.workhours = workhours;
    }

    //method check if exists dni
    public boolean checkExistsDni(String dni){
        this.dni = dni;


        return false;
    }
}
