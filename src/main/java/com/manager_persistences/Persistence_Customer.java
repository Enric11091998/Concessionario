package com.manager_persistences;

import com.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;



public class Persistence_Customer {

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
                em.getTransaction().commit();
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
            /*Query query = em.createNativeQuery("delete from cards_of_customer where customer_dni =" + customer.getDNI());
            query.executeUpdate();*/
            System.out.println(customer.getDNI());
            Query query2 = em.createNativeQuery("delete from customer where dni = '"+ customer.getDni()+"'" );
            query2.executeUpdate();
            em.getTransaction().commit();
            em.close();
        }finally {
            emf.close();

        }
    }



}
