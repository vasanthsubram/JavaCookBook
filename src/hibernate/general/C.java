package hibernate.general;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema="GENERAL_SCHEMA", name="C")
public class C {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "C_ID")
	private int id;

	private String name;
	
	@ManyToOne
	@JoinColumn(name="B_ID")
	private B entityB;
	

	public C(){
		this.name="Unknown";
	}
	
	public C(String name){
		this.name=name;
	}

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
	
	public B getEntityB() {
		return entityB;
	}

	public void setEntityB(B entityB) {
		this.entityB = entityB;
	}
	
	
}
