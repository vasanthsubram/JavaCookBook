package hibernate.data.emp;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="Parking_Space",schema="EMP_SCHEMA")
@AttributeOverride(name = "id", column = @Column(name = "PARKING_ID"))
@Entity
public class ParkingSpace extends AbstractEntity {

	private int lotNum;
	private String location;
	
	@OneToOne(mappedBy="parkingSpace")
	private Employee assignedEmployee;
	
	public int getLotNum() {
		return lotNum;
	}
	public void setLotNum(int lotNum) {
		this.lotNum = lotNum;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Employee getAssignedEmployee() {
		return assignedEmployee;
	}
	public void setAssignedEmployee(Employee assignedEmployee) {
		this.assignedEmployee = assignedEmployee;
	}
	
	
}
