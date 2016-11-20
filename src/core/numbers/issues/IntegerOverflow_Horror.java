package core.numbers.issues;

public class IntegerOverflow_Horror {
	public static void main(String[] args) {
		//This results in infinte loop; 
		// when i=128, it overflows and becomes negative and enters into
		// infinite loop
		for(byte i=125;i<128;i++){
			System.out.println(i);
		}
	}
}
