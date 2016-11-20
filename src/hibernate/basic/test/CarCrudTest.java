package hibernate.basic.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import hibernate.basic.data.Car;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

public class CarCrudTest {

	public static final int CAR_ID1=1;
	protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_project");
	
	@Test
	public void testCar() {
		EntityManager em = emf.createEntityManager();
		try {
			// add car
			em.getTransaction().begin();
			Car car = new Car();
			car.setId(CAR_ID1);
			car.setColor("BLACK");
			car.setMake("TOYOTA");
			car.setModel("CAMRY");
			car.setYear(2000);
			em.persist(car);
			em.getTransaction().commit();
			em.close();

			// find a particular car
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Car found1 = em.find(Car.class, CAR_ID1);
			assertNotNull(found1);
			em.getTransaction().rollback();
			em.clear();

			// find all
			Query q = em.createQuery("SELECT e FROM Car e");
			Collection<Car> allCars = ((Collection<Car>) q.getResultList());
			for (Car e : allCars) {
				System.out.println("found Car:  " + e);
			}
			em.clear();

			// update an car
			em.getTransaction().begin();
			Car updateCar = em.find(Car.class, CAR_ID1);
			updateCar.setColor("RED");
			em.getTransaction().commit();
			em.clear();
			assertEquals(em.find(Car.class, CAR_ID1).getColor(), "RED");
			em.clear();

			// remove an car
			em.getTransaction().begin();
			Car delCar = em.find(Car.class, CAR_ID1);
			em.remove(delCar);
			em.getTransaction().commit();
			em.clear();
			assertNull(em.find(Car.class, CAR_ID1));

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		} finally {
			em.close();
		}
	}

}
