package hibernate.mappings.single_valued_uni_directional_one_to_one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="MAPPINGS")
public class M1_Hat {
	@Id
    @Column()
	private int id;
	private String baseColor;
	private String stripeColor;
	
	public M1_Hat(){}
	
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
