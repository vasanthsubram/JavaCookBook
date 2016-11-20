package hibernate.data.emp;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//Not mapped to any table

@MappedSuperclass
public abstract class AbstractEntity {
	@Id 
	protected int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
