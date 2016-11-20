package hibernate.mappings.single_valued_uni_directional_one_to_one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema="MAPPINGS")
public class M1_Cat{
	@Id
    @Column()
	private int id;
    private String name;
    private String furColor;
   
    @OneToOne    
    private M1_Hat hat;
    
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
	public String getFurColor() {
		return furColor;
	}

	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}

	public M1_Hat getHat() {
		return hat;
	}

	public void setHat(M1_Hat hat) {
		this.hat = hat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
