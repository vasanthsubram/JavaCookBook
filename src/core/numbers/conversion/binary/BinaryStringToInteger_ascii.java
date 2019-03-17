package core.numbers.conversion.binary;
import static org.junit.Assert.assertEquals;

public class BinaryStringToInteger_ascii {

	public static void main(String[] args) {
		String input = "00110010";
		char result = (char)convert(input);
		System.out.println("original input = " + input);
		System.out.println("integer value is " + result);
		assertEquals(Long.toBinaryString(result),input);
	}
	
	public static long convert(String input){
		long result=0;
		for(int i=0; i<input.length();i++){
			result = (input.charAt(i)-'0') + (result * 2);
		}
		return result;
	}
}
