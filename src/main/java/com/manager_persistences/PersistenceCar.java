package com.manager_persistences;

import com.model.Car;
import com.model.Customer;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class PersistenceCar {
static List<Car> cars;
    public static Car searchCar(String carLicence){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");


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
    public  static List<Car> searchCardsbyColorBrand(String color,String brand){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
        EntityManager em = emf.createEntityManager();
        try {
            String smt = "SELECT c from car c where c.color = ?1 and c.brand = ?2";
            em.getTransaction().begin();
            Stream<Car> car = em.createQuery(smt,Car.class).setParameter(1,color).setParameter(2,brand).getResultStream();
            cars = car.collect(Collectors.toList());
            em.getTransaction().commit();
            em.close();
        }finally {
            emf.close();
            return cars;
        }

    }
    public  static List<Car> searchCardsbyColorBrandYear(String color,String brand,String year){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
        EntityManager em = emf.createEntityManager();
        try {
            String smt = "SELECT c from car c where c.color = ?1 and c.brand = ?2 and c.brand = ?3";
            em.getTransaction().begin();
            Stream<Car> car = em.createQuery(smt,Car.class).setParameter(1,color).setParameter(2,brand).setParameter(3,year).getResultStream();
            cars = car.collect(Collectors.toList());
            em.getTransaction().commit();
            em.close();
        }finally {
            emf.close();
            return cars;
        }
    }
    public static void removeCar(Car car){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
        try{
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createNativeQuery("delete from car where carLicense = '"+ car.getCarLicense()+"'" );
            query.executeUpdate();
            em.getTransaction().commit();
            em.close();
        }finally {
            emf.close();

        }
    }
}
