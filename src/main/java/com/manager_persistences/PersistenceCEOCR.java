package com.manager_persistences;
import com.model.*;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Persistence Customer, Employee, Order, Car
public class PersistenceCEOCR {


    public static <T> T find(String dni, int choice) {
        Customer customer;
        Employee employee;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
        EntityManager em = emf.createEntityManager();

            if(choice==1){
                em.getTransaction().begin();
                customer = em.find(Customer.class, dni);
                em.getTransaction().commit();
                em.close();
                emf.close();
                return (T) customer;
            }
            if(choice==2){
                em.getTransaction().begin();
                employee = em.find(Employee.class, dni);
                em.getTransaction().commit();
                em.close();
                emf.close();
                return (T) employee;
            }
            return null;
    }

    public static boolean exists(String dni, int choice) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
        EntityManager em = emf.createEntityManager();
        if(choice==1){
            em.getTransaction().begin();
            if(find(dni,1) == null){
                em.getTransaction().commit();
                em.close();
                emf.close();
                return false;
            }
        }
        if(choice==2){
            em.getTransaction().begin();
            if(find(dni,2) == null){
                em.getTransaction().commit();
                em.close();
                emf.close();
                return false;
            }
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
        return true;
    }

    public static <T> void persistence(T o){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
            try{
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                em.persist(o);
                em.getTransaction().commit();;
                em.close();
            }finally {
                emf.close();

            }
    }

    public static <T> void remove(T o, String dni, int choice){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
        EntityManager em = emf.createEntityManager();
        if(choice==1){
            em.getTransaction().begin();
            em.merge(o);
            em.remove(em.find(Customer.class,dni));
            em.getTransaction().commit();
            em.close();
        }
        if(choice==2){
            em.getTransaction().begin();
            em.merge(o);
            em.remove(em.find(Employee.class,dni));
            em.getTransaction().commit();
            em.close();
        }
    }

    public static <T>  void modifyData(T o){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
        try{
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(o);
            em.getTransaction().commit();
            em.close();
        }finally {
            emf.close();
        }
    }

    public static boolean searchCard(Long card2) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
        Card card;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        card = em.find(Card.class, card2);
        if(card == null) {
            em.getTransaction().commit();
            em.close();
            emf.close();
            return false;
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
        return true;
    }

    public  static List<Car> searchCardsbyAttributes(String brand, String color, String year, int choice){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
        EntityManager em = emf.createEntityManager();
        if(choice==1){
            String smt = "SELECT c from car c where c.brand = ?1 and c.color = ?2 and c.status = 'unsold' ";
            em.getTransaction().begin();
            Stream<Car> car = em.createQuery(smt,Car.class).setParameter(1,brand).setParameter(2,color).getResultStream();
            List<Car> cars = car.collect(Collectors.toList());
            em.getTransaction().commit();
            em.close();
            emf.close();
            return cars;
        }
        if(choice==2){
            String smt = "SELECT c from car c where c.brand = ?1 and c.color = ?2 and c.status = 'unsold' ";
            em.getTransaction().begin();
            Stream<Car> car = em.createQuery(smt,Car.class).setParameter(1,brand).setParameter(2,color).setParameter(3,year).getResultStream();
            List<Car> cars = car.collect(Collectors.toList());
            em.getTransaction().commit();
            em.close();
            emf.close();
            return cars;
        }
        return null;
    }

    public static void statusCar(Car car){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
        try{
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createNativeQuery("update car c set c.status = 'sold' where c.carLicense = '" + car.getCarLicense() +"'" );
            query.executeUpdate();
            em.getTransaction().commit();
            em.close();
        }finally {
            emf.close();

        }
    }

    public static void SetOrderCar(OrderDealer o){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
        try{
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(o);
            em.getTransaction().commit();
            em.close();
        }finally {
            emf.close();

        }
    }
}
