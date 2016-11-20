package hibernate.catHatThing.test;

import hibernate.catHatThing.data.Cat;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class FindCatTest extends AbstractCatTest {
	
	public void setUp() throws Exception {
		EntityManager em = (EntityManager) emf.createEntityManager();
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			Cat cat1 = this.createCatNamed("FindingCat");
			em.persist(cat1);
			tx.commit();
			
		} finally {
			em.close();
		}
	}
	
	/*
	public void tearDown(){
		HibernateEntityManager em = (HibernateEntityManager) emf
		.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		String query = "Select e from Cat e";
		List<Cat>  list = (List<Cat>)em.createQuery(query).getResultList();
		for(Cat t: list){
			em.remove(t);
		}
		tx.commit();
		em.close();
	}
*/
	
	/*
	public void testFind() {
		HibernateEntityManager em = (HibernateEntityManager) emf
				.createEntityManager();

		try {
			Cat cat1 = em.find(Cat.class, catId);

			assertNotNull(cat1);
			assertEquals("FindingCat", cat1.getName());
			assertEquals("Blue", cat1.getEyeColor());
			assertEquals("Black", cat1.getFurColor());

			Hat hat = cat1.getHat();
			assertNotNull(hat);
			
			assertEquals(hat.getBaseColor(), "White");
			assertEquals(hat.getStripeColor(), "Red");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	*/
	
	
	public void testFindCatByJPQL() {
		EntityManager em = (EntityManager) emf.createEntityManager();
		try {
			String query = "Select e from Cat e where e.name='FindingCat'";
			List<Cat>  list = (List<Cat>)em.createQuery(query).getResultList();
			for(Cat t: list){
				System.out.println(t.getId());
				System.out.println(t.getName());
				System.out.println(t.getEyeColor());
				
				System.out.println(t.getHat().getBaseColor());
				
//				System.out.println(t.getThings().get(0).getId());
//				System.out.println(t.getThings().get(0).getName());
//				
//				System.out.println(t.getThings().get(1).getId());
//				System.out.println(t.getThings().get(1).getName());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	public void testFindCatAndThingByJPQL() {
		EntityManager em = (EntityManager) emf.createEntityManager();
		try {
			String query = "Select e from Cat e where e.name='FindingCat'";
			List<Cat>  list = (List<Cat>)em.createQuery(query).getResultList();
			for(Cat t: list){
				System.out.println(t.getId());
				System.out.println(t.getName());
				System.out.println(t.getEyeColor());
				
				System.out.println(t.getHat().getBaseColor());
				
				System.out.println(t.getThings().get(0).getId());
				System.out.println(t.getThings().get(0).getName());
				
				System.out.println(t.getThings().get(1).getId());
				System.out.println(t.getThings().get(1).getName());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

}
