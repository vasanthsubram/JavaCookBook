package io.characterStreams.basic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BasicFileRead {
    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("file.txt");
            int in;
            while ( (in = fileReader.read()) != -1) {
                System.out.println((char)in);
            }
        } catch (FileNotFoundException e) {
            //
        } catch (IOException e) {
            //
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
