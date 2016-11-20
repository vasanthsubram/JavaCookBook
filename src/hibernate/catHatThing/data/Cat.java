package hibernate.catHatThing.data;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema="CAT_HAT_THING_SCHEMA", name="CAT")
public class Cat{
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="CAT_ID")
	private int id;
    private String name;
    private String eyeColor;
    private String furColor;
    private Timestamp creationTime;
    @OneToOne(cascade=CascadeType.ALL)    
    private Hat hat;

    @JoinTable(name="CAT_THING", schema="CAT_HAT_THING_SCHEMA", 
			joinColumns=@JoinColumn(name="CAT_ID"), 
			inverseJoinColumns=@JoinColumn(name="THING_ID"))
    @OneToMany(cascade=CascadeType.ALL)
    private List<Thing> things;
    
    public Cat(){
    	creationTime=new Timestamp(System.currentTimeMillis());
    }
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public String getFurColor() {
		return furColor;
	}

	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}

	public Hat getHat() {
		return hat;
	}

	public void setHat(Hat hat) {
		this.hat = hat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Thing> getThings() {
		return things;
	}

	public void setThings(List<Thing> things) {
		this.things = things;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	
}
