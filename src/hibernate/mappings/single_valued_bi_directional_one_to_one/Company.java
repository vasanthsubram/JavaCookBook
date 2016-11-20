package hibernate.mappings.single_valued_bi_directional_one_to_one;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Table(schema="MAPPINGS")
@Entity
public class Company {

	@Id 
	protected int id;
	
	@OneToOne
	CEO ceo;
	
	String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public CEO getCEO() {
		return ceo;
	}
	public void setCEO(CEO ceo) {
		this.ceo = ceo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
