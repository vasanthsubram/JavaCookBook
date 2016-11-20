package core.printing;

public class PrintingCharacters {

	public static void main(String[] args) {
		//unicode
		System.out.printf("A in unicode \t= \\u%04x\n", (int) 'A');
		System.out.printf("a in unicode \t= \\u%04x\n", (int) 'a');
		System.out.printf("Character in unicode = \\u%04x\n", (int) 'Ÿ');
		System.out.printf("Character in unicode = \\u%04x\n", (int) 'Ñ');
	
		//HEX
		System.out.println("Character A in HEX = " + Integer.toHexString((int) 'A'));
		System.out.println("Character A in HEX = " + Integer.toHexString((int) 'a'));
		
		//Binary
		System.out.println("Character A in binary " + Integer.toBinaryString((int) 'A'));
		System.out.println("Character a in binary " + Integer.toBinaryString((int) 'a'));
	}
}
