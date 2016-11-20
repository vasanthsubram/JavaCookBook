package core.strings;

public class Intern {

	public static void main(String[] args) {
			String s1 = new String("abc");
			String s2 = new String("abc");
			System.out.println("s1 == s2? " + (s1 == s2));
			
			s2 = s2.intern();
			s1 = s1.intern();
			System.out.println("after intern");
			System.out.println("s1 = " + s1);
			System.out.println("s2 = " + s2);
			System.out.println("s1 == s2? " + (s1 == s2));
			System.out.println("s1.equals(s2)? " + (s1.equals(s2)));
			
		}
}
