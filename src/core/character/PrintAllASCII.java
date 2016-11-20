package core.character;

public class PrintAllASCII {
	/*
	 * ASCII includes definitions for 128 characters: 33 are non-printing
	 * control characters (now mostly obsolete) that affect how text and space
	 * is processed; 94 are printable characters, and the space is considered
	 * an invisible graphic.
	 */
	public static void main(String[] args) {

		byte bytes[] = new byte[127];
		for (int i = 0; i < bytes.length; i++)
			bytes[i] = (byte) i;

		String str = new String(bytes);
		System.out.println(str);

		// another way 
		//int can be assigned to a char
		StringBuffer buf = new StringBuffer();
		for (char i = 0; i < 127; i++) {
			buf.append(i);
		}
		System.out.println(buf.toString());
	}

}
