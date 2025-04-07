package io.javaIOFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This program deletes all the contents of a file. 
 * Make sure output/clearFileContents.txt
 * 
 * @author chq-vasanthakumars
 *
 */
public class ClearFileContents {
    private static String inFile = "output/clearFileContents.txt";
    
    public static void main(String args[]) throws FileNotFoundException, IOException {
            FileOutputStream str = new FileOutputStream(inFile);
            str.close();
        
    }
}
