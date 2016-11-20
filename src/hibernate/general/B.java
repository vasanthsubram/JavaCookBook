package hibernate.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(schema="GENERAL_SCHEMA", name="B")
public class B {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "B_ID")
	private int id;

	@JoinTable(name = "BC_LINK", schema = "GENERAL_SCHEMA", joinColumns = @JoinColumn(name = "B_ID"), inverseJoinColumns = @JoinColumn(name = "C_ID"))
	@OneToMany(cascade = CascadeType.ALL)
	private List<C> entityC= new ArrayList<C>();

	private String name;

	@ManyToOne
	@JoinColumn(name="A_ID")
	private A entityA;
	
	
	public B(){
		this.name="Unknown";
	}
	public B(String name){
		this.name=name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<C> getEntityC() {
		return entityC;
	}

	public void setEntityC(List<C> entityC) {
		this.entityC = entityC;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public A getEntityA() {
		return entityA;
	}
	public void setEntityA(A entityA) {
		this.entityA = entityA;
	}
}
