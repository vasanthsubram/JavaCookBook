package core.strings;

public class ConcatenatingStringAndChar {

	/**
	 * This program demonstrates the perils of concatenating string and chars
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// char is simply an integer number.
		// so concatenating two char is really adding their ascii values
		System.out.println('H' + 'a'); // prints 169

		// if started with a string, concatenating the char to a string, results
		// in printing the string representation of the char rather than their
		// ASCII values
		System.out.println("" + 'H' + 'a'); // prints Ha

		// if started with the chars, concatenating the char to a string, results
		// in adding the ASCII values of the chars to a String
		System.out.println('H' + 'a' + ""); // prints 169
		
		System.out.println('H' + 'a' + " Ha"); // prints 169
		
		String s = "five" + 2 + 2;
		System.out.println(s);		//prints five22
		
	}

}
