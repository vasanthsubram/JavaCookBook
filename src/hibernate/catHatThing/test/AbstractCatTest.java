package hibernate.catHatThing.test;

import hibernate.catHatThing.data.Cat;
import hibernate.catHatThing.data.Hat;
import hibernate.catHatThing.data.Thing;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.TestCase;

public class AbstractCatTest extends TestCase {
	protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_project");

	protected Cat createCatNamed(String catName) {
		Cat cat = new Cat();
		cat.setName(catName);
		cat.setEyeColor("Blue");
		cat.setFurColor("Black");

		Hat hat = new Hat();
		hat.setBaseColor("White");
		hat.setStripeColor("Red");
		cat.setHat(hat);
		
		Thing thing1= new Thing();
		thing1.setName("Thing1");
		thing1.setTrick("Trick1");
		
		Thing thing2= new Thing();
		thing2.setName("Thing2");
		thing2.setTrick("Trick2");
		
		List<Thing> things = new ArrayList<Thing>();
		things.add(thing1);
		things.add(thing2);
		cat.setThings(things);
		return cat;
	}

}
