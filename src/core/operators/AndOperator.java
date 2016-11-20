package core.operators;

public class AndOperator {

	public static void main(String[] args) {
		//if the variable is AND-ed with itself, it remains unchanged
		System.out.println(4 & 4);	

		System.out.println(false & false);
		System.out.println(false & true);
		System.out.println(true & true);
		
		System.out.println();
		
		//Mod can be generated using AND 
		//but only for (2^n)-1 numbers (3,7,15,31,63,etc.,)
		int modFactor=3;
		
		for(int i=0;i<14;i++){
			System.out.println(i & modFactor);
		}
	}
	

}
