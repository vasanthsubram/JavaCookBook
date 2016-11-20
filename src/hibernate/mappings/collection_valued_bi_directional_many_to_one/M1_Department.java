package hibernate.mappings.collection_valued_bi_directional_many_to_one;

import java.util.Collection;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table(schema="MAPPINGS")
@AttributeOverride(name="id", column=@Column(name="DEPT_ID"))
@Entity
public class M1_Department{

	@Id 
	protected int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String name;
	
	@OneToMany(mappedBy="department")
	private Collection<M1_Employee> employees;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<M1_Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Collection<M1_Employee> employees) {
		this.employees = employees;
	}
}
