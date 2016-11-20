package hibernate.general;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import junit.framework.TestCase;

import org.hibernate.ejb.HibernateEntityManager;

public class FindEntities extends TestCase{
	
	protected EntityManagerFactory emf = Persistence
	.createEntityManagerFactory("jpa_project");
	
	public void setUp() throws Exception {
		HibernateEntityManager em = (HibernateEntityManager) emf
				.createEntityManager();
			
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			addEntry(em,1);
			addEntry(em,2);
			tx.commit();
			
		} finally {
			em.close();
		}
	}
	
	private void addEntry(HibernateEntityManager em, int index){
		A a = new A("A" +index);
		em.persist(a);
		
		B b11 = new B("B"+index+"1");
		B b12 = new B("B"+index+"2");
		a.getEntityB().add(b11);
		a.getEntityB().add(b12);
		b11.setEntityA(a);
		b12.setEntityA(a);
		
		C c111=new C("C"+index+"11");
		C c112=new C("C"+index+"12");
		C c121=new C("C"+index+"21");
		C c122=new C("C"+index+"22");
		
		b11.getEntityC().add(c111);
		b11.getEntityC().add(c112);
	
		b12.getEntityC().add(c121);
		b12.getEntityC().add(c122);
		
		c111.setEntityB(b11);
		c112.setEntityB(b11);
		c121.setEntityB(b12);
		c122.setEntityB(b12);
	}
	
	public void testGeneralEntities(){

		HibernateEntityManager em = (HibernateEntityManager) emf
				.createEntityManager();
		try {
			//String query = "Select g from A e JOIN e.entityB f JOIN f.entityC g where f.name='B11'";
			//String query = "Select f from A e, IN(e.entityB) f where e.name='A1'";
			//String query = "Select g from A e, B f, C g where e.id=f.entityA.id and f.id=g.entityB.id and f.name='B11'";
			String query = "Select e from A e  where e.name='A1'";
			//List<C>  list = (List<C>)em.createQuery(query).getResultList();
			List<A>  list = (List<A>)em.createQuery(query).getResultList();
			printA(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	private void printA(List<A> list){
		for(A t: list){
			System.out.println(t.getId());
			System.out.println(t.getName());
			
			System.out.println(t.getEntityB().get(0).getName());
			System.out.println(t.getEntityB().get(1).getName());
			
			System.out.println(t.getEntityB().get(0).getEntityC().get(0).getName());
			System.out.println(t.getEntityB().get(0).getEntityC().get(1).getName());
			
			System.out.println(t.getEntityB().get(1).getEntityC().get(0).getName());
			System.out.println(t.getEntityB().get(1).getEntityC().get(1).getName());
		}
	}
	
	private void printB(List<B> list){
		for(B t: list){
			System.out.println(t.getId());
			System.out.println(t.getName());
			
			System.out.println(t.getEntityC().get(0).getName());
			System.out.println(t.getEntityC().get(1).getName());
			
			System.out.println(t.getEntityC().get(0).getName());
			System.out.println(t.getEntityC().get(1).getName());
		}
	}
	
	private void printC(List<C> list){
		for(C t: list){
			System.out.println("C id = " + t.getId());
			System.out.println("C name = " + t.getName());
			
			System.out.println("B id = " + t.getEntityB().getId());
			System.out.println("B name = " + t.getEntityB().getName());
			
			System.out.println("A id = " + t.getEntityB().getEntityA().getId());
			System.out.println("A name = " +t.getEntityB().getEntityA().getName());	
		}
	}
}
