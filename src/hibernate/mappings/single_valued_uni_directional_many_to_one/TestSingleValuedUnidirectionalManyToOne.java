package hibernate.mappings.single_valued_uni_directional_many_to_one;

import static org.junit.Assert.assertTrue;
import hibernate.mappings.AbstractTestCase;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;


public class TestSingleValuedUnidirectionalManyToOne extends AbstractTestCase{

	@Test
	public void testOneToOne(){
		EntityManager em = (EntityManager) emf.createEntityManager();
		
		Publisher pub1 = new Publisher();
		pub1.setId(1);
		pub1.setName("First");
		
		Publisher pub2 = new Publisher();
		pub2.setId(2);
		pub2.setName("Second");
		
		Book book1= new Book();
		book1.setId(1);
		book1.setPublisher(pub1);
		book1.setTitle("Book1");
		
		Book book2 = new Book();
		book2.setId(2);
		book2.setPublisher(pub1);
		book2.setTitle("Book2");
		
		Book book3 = new Book();
		book3.setId(3);
		book3.setPublisher(pub2);
		book3.setTitle("Book3");
		
		persistEntities(em, pub1,pub2,book1,book2,book3);
		
		em.close();

		EntityManager validate_em = (EntityManager) emf.createEntityManager();
		
		Book bk1 = validate_em.find(Book.class,1);
		assertTrue(bk1.getPublisher().getName().equals("First"));
	
		Book bk2 = validate_em.find(Book.class,3);
		assertTrue(bk2.getPublisher().getName().equals("Second"));
	
		List<Book> list = validate_em.createQuery("select b from Book b where b.publisher=1").getResultList();
		assertTrue(list.size()==2);
		for(Book b: list){
			System.out.println(b.getId() + "  " + b.getTitle());
		}
		validate_em.close();
		
	}
}
