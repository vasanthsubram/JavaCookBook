package core.primitives.general;

public class IntegralWideningConversion {
	public static void main(String[] args) {

		// From the language specification
		// A widening conversion of a signed integer value to an integral type T
		// simply sign-extends the two's-complement representation of the
		// integer value to fill the wider format.

		long var = -15099;

		// //upper 4 bytes are all ones
		System.out.format("upper 4 bytes are all ones .... %x \n", var);

		byte b = -1;
		char c = (char) b;
		int d = c;

		// When the byte is cast to a char, the sign extention happens 
		//b = 11111111;
		System.out.format("b in HEx .... %x \n", b);
		
		//c = 1111111111111111;
		System.out.println("c in decimal= " + c);
		//System.out.format("c in HEx .... %d \n", c);
		
		// when the char c is assigned to int d, only zero-extension occurs no sign-extension
		System.out.println("d in decimal= " + d);
		//d=00000000000000001111111111111111; 
		System.out.format("d in HEx .... %x \n", d);
	}

}
