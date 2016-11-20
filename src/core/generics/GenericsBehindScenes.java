package core.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsBehindScenes {

	public static void main(String[] args) {

        //The following invocation of ArrayList does not create new classes
        List<String> stringList = new ArrayList<String>();
        List<Integer> intList = new ArrayList<Integer>();
        System.out.println(stringList.getClass() == intList.getClass());
        //true

        //At runtime, no generic type info is present in objects
        System.out.println(stringList.getClass().getName());
        //ArrayList
	}
}
