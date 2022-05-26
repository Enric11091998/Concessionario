package com.manager_persistences;

import com.model.Car;

import javax.persistence.*;
import java.util.List;

public class PersistenceCar {

    public static Car searchCar(String carLicence){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseenric");
        Car car;
        try {
            EntityManager carDB = emf.createEntityManager();
            carDB.getTransaction().begin();
            car = carDB.find(Car.class,carLicence);
            carDB.getTransaction().commit();
            carDB.close();
        } finally{
            emf.close();
        }
        return car;
    }
    public static boolean existCar(String carLicence){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseenric");


        EntityManager carDB = emf.createEntityManager();
        carDB.getTransaction().begin();
        Car car = carDB.find(Car.class,carLicence);
        if(car != null){
            carDB.getTransaction().commit();
            carDB.close();
            emf.close();
            return true;
        }
        carDB.getTransaction().commit();
        carDB.close();
        emf.close();

        return false;
    }
    public static void deleteCar(Car car){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseenric");

        try {
            EntityManager carDB = emf.createEntityManager();
            carDB.getTransaction().begin();
            Query query2 = carDB.createNativeQuery("delete from car where carLicense = '"+ car.getCarLicense() +"'" );
            query2.executeUpdate();
            carDB.getTransaction().commit();
            carDB.close();
        } finally{
            emf.close();
        }
    }
    /*public static List<Car> carsFilter(String color, String brand, String year){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseenric");
        try {
            EntityManager carDB = emf.createEntityManager();
            carDB.getTransaction().begin();
            EntityGraph<?> cars = carDB.getEntityGraph(color);
            carDB.getTransaction().commit();
            carDB.close();
        } finally{
            emf.close();
        }

        return cars;
    }*/
}
