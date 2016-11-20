package core.numbers.conversion.binary;

public class IntegerToBinaryString_Division {

	public static void main(String[] args) {
		System.out.println("The binary of 256 is = " + convert(256));
		System.out.println("The binary of -256 is = " + convert(-256));
	}

	static String convert(long input) {
		StringBuffer buf = new StringBuffer();
		do{
			buf.append((input % 2 == 0) ? '0' : '1');
			input = input/ 2;
		} while(input != 0);
		return buf.reverse().toString();
	}
}
