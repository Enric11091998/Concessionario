package com.manager_persistences;


import com.model.Customer;
import com.model.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceOrder {

    public static void orderPersistence(Order order){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
        try{
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(order);
            em.getTransaction().commit();;
            em.close();
        }finally {
            emf.close();

        }
    }

}
