package core.boxing;
import java.util.ArrayList;
import java.util.List;


public class Boxing {

	public static void main(String args[]){
		Integer i = new Integer(9);
		Integer j = new Integer(13);
		Integer k = i + j;
	
                Integer integerYear = new Integer(1989);
                Integer otherIntegerYear = integerYear + 10;
                //Integer object is unboxed and added to an int
                int intYear = integerYear + new Integer(15);
                System.out.println(intYear);
                 //Integer object is unboxed and assigned to an int
		Integer in = 10;
		int intVal = in;
		//Integer object is unboxed and assigned to an float
		floatMethod(in);
		
                //primtives are added to a Collection
		ArrayList aList = new ArrayList();
		aList.add(1);
		aList.add(2);
		
		System.out.println(aList.get(1).getClass());
		
		List<Long> hashList = new ArrayList<Long>();
		Long a=23423L;
		Long b = 3324L;
		Long c=0L;
		hashList.add(23423L);
		hashList.add(3324L);
		hashList.add(0L);
		System.out.println(hashList.contains(0));

		
	}
	
	public static void floatMethod(float f){
		System.out.println(f);
	}
	
}
