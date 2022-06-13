package com.controller;

import com.manager_persistences.PersistenceCEOCR;
import com.model.Employee;
import com.services.ValidatorData;
import com.utils.Utilities;

import java.util.Scanner;

public class EmployeeController {
    public static void registerEmployee(Scanner reader){//method that return a new object Employee with attributes //para hacer
        String[] vars0 = new String[9];
        ValidatorData vd = new ValidatorData();
        String listEmployee = ("dni?,name?,surname?,age?,rol?,salary by month?,worked hours?,Enter password:\n1. Password must contain at least one digit [0-9].\n2. Password must contain at least one lowercase Latin character [a-z].\n3. Password must contain at least one uppercase Latin character [A-Z].\n4. Password must contain at least one special character like ! @ # & ( ) – { } : ; ' ? / * ~ $ ^ + = < >\n5. Password must contain a length of at least 6 characters and a maximum of 12 characters.,Confirm password");

        while (true) {
            int count = 0;
            String[] listAll = listEmployee.split(",");
            for(String test2 : listAll) {
                System.out.println(test2);
                String a = reader.next();
                vars0[count] = vd.selectValidatorEmployee(String.valueOf(test2), a);
                if(count == 0) {
                    boolean dniExists = PersistenceCEOCR.exists(vars0[0],2);
                if(dniExists) {
                    System.out.println("this DNI already exists");
                    break;
                }
                }
                count++;
                if(count > 8){
                    if (!vars0[8].equals(vars0[7])) {
                        System.out.println("Wrong password");
                        break;
                    }
                    Employee employee = new Employee(vars0[0], vars0[1], vars0[2], Integer.parseInt(vars0[3]), vars0[4], vars0[5], vars0[6], vars0[7]);
                    PersistenceCEOCR.persistence(employee);
                    break;
                }
            }
        break;
        }

    }//method that return a new object Employee with attributes

    public static void deleteEmployee(Scanner reader){//method to delete an Employee
        String dni = Utilities.askInfo(reader,"Enter a dni");
        Employee employeeToDelete ;
        employeeToDelete = PersistenceCEOCR.find(dni,2);
        if(!(employeeToDelete == null)) {
        System.out.println(employeeToDelete);
        if (Utilities.actionVerification(reader, "Delete Employee").equals("Y")) {
                PersistenceCEOCR.remove(employeeToDelete,employeeToDelete.getDni(),2);
        }else{
            System.out.println("employee not deleted");
        }
        }else System.out.println("this employee no exist");
    }//method to delete an Employee

    public static void modifyEmployee(Scanner reader){//method to modify an Employee
        String dni = Utilities.askInfo(reader,"Enter a dni");

        ValidatorData validator = new ValidatorData();
        Employee employee;
        employee= PersistenceCEOCR.find(dni,2);
        int i;
        System.out.println(employee);
        if(employee == null) {
            System.out.println("This dni no exists");
        }
        else  do{
            System.out.println("1-Rol\n" + "2-Salary by month\n" + "3-worked hours\n" + "4-Return");//for
            i = reader.nextInt();
            if(i==1){
                System.out.println("Enter a new rol");
                String a = reader.next();
                a = validator.checkRol(a);
                employee.setRol(a);
                System.out.println(employee);
                PersistenceCEOCR.modifyData(employee);
            }else if(i==2){
                System.out.println("Enter a new salary");
                String a = reader.next();
                a = validator.checkSalaryByMonth(a);
                employee.setSalaryByMonth(a);
                System.out.println(employee);
                PersistenceCEOCR.modifyData(employee);
            }else if(i==3){
                System.out.println("Enter a new time worked in hours by week");
                String a = reader.next();
                a = validator.checkWorkedHours(a);
                employee.setWorkedHours(a);
                System.out.println(employee);
                PersistenceCEOCR.modifyData(employee);
            }
        }while(i!=4);


    }//method to modify an Employee

    public static void showAllEmployee(){

    }

    public static String confirmIsLoginDni(Scanner reader) {
        String dniEmployee = "12345678Z";
        String dni = Utilities.askInfo(reader,"Enter a dni");
        if(dni.equals(dniEmployee)){
            return dni;
        }
        return "incorrect dni";
    }
}
