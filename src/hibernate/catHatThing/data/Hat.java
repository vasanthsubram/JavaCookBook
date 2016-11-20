package hibernate.catHatThing.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="CAT_HAT_THING_SCHEMA", name="HAT")
public class Hat {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="HAT_ID")
	private int id;
	private String baseColor;
	private String stripeColor;
	
	public Hat(){}
	
	public String getBaseColor() {
		return baseColor;
	}
	public void setBaseColor(String baseColor) {
		this.baseColor = baseColor;
	}
	public String getStripeColor() {
		return stripeColor;
	}
	public void setStripeColor(String stripeColor) {
		this.stripeColor = stripeColor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
