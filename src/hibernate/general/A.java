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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(schema="GENERAL_SCHEMA", name="A")
public class A {

	 @Id @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name="A_ID")
		private int id;
	 
	@JoinTable(name="AB_LINK", schema="GENERAL_SCHEMA", 
			joinColumns=@JoinColumn(name="A_ID"), 
			inverseJoinColumns=@JoinColumn(name="B_ID"))
    @OneToMany(cascade=CascadeType.ALL)
    private List<B> entityB= new ArrayList<B>();
	
	private String name;

	public A(){
		this.name="Unknown";
	}
	public A(String name){
		this.name=name;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<B> getEntityB() {
		return entityB;
	}

	public void setEntityB(List<B> entityB) {
		this.entityB = entityB;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
