package hibernate.catHatThing.test;

import hibernate.catHatThing.data.Cat;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CreateCatTest extends AbstractCatTest {

	public void testAdd() {
		EntityManager em = (EntityManager) emf.createEntityManager();

		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			Cat cat1 = this.createCatNamed("CreatingCat");
			em.persist(cat1);
			tx.commit();

			Cat cat11 = em.find(Cat.class, cat1.getId());
			assertNotNull(cat11);

		} catch (Exception e) {
			 e.printStackTrace();
			fail();

		} finally {
			em.close();
		}
	}
}
