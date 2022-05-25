package com.manager_persistences;

import com.controller.EmployeeController;
import com.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PersistenceEmployee {


    public static void addEmployeeToDB(Employee employee){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseenric");

        try {
            EntityManager employeeDB = emf.createEntityManager();
            employeeDB.getTransaction().begin();
            employeeDB.persist(employee);
            employeeDB.getTransaction().commit();
            employeeDB.close();
        } finally{
            emf.close();
        }
    }

    public static Employee searchEmployee (String dni){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseenric");
        Employee employee;
        try {
            EntityManager employeeDB = emf.createEntityManager();
            employeeDB.getTransaction().begin();
            employee = employeeDB.find(Employee.class,dni);
            employeeDB.getTransaction().commit();
            employeeDB.close();
        } finally{
            emf.close();
        }
        return employee;
    }

    public static boolean existEmployee(String dni){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseenric");


        EntityManager employeeDB = emf.createEntityManager();
        employeeDB.getTransaction().begin();
        Employee employee = employeeDB.find(Employee.class,dni);
        if(employee != null){
            employeeDB.getTransaction().commit();
            employeeDB.close();
            emf.close();
            return true;
        }
        employeeDB.getTransaction().commit();
        employeeDB.close();

        emf.close();

        return false;
    }
    public static void deleteEmployee(Employee employee){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseenric");

        try {
            EntityManager employeeDB = emf.createEntityManager();
            employeeDB.getTransaction().begin();
            Query query2 = employeeDB.createNativeQuery("delete from Employee where dni = '"+ employee.getDni()+"'" );
            query2.executeUpdate();
            employeeDB.getTransaction().commit();
            employeeDB.close();
        } finally{
            emf.close();
        }
    }
}
