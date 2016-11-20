package core.strings;

public class Splitting {
	public static void main(String[] args) {
		System.out.println("one space between words");
		for (String s : "Hello Hello World".split(" ")) {
			System.out.println(s);
		}
		System.out.println();

		System.out.println("two space between words");
		for (String s : "Hello  Hello  World".split(" ")) {
			System.out.println(s);
		}
		System.out.println();
		
		System.out.println("correct way to split line with more than one space between words");
		for (String s : "Hello   Hello   World".split(" +")) {
			System.out.println(s);
		}
		
		System.out.println("split line with 'tab' between words");
		for (String s : "Hello	Hello	World".split("\t+")) {
			System.out.println(s);
		}
	}

}
