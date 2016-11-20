package core.operators;

import java.util.*;

public class OperatorTest {

		public static void main(String args[]){
			new OperatorTest().test();
		}
		
		public void test(){
			String str=null;
			System.out.println(str == null ? "Input String is Null" : "String is NotNull");
			
			if(str==null){
				System.out.println("Input String is Null");
			} else{
				System.out.println("Input String is NotNull");
			}
			
			String name=null, response=null;
			System.out.println((name ==null | response==null));  //true
			System.out.println((name ==null & response==null)); //true
			
			System.out.println((name !=null | response!=null));  //false
			System.out.println((name !=null & response!=null)); //false
			
			
			// testBitOperators();
			 testShiftDistance();
			//testOtherOperators();
			
		}
		public void testOtherOperators(){
			System.out.println("Hello" instanceof Object);
		}
		
		
		public void testShiftDistance(){		
			System.out.print("1<<0    = ");
			System.out.println(1<<0);
			System.out.print("1<<1    = ");
			System.out.println(1<<1);
			System.out.print("1<<2    = ");
			System.out.println(1<<2);
			System.out.print("1<<30    = ");
			System.out.println(1<<30);
			System.out.print("1<<31    = ");
			System.out.println(1<<31);
			System.out.print("1<<32    = ");
			System.out.println(1<<32);
			System.out.print("1<<33    = ");
			System.out.println(1<<33);
	
			System.out.println();
			System.out.print("-1<<0    = ");
			System.out.println(-1<<0);
			System.out.print("-1<<1    = ");
			System.out.println(-1<<1);
	
			System.out.print("-1<<31    = ");
			System.out.println(-1<<31);
			
			System.out.print("-1<<32    = ");
			System.out.println(-1<<32);
			
			System.out.print("-1<<33    = ");
			System.out.println(-1<<33);
		
			System.out.println();
			System.out.println("right shift");

			System.out.print("1>>0    = ");
			System.out.println(1>>0);
			System.out.print("1>>1    = ");
			System.out.println(1>>1);
			System.out.print("1>>2    = ");
			System.out.println(1>>2);
		}
		
}
