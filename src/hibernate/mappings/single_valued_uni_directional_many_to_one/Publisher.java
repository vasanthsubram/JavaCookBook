package hibernate.mappings.single_valued_uni_directional_many_to_one;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(schema="MAPPINGS")
@Entity
public class Publisher {
	@Id
	protected int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
