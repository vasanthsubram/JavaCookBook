package collection_lambda.collection.array;

public class ArrayElements {
	public static void main(String[] args) {
		int[] intArr = new int[] {0,1,3};
		
		//cannot assign int array to an Integer[] var
		//Integer[] integerArr = intArr;
		
		//cannot assign int array to a long[] var
		long[] longArr = new long[3];
		// longArr=intArr;
		
		//can assign an Integer array to Object Array
		Object[] obj= new Integer[3];
		obj[0]=1;
		obj[1]=2;
		for(Integer integer: (Integer[])obj){
			System.out.println(integer);
		}
		
		//cannot assign an Integer array to Long array because Integer is not a subclass of Long
		//Long[] longArr = new Integer[2];
		
		//cannot assign arrays of unrelated objects
		//Employee[] empArr =  new Node[];
		
		ColoredPoint[] cpa = new ColoredPoint[10];
        //A ColoredPoint can be assigned to a Point; therefore, 
        //the value of cpa can be assigned to pa.
        Point[] pa = cpa;
        System.out.println(pa[1] == null);
        try {
            //But since pa holds a reference to an array of ColoredPoint,
            //the assignment is valid only if the type of the value assigned
            //at run-time is, more specifically, a ColoredPoint.
            pa[0] = new Point();    
        } catch (ArrayStoreException e) {
            System.out.println(e);
        }
	}
}

class Point {
    int x, y;
}

class ColoredPoint extends Point {
    int color;
}

