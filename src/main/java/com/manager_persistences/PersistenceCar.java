package com.manager_persistences;
import com.model.Car;
import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class PersistenceCar {

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
    public  static List<Car> searchCardsbyColorBrand(String brand,String color){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
        EntityManager em = emf.createEntityManager();
        String smt = "SELECT c from car c where c.brand = '"+ brand+"' and c.color = '"+ color+"'";
        em.getTransaction().begin();
        Stream<Car> car = em.createQuery(smt,Car.class).getResultStream();
        List<Car> cars = car.collect(Collectors.toList());
        em.getTransaction().commit();
        em.close();
        emf.close();
        return cars;


    }
    public  static List<Car> searchCardsbyColorBrandYear(String brand,String color,String year){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
        EntityManager em = emf.createEntityManager();
        String smt = "SELECT c from car c where c.brand = ?1 and c.color = ?2 and c.year = ?3";
        em.getTransaction().begin();
        Stream<Car> car = em.createQuery(smt,Car.class).setParameter(1,brand).setParameter(2,color).setParameter(3,year).getResultStream();
        List<Car> cars = car.collect(Collectors.toList());
        em.getTransaction().commit();
        em.close();
        emf.close();
        return cars;

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
