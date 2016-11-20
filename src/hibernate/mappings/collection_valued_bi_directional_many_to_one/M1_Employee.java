package hibernate.mappings.collection_valued_bi_directional_many_to_one;

import hibernate.enums.EmployeeType;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(schema="MAPPINGS")
@AttributeOverride(name = "id", column = @Column(name = "EMP_ID"))
@Entity
public class M1_Employee{
	@Id 
	protected int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	private String name;
	private long salary;
	
	@Column(name="COMM")
	private String comments;
	
	@Enumerated(EnumType.STRING)
	private EmployeeType type;
	
	@Column(name="START_DATE")
	private Date startDate;
	
	@ManyToOne
	@JoinColumn(name="DEPT_ID")
	@Basic(fetch=FetchType.LAZY)
	private M1_Department department;
	
	public M1_Employee(){}
	
	public M1_Employee(int id,String name, long salary){
		this.id=id;
		this.type=EmployeeType.FULL_TIME;
		this.setStartDate(new Date(Calendar.getInstance().getTimeInMillis()));
		this.name=name;
		this.salary=salary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public EmployeeType getType() {
		return type;
	}
	public void setType(EmployeeType type) {
		this.type = type;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public M1_Department getDepartment() {
		return department;
	}

	public void setDepartment(M1_Department department) {
		this.department = department;
	}	
}
