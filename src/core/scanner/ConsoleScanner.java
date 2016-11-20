package core.scanner;

import java.util.*;               

public class ConsoleScanner {

	public static void main(String[] args) {
		String name;
		Scanner in = new Scanner(System.in);
		System.out.println("What's your name, Earthling?");
		name = in.nextLine();
		in.close();
		System.out.println("Take me to your leader, " + name);
	}
}
