package com.manager_persistences;
import com.model.OrderDealer;

import javax.persistence.*;
public class PersistenceOrder {
    public static void orderPersistence(OrderDealer o){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
        try{
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
            em.close();
        }finally {
            emf.close();

        }
    }
}
