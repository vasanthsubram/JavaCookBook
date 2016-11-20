package core.character;

public class Unicode {

	public static void main(String[] args) {
		/*
		 Unicode provides a unique number for every character, no matter what
		 the platform or program or language
		*/
		// char b='c'; is declared using unicode escape as below
		ch\u0061r \u0062 = '\u0063';
		System.out.println(\u0062); // prints c

		
		
		// unicode characters bigger than FFFF
		// 0x10FFFF is the max unicode value
		System.out.println("number of char needed to represent 0x10ffff ="
				+ Character.charCount(0x10ffff));
		
		System.out.println("Characters to represent 0x10FFFF");
		char[] g = Character.toChars(0x10FFFF);
		System.out.println(Integer.toHexString(g[0]));
		System.out.println(Integer.toHexString(g[1]));
		//g[0] =dbff
		//g[1] =dfff
		
		//High-surrogate - chars between '\uD800' and '\uDBFF'
		System.out.println("is dbff a Low surrogate => " +Character.isHighSurrogate('\udbff'));
		
		//Low-surrogate - chars between '\uDC00' and '\uDFFF'
		System.out.println("is dbff a Low surrogate => " +Character.isLowSurrogate('\udfff'));
		
		
		//get back 0x10FFFF
		System.out.println(Integer.toHexString(Character.codePointAt(g, 0)));
		//get back 0x10FFFF
		System.out.println(Integer.toHexString(Character.codePointBefore(g, 2)));
		
		System.out.println(Character.isLetter(0xdbff));
	}
}
