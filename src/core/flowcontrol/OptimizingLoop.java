package core.flowcontrol;

import java.util.ArrayList;

import utils.Stopwatch;

/**
 * Avoid using a method call in a loop termintation test; the overhead is significant
 * 
 * @author chq-vasanthakumars
 *
 */
public class OptimizingLoop {

	public static void main(String[] args) {
		int size=100;
		System.out.println("size  " + size);
		test(size);
		test2(size);
		System.out.println();
	}
	
	public static void test(int count){
		ArrayList a =new ArrayList(count);
		
		Stopwatch s = new Stopwatch();
		for(int j=0;j<a.size();j++){
			
		}
		System.out.println(s.elapsedTime());
	}
	public static void test2(int count){
		ArrayList a =new ArrayList(count);
		Stopwatch s = new Stopwatch();
		int collSize =a.size();
		for(int k=0;k<collSize;k++){
			
		}
		System.out.println(s.elapsedTime());
	}
}
