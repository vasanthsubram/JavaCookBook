package hibernate.test.emp;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import hibernate.data.emp.Department;
import hibernate.data.emp.Employee;
import hibernate.service.EmployeeService;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;

import org.junit.Test;

public class ManyToOneTest extends AbstractTestCase{
	@Test
	public void testManyToOne() {
		createDepartment();
		createEmployeeAndLinkDepartment();
		verifyLinksFromDepartment();
		verifyLinksFromEmployee();
		deleteDepartment();
	}
	
	private void createDepartment() {
		Department d = new Department();
		d.setId(DEPT_ID1);
		d.setName(DEPT_1);
		
		Department d2 = new Department();
		d2.setId(DEPT_ID2);
		d2.setName(DEPT_2);		
		persistEntities(d,d2);
	}
	
	private void createEmployeeAndLinkDepartment() {
		EntityManager em = getEntityManager();
		EmployeeService service = new EmployeeService(getEntityManager());
		
		Department d1 = em.find(Department.class, DEPT_ID1);
		
		Employee emp1 = service.createEmployee(EMP_ID1, EMP1, 45000);
		emp1.setDepartment(d1);
		Employee emp2 = service.createEmployee(EMP_ID2, EMP2, 65000);
		emp2.setDepartment(d1);
		
		Employee emp3 = service.createEmployee(EMP_ID3, EMP3, 55000);
		Department d2 = em.find(Department.class, DEPT_ID2);
		emp3.setDepartment(d2);
		
		persistEntities(emp1,emp2,emp3);
		em.close();
	}
	
	private void verifyLinksFromDepartment(){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		Department d1 = em.find(Department.class, DEPT_ID1);
		assertNotNull(d1);
		assertEquals(2,d1.getEmployees().size());
		Department d2 = em.find(Department.class, DEPT_ID2);
		assertNotNull(d2);
		assertEquals(1,d2.getEmployees().size());
		em.getTransaction().rollback();
	}
	
	private void verifyLinksFromEmployee(){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		Employee emp1 = em.find(Employee.class, EMP_ID1);
		assertNotNull(emp1);
		assertEquals(1,emp1.getDepartment().getId());
		
		Employee emp2 = em.find(Employee.class, EMP_ID2);
		assertNotNull(emp2);
		assertEquals(1,emp2.getDepartment().getId());
		
		Employee emp3 = em.find(Employee.class, EMP_ID3);
		assertNotNull(emp3);
		assertEquals(2,emp3.getDepartment().getId());
	}
	
	private void deleteDepartment() {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			Department d = em.find(Department.class, DEPT_ID1);
			em.remove(d);
			em.getTransaction().commit();
		} catch (RollbackException rEx) {
			// Expected
			System.out
					.println(" Expected: could not delete Department, as it is still referenced by Employee");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		} finally {
			em.close();
		}
	}
}
