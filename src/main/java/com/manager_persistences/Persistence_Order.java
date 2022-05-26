package com.manager_persistences;

import com.model.Car;
import com.model.Card;
import org.junit.Test;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Queue;

public class Persistence_Order {


    @Test
    public  void searchCards(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
        EntityManager em = emf.createEntityManager();
        //Query<Car> carQuery = em
        em.getTransaction().begin();


        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
