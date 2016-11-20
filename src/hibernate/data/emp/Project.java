package hibernate.data.emp;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(schema="EMP_SCHEMA")
@AttributeOverride(name="id", column=@Column(name="PROJECT_ID"))
@Entity
public class Project extends AbstractEntity{

	private String name;

	@ManyToMany(mappedBy="projects",cascade={CascadeType.ALL})
	private Collection<Employee> members = new ArrayList<Employee>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Employee> getMembers() {
		return members;
	}

	public void setMembers(Collection<Employee> members) {
		this.members = members;
	}
	
	
}
