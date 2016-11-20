package core.io.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.*;

public class FilesTest {

		public static void main(String[] args) throws IOException {
			Path dir=Paths.get("c:/temp");
			if (!Files.exists(dir)) {
				dir = Files.createDirectory(dir);
			}
			Path file = dir.resolve("test.java");
			if(!Files.exists(file)){
				Files.createFile(file);
			}
			byte data[] = "Hello World!".getBytes();
			Files.write(file, data, APPEND);
			byte[] fileArray = Files.readAllBytes(file);
			System.out.println(fileArray.length);
		}
}
