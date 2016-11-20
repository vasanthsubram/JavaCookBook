package core.strings;

public class ConvertBinaryToText {
	static String input="0110011101101111011011110110010000100001";
	
	public static void main(String[] args) throws Exception{
		
		byte[] bytes=new byte[input.length()/8];
		
		for(int i=0;i<input.length();i=i+8){
			//bytes[i/8]=(byte)convertBinaryStringToInt(input.substring(i, i+8));
			bytes[i/8]=Byte.parseByte(input.substring(i, i+8), 2);
		}
		System.out.println("The text represented by the binary:  " + input +" = \n"  + new String(bytes));
		
		System.out.println();
		
		String str = "Hello World";
		StringBuffer output= new StringBuffer();
		for(char c: str.toCharArray()){
			output.append(padWithZero(convertIntToBinaryString(c),8));
		}
		System.out.println("Binary for '" + str + "' is \n" + output.toString());
	}

	public static int convertBinaryStringToInt(String input){
		int result=0;
		for(int i=0; i<input.length();i++){
			result = (input.charAt(i)-'0') + (result * 2);
		}
		return result;
	}
	
	public static String convertIntToBinaryString(int input) {
		StringBuffer buf = new StringBuffer();
		do{
			buf.append((input % 2 == 0) ? '0' : '1');
			input /= 2;
		} while(input != 0);
		return buf.reverse().toString();
	}
	
	public static String padWithZero(String s, int size){
		StringBuffer buf=new StringBuffer(s);
		while(buf.length()<8){
			buf.insert(0, '0');
		}
		return buf.toString();
	}
}
