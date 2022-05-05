//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company;

public class Employee {
    public String dni;
    public String name;
    public String surname;
    public int age;
    public String rol;
    public int salaryByMonth;
    public int workedHours;

    public Employee() {
    }

    public Employee(String dni, String name, String surname, int age, String rol, int salaryByMonth, int workedHours) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.rol = rol;
        this.salaryByMonth = salaryByMonth;
        this.workedHours = workedHours;
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

    public void setSalaryByMonth(int salaryByMonth) {
        this.salaryByMonth = salaryByMonth;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

    public String toString() {
        return "Employee{dni='" + this.dni + "', name='" + this.name + "', surname='" + this.surname + "', age=" + this.age + ", rol='" + this.rol + "', SalaryByMonth=" + this.salaryByMonth + ", WorkTime=" + this.workedHours + "}";
    }
}
