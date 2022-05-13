package com.company;

public class Employee {
    public String dni;
    public String name;
    public String surname;
    public int age;
    public String rol;
    public String salaryByMonth;
    public String workedHours;
    public String password;

    //empty constructor
    public Employee() {
    }

    //all attributes constructor
    public Employee(String dni, String name, String surname, int age, String rol, String salaryByMonth, String workedHours, String password) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.rol = rol;
        this.salaryByMonth = salaryByMonth;
        this.workedHours = workedHours;
        this.password = password;
    }

    public String getDni() {
        return this.dni;
    }

    public String getRol() {
        return this.rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setSalaryByMonth(String salaryByMonth) {
        this.salaryByMonth = salaryByMonth;
    }

    public void setWorkedHours(String workedHours) {
        this.workedHours = workedHours;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "dni='" + this.dni + '\'' +
                ", name='" + this.name + '\'' +
                ", surname='" + this.surname + '\'' +
                ", age=" + this.age +
                ", rol='" + this.rol + '\'' +
                ", SalaryByMonth=" + this.salaryByMonth +
                ", WorkTime=" + this.workedHours +
                '}';
    }
}
