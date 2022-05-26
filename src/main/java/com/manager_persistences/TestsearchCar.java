package com.manager_persistences;

import com.model.Car;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestsearchCar {

    @Test
    public  void  searchCardsbyColorBrand(){
        Scanner reader = new Scanner(System.in);
        String color = "white";
        String brand = "bmw";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
        EntityManager em = emf.createEntityManager();
        try{
            String smt = "SELECT c from car c where c.color = ?1 and c.brand = ?2";
            em.getTransaction().begin();
            Stream<Car> car = em.createQuery(smt,Car.class).setParameter(1,color).setParameter(2,brand).getResultStream();
            List<Car> cars = car.collect(Collectors.toList());
            System.out.println(cars);
            em.getTransaction().commit();
            em.close();
        }finally {
            emf.close();

        }

    }
}
