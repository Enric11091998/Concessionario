package persistenceTest;



import com.model.Card;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Evaluacion {
    @Test

    public void storeLoadMessage() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Card car = new Card();
            Customer customer = new Customer("12345678W","BIAGGIO","MOISES","23","698745623","RED","BMW");
            em.persist(customer);
            em.getTransaction().commit();
            em.close();
        } finally {
            emf.close();
        }
    }
}