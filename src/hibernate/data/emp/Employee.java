package hibernate.data.emp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;

import hibernate.enums.EmployeeType;

@Table(schema="EMP_SCHEMA")
@AttributeOverride(name = "id", column = @Column(name = "EMP_ID"))
@Entity
public class Employee extends AbstractEntity{
	
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
	private Department department;
	
	//No unique constraint on the foreign key column  
	@JoinColumn(name="PARKING_ID")
	@Basic(fetch=FetchType.LAZY)
	@OneToOne
	private ParkingSpace parkingSpace;
	
	//unique constraint on address; therefore it cannot be null
	@JoinColumn(name="ADDRESS_ID", unique=true, nullable=false)
	@OneToOne(optional=false, cascade={CascadeType.ALL})
	@Basic(fetch=FetchType.LAZY)
	private Address address;
	
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name = "EMP_PROJ", schema = "EMP_SCHEMA", 
			joinColumns = @JoinColumn(name = "EMP_ID"), 
			inverseJoinColumns = @JoinColumn(name = "PROJ_ID"))
	private Collection<Project> projects= new ArrayList<Project>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="EMP_PHONE", schema="EMP_SCHEMA", 
			joinColumns=@JoinColumn(name="EMP_ID"), 
			inverseJoinColumns=@JoinColumn(name="PHONE_ID"))
	private Collection<Phone> phones = new ArrayList<Phone>();
	
	public Employee(){}
	
	public Employee(int id){
		this.id=id;
		this.type=EmployeeType.FULL_TIME;
		this.setStartDate(new Date(Calendar.getInstance().getTimeInMillis()));
	}
	
	public Employee(int id, EmployeeType type){
		this(id);
		this.type=type;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Collection<Project> getProjects() {
		return projects;
	}

	public void setProjects(Collection<Project> projects) {
		this.projects = projects;
	}

	public Collection<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Collection<Phone> phones) {
		this.phones = phones;
	}

	
}
