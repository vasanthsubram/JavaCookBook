package hibernate.test.emp;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import hibernate.data.emp.Employee;
import hibernate.data.emp.ParkingSpace;
import hibernate.service.EmployeeService;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;

import org.junit.Test;

public class OneToOneTest extends AbstractTestCase{

	@Test
	public void testOneToOne(){
		this.addParkingSpace();
		this.createEmployeeAndLinkParkingSpace();
		this.getEmployee();
		//this.tryDeletingParkingSpace();
		//this.cannotAddSameParkingSpaceToSecondEmployee();
		//this.getEmployeeThroughParkingSpace();
	}
	
	private void addParkingSpace() {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		ParkingSpace parking;
		parking = new ParkingSpace();
		parking.setId(PARKING_ID1);
		parking.setLocation(PARKING1);
		parking.setLotNum(1);
		em.persist(parking);
		em.getTransaction().commit();
		em.close();
	}
	private void createEmployeeAndLinkParkingSpace() {
		EntityManager em = getEntityManager();
		EmployeeService service = new EmployeeService(em);
		em.getTransaction().begin();
		ParkingSpace p = em.find(ParkingSpace.class, PARKING_ID1);
		assertNotNull(p);
		Employee emp;
		emp = service.createEmployee(EMP_ID1, EMP1, 45000);
		emp.setParkingSpace(p);
		em.persist(emp);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		assertTrue(em.find(Employee.class, EMP_ID1).getParkingSpace().getLocation().equals(PARKING1));
		em.getTransaction().commit();
		em.close();
	}
	
	private void cannotAddSameParkingSpaceToSecondEmployee() {
		EntityManager em = getEntityManager();
		try {
			EmployeeService service = new EmployeeService(em);
			em.getTransaction().begin();
			ParkingSpace p = em.find(ParkingSpace.class, PARKING_ID1);
			assertNotNull(p);
			Employee emp;
			emp = service.createEmployee(EMP_ID2, EMP2, 45000);
			emp.setParkingSpace(p);
			em.persist(emp);
			em.getTransaction().commit();
			fail("Should not link the same Parking Space to two employees");
		} catch(javax.persistence.EntityExistsException cvEx){
			System.out.println(" expected : " + cvEx.getMessage() +"\n ");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		} finally {
			em.close();
		}
	}
	
	private void tryDeletingParkingSpace() {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			ParkingSpace p3 = em.find(ParkingSpace.class, PARKING_ID1);
			em.remove(p3);
			em.getTransaction().commit();
		} catch (RollbackException ex) {
			// Expected
			System.out
					.println(" Expected: could not delete parking space, as it is still referenced by Employee\n");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		} finally {
			em.close();
		}
	}

	private void getEmployeeThroughParkingSpace() {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		ParkingSpace p = em.find(ParkingSpace.class, PARKING_ID1);
		assertNotNull(p);
		assertNotNull(p.getAssignedEmployee());
		assertEquals(p.getAssignedEmployee().getId(),EMP_ID1);
		em.getTransaction().rollback();
	}
	
	private void getEmployee(){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		Employee p = em.find(Employee.class, EMP_ID1);
		assertNotNull(p);
		em.getTransaction().rollback();
	}
}
