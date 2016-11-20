package hibernate.mappings;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;


public class AbstractTestCase {

	protected EntityManagerFactory emf = Persistence
	.createEntityManagerFactory("mappings");

	protected void persistEntities(EntityManager em, Object... objects){
		em.getTransaction().begin();
		for(Object o: objects){
			em.persist(o);
		}
		em.getTransaction().commit();
	}
	
}
