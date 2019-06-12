package core.generics;

import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericTest {

    public static void main(String args[]) throws Exception {

    	// List<Number> numList = new  ArrayList<Integer>();        //error
		List<? extends Number> numList2 =new ArrayList<Integer>();  //OK
		//List<? extends Number> list2 = new ArrayList<String>();  // error

    	//cannot create instances of wildcard parameterized types {? cannot appear in new)
    	// List<?> anyList = new ArrayList<?>();
    	// List<?> anyList = new ArrayList<? extends String>();
    	
    	Collection<?> coll = new ArrayList<String>(); 
    	List<? extends Number> list = new ArrayList<Long>(); 
    	Comparator<? super String> cmp = new RuleBasedCollator("< a< b< c< d"); 
    	Map<String,?> pair = new HashMap<String,String>();




    }
}
