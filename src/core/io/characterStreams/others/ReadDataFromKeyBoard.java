package core.io.characterStreams.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This program captures a text input from the keyboard and prints it on the Console.
 * All the text input before hitting 'Enter' will be printed as one line
 *  Type "exit' to stop the program
 * @author chq-vasanthakumars
 *
 */
public class ReadDataFromKeyBoard {

	public static void main(String args[]) throws IOException {
		String line;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("> Type your text and hit enter. To quit hit ctrl-z ");
		while (true) {
			line = in.readLine();
			if(line == null){
				System.out.println("\n\nExiting");
				break;
			}
			System.out.println("You entered: " + line );
		}
	}
}
