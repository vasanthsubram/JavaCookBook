package core.character.wip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import core.primitives.bytes.ByteConversions;



public class CharacterEncodingBits {

	public static void main(String[] args) throws Exception {
		
	//	new ShowString("\u0B80","MAX_Unicode");
		
		System.out.println("\na 5 bytes example - MAX valid Unicode character");
		print("\u10FFFF".getBytes("UTF-8"));
		
		
		System.out.println(Character.isValidCodePoint(0x10FFFF));
		System.out.println(Character.isValidCodePoint(0x11FFFF));
		
		
		//char c1 = '\u10FFFF';
		char[] smallUnicode = Character.toChars(65);
		System.out.println(smallUnicode[0]);
		
		char[] maxUnicode = Character.toChars(0x10FFFF);
		System.out.printf("1st char in unicode \t= \\u%04x\n", (int) maxUnicode[0]);
		System.out.printf("2nd char in unicode \t= \\u%04x\n", (int) maxUnicode[1]);
		
//		System.out.printf("1st char in unicode \t= \\u%04x\n", (int) ch[0]);
//		System.out.printf("2nd char in unicode \t= \\u%04x\n", (int) ch[1]);
//		System.out.printf("2nd char in unicode \t= \\u%06x\n", 0x10FFFF);
		
//		print(str.getBytes("UTF-16"));
//		print(str.getBytes("ASCII"));
//		print(str.getBytes("UTF-8"));
	}

	private static void print(byte[] bytes) {
		System.out.println("number of bytes = " + bytes.length);
		for (int i = 0; i < bytes.length; i++) {
			System.out.format("%02x \n", bytes[i]);
		}
	}
	
	static void writeOutput(String str) {

	    try {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Writer out = new OutputStreamWriter(bos, "UTF8");
		out.write(str);
		out.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	
}
