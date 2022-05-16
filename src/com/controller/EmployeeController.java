package com.controller;

import com.model.DataBase;
import com.model.Employee;
import com.utils.ValidatorData;
import com.utils.Utilitys;

import java.util.Scanner;

public class EmployeeController {
    public static void registerEmployee(Scanner reader){ //method that return a new object Employee with attributes //para hacer
        String[] vars0 = new String[9];
        DatabaseController db = new DatabaseController();
        ValidatorData vd = new ValidatorData();
        String listEmployee = ("dni?,name?,surname?,age?,rol?,salary by month?,worked hours?,Enter password:\n1. Password must contain at least one digit [0-9].\n2. Password must contain at least one lowercase Latin character [a-z].\n3. Password must contain at least one uppercase Latin character [A-Z].\n4. Password must contain at least one special character like ! @ # & ( ) – { } : ; ' ? / * ~ $ ^ + = < >\n5. Password must contain a length of at least 6 characters and a maximum of 12 characters.,Confirm password");

        while(true){
            int count = 0;
            if(Utilitys.actionVerification(reader,"registerEmployee").equals("Y")){
                String[] listAll = listEmployee.split(",");

                for(String test2: listAll){
                    System.out.println(test2);
                    String a = reader.next();
                    vars0[count] = vd.selectValidatorEmployee(String.valueOf(test2),a);
                    boolean dniExists = db.getListDNIEmployee().contains(vars0[0]);
                    if(dniExists){
                        System.out.println("this DNI already exists");
                        break;
                    }
                    count++;
                    if (count>8){
                        if(!vars0[8].equals(vars0[7])){
                            System.out.println("Wrong password");
                            break;
                        }
                        Employee employee = new Employee(vars0[0],vars0[1],vars0[2],Integer.parseInt(vars0[3]),vars0[4],vars0[5],vars0[6],vars0[7]);
                        DataBase.getEmployees().add(employee);
                        System.out.println(DataBase.getEmployees().toString());
                        break;
                    }
                }
            }else break;
        }
    }//method that return a new object Employee with attributes

    public static void deleteEmployee(Scanner reader, String dni){ //method to delete an Employee
        Employee employeeToDelete = new Employee ();
        DatabaseController db = new DatabaseController();
        employeeToDelete = db.getSearchEmployee(dni);
        System.out.println(employeeToDelete);
        if(Utilitys.actionVerification(reader,"Delete Employee").equals("Y")) {
            DataBase.getEmployees().remove(employeeToDelete);
        } else {
            System.out.println("employee not deleted");
        }
    }//method to delete an Employee

    public static void modifyEmployee(Scanner reader, String dni){//method to modify an Employee
        Employee employeeToModify = new Employee ();
        DatabaseController db = new DatabaseController();
        ValidatorData vd = new ValidatorData();
        employeeToModify = db.getSearchEmployee(dni);
        if(!employeeToModify.equals("null")) {
            System.out.println(employeeToModify);
            System.out.println("If you want to modify the rol enter the new rol if not write null");
            String newRol = reader.next();
            newRol = vd.checkRol(newRol);
            if (!newRol.equals("null")) {
                employeeToModify.setRol(newRol);
            }
            System.out.println("If you want to modify the salary by month enter the new salary if not write null");
            String newSalary = reader.next();
            newSalary = vd.checkSalaryByMonth(newSalary);
            if (!(newSalary.equals("null"))) {
                employeeToModify.setSalaryByMonth(newSalary);
            }
            System.out.println("If you want to modify the worked hours enter the hours worked if not write null");
            String newHoursWorked = reader.next();
            newHoursWorked =vd.checkWorkedHours(newHoursWorked);
            if (!(newHoursWorked.equals("null"))) {
                employeeToModify.setWorkedHours(newHoursWorked);
            }
            System.out.println(employeeToModify);
        }
    }//method to modify an Employee
}
