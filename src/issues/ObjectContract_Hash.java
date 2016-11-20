package issues;

import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertTrue;
/**
 * Importance of overriding hashCode() when equals() is overriden
 * This program will fail if the hashCode() is commented out
 * 
 * The default implementation of Object.hashCode() simply gives a hash value
 * based on the identity of an object (using the object pointer or through some
 * other means). Container such as HashSet uses the hash value, to put an object
 * in the proper bucket and to search for that object later on. If the hashCode
 * of an object is not overriden, it will be different for different objects
 * that are equal. So an object will be put in one bucket and later on when the
 * container is searched with an equal but a different object, the search will
 * look for it a different bucket and therefore will fail to find the object.
 * @author chq-vasanthakumars
 *
 */
public class ObjectContract_Hash {

	public static void main(String[] args) {		
		Set<Name> s = new HashSet<Name>();
		s.add(new Name("Mickey", "Mouse"));
		//if hashCode()is commented out in class Name, this assert will fail
		assertTrue(s.contains(new Name("Mickey", "Mouse")));
	}
}

 class Name{
	 private final String first, last;
	 
	 public Name(String first, String last){
		 this.first=first;
		 this.last=last;
	 }
	 
	 public boolean equals(Object o){
		 if(!(o instanceof Name)){
			 return false;
		 }
		 Name n= (Name) o;
		 return n.first.equals(first) && n.last.equals(last);
	 }
	//if this method is commented out,  assert in the main() will fail
	 public int hashCode(){
		 return 37*first.hashCode()+ last.hashCode();
	 }
 }
	
