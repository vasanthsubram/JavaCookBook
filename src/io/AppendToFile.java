package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import org.apache.commons.io.FileUtils;

public class AppendToFile {

    private static String inFile = "output/AppendToFileTest.txt";

    public static void main(String[] args) throws Exception {

        FileOutputStream str = new FileOutputStream(inFile);
        str.write("HelloWorld".getBytes());
        str.close();

        String data = "\n This content will append to the end of the file";

       //true = append file
        FileWriter writter =new FileWriter(inFile, true);
        writter.write(data);
        writter.close();

        System.out.println(FileUtils.readLines(new File(inFile)));
    }
}
