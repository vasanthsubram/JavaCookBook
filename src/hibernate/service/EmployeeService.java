package hibernate.service;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import hibernate.data.emp.Address;
import hibernate.data.emp.Department;
import hibernate.data.emp.Employee;
import hibernate.data.emp.Phone;
import hibernate.enums.EmployeeType;

public class EmployeeService {

	protected EntityManager em;
	
	public EmployeeService(EntityManager em){
		this.em=em;
	}
	
	public Employee createEmployee(int id, String name, long salary){
		Employee emp= new Employee(id);
		emp.setId(id);
		emp.setName(name);
		emp.setSalary(salary);
		emp.setAddress(new Address());
		emp.getPhones().add(new Phone());
		return emp;
	}
	
	public Employee createEmployee(int id, String name, long salary, EmployeeType type){
		Employee emp = this.createEmployee(id, name, salary);
		emp.setType(type);
		emp.setAddress(new Address());
		return emp;
	}
	
	public Employee createEmployee(int id, String name, long salary, EmployeeType type, Department dept){
		Employee emp = this.createEmployee(id, name, salary);
		emp.setType(type);
		emp.setAddress(new Address());
		emp.setDepartment(dept);
		return emp;
	}
	
	public void removeEmployee(int id){
		Employee emp=findEmployee(id);
		if(emp !=null){
			em.remove(emp);
		}
	}
	
	public Employee findEmployee(int id){
		return em.find(Employee.class,id);
	}
	
	//To modify, we are not calling into the entity manager 
	// but directly on the object itself
	public Employee raiseEmployeeSalary(int id, long raise){
		Employee emp=findEmployee(id);
		if(emp !=null){
			emp.setSalary(emp.getSalary()+raise);
		}
		return emp;
	}
	
	public Collection<Employee> findAllEmployees(){
		Query q = em.createQuery("SELECT e FROM Employee e");
		return((Collection<Employee>) q.getResultList());
	}
	
	public Employee createEmployee1(){
		return createEmployee(1, "EMP1", 45000);
	}
	public Employee createEmployee2(){
		return createEmployee(2, "EMP2", 45000);
	}
	public Employee createEmployee3(){
		return createEmployee(3, "EMP3", 45000);
	}
	
}
