package persistenceTest;
import org.testng.annotations.Test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;


public class Evaluacion {
    @Test
    public void storeLoadMessage() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Databaseprueba");
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            //Customer customer = em.find(Customer.class,"12345678Z");
            Card car = new Card(5562000005625356L,"052024","MASTERCARD","092");
            List<Card> cardsUser = new ArrayList<>();
            cardsUser.add(car);
            Customer customer = new Customer("12345678R","BIAGGIO","MOISES","22","789456123","GREEN","LEXUS",cardsUser);
            em.persist(customer);
            em.getTransaction().commit();
            em.close();
        } finally {
            emf.close();
        }
    }
}