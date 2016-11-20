package core.primitives.general;

public class UnsignedIntToInt {

	public static void main(String args[]) {
		int factor = 2000000000;
		int uint = Integer.MAX_VALUE + factor;
		System.out.println("Integer max value = " + Integer.MAX_VALUE);
		System.out.println("Unsigned int =  " + uint);

		// ------this assignes the negative value to the long variable
		/*
		 * From the language specification A widening conversion of a signed
		 * integer value to an integral type T simply sign-extends the
		 * two's-complement representation of the integer value to fill the
		 * wider format.
		 */
		long result = ((uint & 0xFF000000))
				| ((uint & 0x00FF0000)) | ((uint & 0x0000FF00))
				| (uint & 0x0000FF);

		//upper 4 bytes are all ones
		System.out.format("Widening conversion = %x\n", result);
	
		//zero-out the upper four bytes by '&' with  0xFFFFFFFFL
		System.out.println("Actual unsigned value = "+ (result & 0xFFFFFFFFL));
		
	}
}
