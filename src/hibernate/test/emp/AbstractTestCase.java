package hibernate.test.emp;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.ejb.HibernateEntityManager;
import org.junit.Before;


public class AbstractTestCase {

	public static final int EMP_ID1=1;
	public static final int EMP_ID2=2;
	public static final int EMP_ID3=3;
	public static final String EMP1 = "Employee1";
	public static final String EMP2 = "Employee2";
	public static final String EMP3 = "Employee3";
	
	public static final int DEPT_ID1=1;
	public static final int DEPT_ID2=2;
	public static final int DEPT_ID3=3;
	
	public static final String DEPT_1= "QA";
	public static final String DEPT_2= "DEV";
	public static final String DEPT_3= "BUILD";
	
	public static final int PARKING_ID1=1;
	public static final String PARKING1 = "ParkingSpace1";
	
	public static final int CAR_ID1=1;
	public static final int CAR_ID2=2;
	public static final String CAR1 = "CAR1";
	public static final String CAR2 = "CAR2";
	
	protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_project");
	
	@Before
	public void setUp() throws Exception {
		
	}

	protected EntityManager getEntityManager(){
		return (EntityManager) emf.createEntityManager();
	}
	
	protected void persistEntities(Object... objects){
		persistEntities(getEntityManager(), objects);
	}
	
	protected void persistEntities(EntityManager em, Object... objects){
		em.getTransaction().begin();
		for(Object o: objects){
			em.persist(o);
		}
		em.getTransaction().commit();
	}
	
}
