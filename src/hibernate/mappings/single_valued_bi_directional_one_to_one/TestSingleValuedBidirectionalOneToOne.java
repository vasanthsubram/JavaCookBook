package hibernate.mappings.single_valued_bi_directional_one_to_one;

import org.hibernate.ejb.HibernateEntityManager;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import hibernate.mappings.AbstractTestCase;


public class TestSingleValuedBidirectionalOneToOne extends AbstractTestCase{

	@Test
	public void testOneToOne(){
		HibernateEntityManager em = (HibernateEntityManager) emf
		.createEntityManager();
		
		CEO ceo = new CEO();
		ceo.setName("Tiger");
		ceo.setId(1);
		
		Company company = new Company();
		company.setId(1);
		company.setName("ACME");
		
		ceo.setCompany(company);
		company.setCEO(ceo);
		persistEntities(em, ceo,company);
		
		em.close();

		HibernateEntityManager validate_em = (HibernateEntityManager) emf
				.createEntityManager();
		
		Company c = validate_em.find(Company.class,1);
		assertNotNull(c);
		assertNotNull(c.ceo);
		assertTrue(c.getCEO().getName().equals("Tiger"));
		validate_em.close();
		
	}
}
