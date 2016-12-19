package java8.streams.create;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by vasanth on 12/18/16.
 */
public class FromFiles {
    public static void main(String args[]) throws IOException {

        //stream from a file
        long numberOfLines = Files.lines(Paths.get("src/java8/streams/Streams.java"), Charset.defaultCharset()).count();
        System.out.println("Number of lines in this file = " + numberOfLines);

    }
}
