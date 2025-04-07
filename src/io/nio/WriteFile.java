package io.nio;

import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;

public class WriteFile {

	public static void main(String[] args) {

		byte data[] = "Hello World!".getBytes();
		Path p = Paths.get("logfileTest.log");

		try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(
				p, CREATE, APPEND))) {
			out.write(data, 0, data.length);
			Files.delete(p);
		} catch (IOException x) {
			System.err.println(x);
		}
	}
}