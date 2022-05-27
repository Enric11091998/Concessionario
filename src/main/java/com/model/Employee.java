package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="employee")
public class Employee {
    @Id
    private String dni;
    private String name;
    private String surname;
    private int age;
    private String rol;
    private String salaryByMonth;
    private String workedHours;
    private String password;

    //empty constructor
    protected Employee() {
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

    public String getName() {
        return name;
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

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSalaryByMonth() {
        return salaryByMonth;
    }

    public String getWorkedHours() {
        return workedHours;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
