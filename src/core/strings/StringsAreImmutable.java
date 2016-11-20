package core.strings;

public class StringsAreImmutable {

	/**
	 * This program demonstrates that modifications of a string are performed on
	 * the copy of that string. The original String is not changed.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		String s1 = "America";
		String s2=s1.replace('c', 'k');
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		System.out.println("s1 == s2  is  " + (s1 == s2));
	}

}
