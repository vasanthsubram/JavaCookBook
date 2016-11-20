package core.numbers.floatingpoints;

public class FloatingPointInHEX {
	public static void main(String[] args) {
		//p represents binary exponent -raised to power of 2
		//p is mandatory
	    System.out.println(0x12p0);
	    System.out.println(0x1.2p4);
	    System.out.println(0x120p-4);
	    
	    System.out.println(Float.toHexString(100.78f));
	}
}
