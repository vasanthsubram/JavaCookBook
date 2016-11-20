package effectiveJava;

import java.util.ArrayList;
import java.util.List;

public final class EqualitySymmetric {
	 public static void main(String args[]){

		 CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
	    	String s = "polish";
	    	
	    	System.out.println(cis.equals(s));	//true
	    	System.out.println(s.equals(cis));	//false
	    	
	    	List<CaseInsensitiveString> list =
	    	    new ArrayList<CaseInsensitiveString>();
	    	list.add(cis);
	    	
	    	System.out.println(list.contains(s));  //false
	    }
}
 
final class CaseInsensitiveString{
	private final String s;

    public CaseInsensitiveString(String s) {
        if (s == null)
            throw new NullPointerException();
        this.s = s;
    }

    // Broken - violates symmetry!
    @Override public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(
                ((CaseInsensitiveString) o).s);
     //   if (o instanceof String)  // One-way interoperability!
      //      return s.equalsIgnoreCase((String) o);
        return false;
    }
}