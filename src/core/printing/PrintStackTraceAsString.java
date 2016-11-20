package core.printing;

import java.io.PrintWriter;
import java.io.StringWriter;

public class PrintStackTraceAsString {

	public static void main(String[] args) {
		try {
			throw new RuntimeException();
		} catch (Throwable t) {
			String str = stackTraceAsString(t);
			System.out.println(str);
		}
	}

	private static String stackTraceAsString(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		return sw.toString();
	}
}
