package hibernate.mappings.collection_valued_bi_directional_many_to_one;

import static org.junit.Assert.assertTrue;
import hibernate.mappings.AbstractTestCase;

import org.hibernate.ejb.HibernateEntityManager;
import org.junit.Test;

public class TestCollectionValuedBidirectionalManyToOne extends AbstractTestCase{

	public static final int EMP1_ID=1;
	public static final int EMP2_ID=2;
	public static final int EMP3_ID=3;
	public static final String EMP1_NAME = "Employee1";
	public static final String EMP2_NAME = "Employee2";
	public static final String EMP3_NAME = "Employee3";
	
	public static final int DEPT1_ID=1;
	public static final int DEPT2_ID=2;
	public static final int DEPT3_ID=3;
	
	public static final String DEPT1_NAME= "QA";
	public static final String DEPT2_NAME= "DEV";
	public static final String DEPT3_NAME= "BUILD";
	
	
	@Test
	public void testManyToOne() {
		HibernateEntityManager em = (HibernateEntityManager) emf
				.createEntityManager();

		M1_Department d1 = new M1_Department();
		d1.setId(DEPT1_ID);
		d1.setName(DEPT1_NAME);

		M1_Department d2 = new M1_Department();
		d2.setId(DEPT2_ID);
		d2.setName(DEPT2_NAME);
		persistEntities(em, d1,d2);

		M1_Employee emp1 = new M1_Employee(EMP1_ID, EMP1_NAME, 11111);
		emp1.setDepartment(d1);
		M1_Employee emp2 = new M1_Employee(EMP2_ID, EMP2_NAME, 22222);
		emp2.setDepartment(d1);
		
		M1_Employee emp3 = new M1_Employee(EMP3_ID, EMP3_NAME, 33333);
		emp3.setDepartment(d2);
		persistEntities(em, emp1,emp2,emp3);
		em.close();

		HibernateEntityManager validate_em = (HibernateEntityManager) emf
				.createEntityManager();
		M1_Department dept1 = validate_em.find(M1_Department.class, DEPT1_ID);
		M1_Department dept2 = validate_em.find(M1_Department.class, DEPT2_ID);

		M1_Employee e1 = validate_em.find(M1_Employee.class, EMP1_ID);
		M1_Employee e2 = validate_em.find(M1_Employee.class, EMP2_ID);

		assertTrue(e1.getDepartment() == dept1);
		assertTrue(e2.getDepartment() == dept1);
		assertTrue(dept1.getEmployees().size() == 2);
		assertTrue(dept2.getEmployees().size() == 1);

		for (M1_Employee o : dept1.getEmployees()) {
			System.out.println(o.getName());
			System.out.println(o.getId());
		}
	}
}
