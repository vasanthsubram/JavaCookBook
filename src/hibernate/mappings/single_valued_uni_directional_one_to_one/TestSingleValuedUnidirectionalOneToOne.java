package hibernate.mappings.single_valued_uni_directional_one_to_one;

import javax.persistence.EntityManager;

import org.hibernate.ejb.HibernateEntityManager;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import hibernate.mappings.AbstractTestCase;


public class TestSingleValuedUnidirectionalOneToOne extends AbstractTestCase{

	@Test
	public void testOneToOne(){
		EntityManager em = (EntityManager) emf.createEntityManager();
		
		M1_Cat cat = new M1_Cat();
		cat.setName("Meow");
		cat.setId(1);
		
		M1_Hat hat = new M1_Hat();
		hat.setId(1);
		hat.setBaseColor("White");
		hat.setStripeColor("Red");
		
		cat.setHat(hat);
		persistEntities(em, cat,hat);
		
		em.close();

		EntityManager validate_em = (EntityManager) emf.createEntityManager();
		
		M1_Cat c = validate_em.find(M1_Cat.class,1);
		assertNotNull(c);
		assertNotNull(c.getHat());
		assertTrue(c.getHat().getBaseColor().equals("White"));
		assertTrue(c.getHat().getStripeColor().equals("Red"));
		validate_em.close();
		
	}
}
