package com.manager_persistences;


import com.model.Card;
import com.model.Customer;

import javax.persistence.*;



public class PersistenceCustomer {

    public  <T> T testgeneric(T o){

        return o;
    }

    public static Customer findCustomer(String dni) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
            Customer customer;
            try {
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                customer = em.find(Customer.class, dni);
                em.getTransaction().commit();
                em.close();
            } finally {

                emf.close();
            }
            return customer;
    }

    public static boolean existsCustomer(String dni) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
        Customer customer;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        customer = em.find(Customer.class, dni);
        if(customer == null) {
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

    public static void customerPersistence(Customer customer){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
            try{
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                em.persist(customer);
                em.getTransaction().commit();;
                em.close();
            }finally {
                emf.close();

            }
    }
    public static void removeCustomer(Customer customer){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
        try{
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(customer);
            em.remove(em.find(Customer.class,customer.getDNI()));
            em.getTransaction().commit();
            em.close();
        }finally {
            emf.close();

        }
    }

    public static <T>  void modifyDataCustomer(T o){
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
    public static boolean addCard(Card card, Customer customer) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        customer.getCards().add(card);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return true;
    }



}
