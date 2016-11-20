package hibernate.mappings.collection_valued_uni_directional_one_to_many;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import hibernate.mappings.AbstractTestCase;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.ejb.HibernateEntityManager;
import org.junit.Test;


public class TestCollectionValuedUnidirectionalOneToMany extends
		AbstractTestCase {

	@Test
	public void testOneToOne() {
		HibernateEntityManager em = (HibernateEntityManager) emf
				.createEntityManager();

		Shipment shipment = new Shipment();
		shipment.setId(1);

		Item item1 = new Item();
		item1.setId(1);
		item1.setName("Pen");
		item1.setPrice(1.5);

		Item item2 = new Item();
		item2.setId(2);
		item2.setName("Pencil");
		item2.setPrice(0.5);

		Collection<Item> coll = new ArrayList<Item>();
		coll.add(item1);
		coll.add(item2);
		shipment.setItems(coll);
		persistEntities(em, item1, item2, shipment);

		em.close();

		HibernateEntityManager validate_em = (HibernateEntityManager) emf
				.createEntityManager();

		Shipment s = validate_em.find(Shipment.class, 1);
		assertNotNull(s);
		assertNotNull(s.getItems());
		assertTrue(s.getItems().size() == 2);
		validate_em.close();

	}
}
