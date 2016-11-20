package hibernate.test.emp;

import javax.persistence.EntityManager;
import org.junit.Test;
import static org.junit.Assert.*;

import hibernate.data.emp.Employee;
import hibernate.data.emp.Project;

import hibernate.service.EmployeeService;
import hibernate.service.ProjectService;

public class ManyToManyTest extends AbstractTestCase {

	@Test
	public void testManyToMany(){
		EntityManager em = getEntityManager();
		EmployeeService eService = new EmployeeService(em);
		
		em.getTransaction().begin();
		Employee e1,e2,e3;
		e1=eService.createEmployee1();
		e2=eService.createEmployee2();
		e3=eService.createEmployee3();
		ProjectService pService = new ProjectService();
		Project p1,p2;
		p1 = pService.creatProject1();
		p2 = pService.creatProject2();
		e1.getProjects().add(p1);
		e1.getProjects().add(p2);
		
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.getTransaction().commit();
		em.clear();
		
		em.getTransaction().begin();
		assertEquals(2,eService.findEmployee(1).getProjects().size());
		assertEquals(1,em.find(Project.class, 1).getMembers().size());
		assertEquals(1,em.find(Project.class, 2).getMembers().size());
		em.getTransaction().rollback();
	}
}
