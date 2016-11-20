package hibernate.data.emp;

import java.util.Collection;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table(name="DEPARTMENT", schema="EMP_SCHEMA")
@AttributeOverride(name="id", column=@Column(name="DEPT_ID"))
@Entity
public class Department extends AbstractEntity{

	private String name;
	
	@OneToMany(mappedBy="department")
	private Collection<Employee> employees;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}
}
