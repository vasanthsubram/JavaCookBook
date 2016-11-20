package core.io;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RedirectStdOut {

	public static void main(String args[]) {
		// cache the System.out
		PrintStream stdout = System.out;

		// create a stream
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		// RE-DIRECT the standard out to the stream
		System.setOut(ps);

		// write something to standard out
		System.out.println("This text is redirected from stdout to a stream ");

		ps.flush();

		// reset the standard output to the real one
		System.setOut(stdout);

		// Now print the info redirected away from the stdout back to stdout
		System.out.println("The string captured from the byte array: "
				+ baos.toString());

		// Normal stdout printing
		System.out.println("After the standard out is reset;");

	}
}
