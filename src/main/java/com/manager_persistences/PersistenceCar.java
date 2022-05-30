package com.manager_persistences;
import com.model.Car;
import javax.persistence.*;


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


}
