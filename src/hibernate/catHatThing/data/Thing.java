package hibernate.catHatThing.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="CAT_HAT_THING_SCHEMA", name="THING")
public class Thing {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="THING_ID")
	private int id;
	private String name;
	private String trick;
	
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
	public String getTrick() {
		return trick;
	}
	public void setTrick(String trick) {
		this.trick = trick;
	}
}
