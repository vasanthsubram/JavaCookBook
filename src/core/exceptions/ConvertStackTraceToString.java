package core.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ConvertStackTraceToString {

	public static void main(String[] args) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		new RuntimeException().printStackTrace(pw);
		System.out.println(sw.toString());
	}
}
