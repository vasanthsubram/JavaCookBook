package core.numbers.conversion.decimal;

// Works for both positive and negative values
public class LongToDecimalString {

	public static void main(String[] args) {
		String result = convert(344);
		System.out.println("string representation = " +result);
	}

	public static String convert(long inputVal){
		StringBuffer buf = new StringBuffer(128);
		long input=Math.abs(inputVal);
		do{
			buf.append((char) ('0'+Math.abs(input%10)));
			input/=10;
		} while (input != 0);
		buf.reverse();
		if(inputVal <0){
			buf.insert(0, '-');
		}
		return buf.toString();
	}
}
