package io.javaIOFile;

import java.io.File;

/**
 *
 * @author vsubramanian
 */
public class PrintRoots {

    public static void main(String[] args) {
        File[] roots = File.listRoots();
        for (int i = 0; i < roots.length; i++) {
            System.out.println(roots[i]);
        }
    }
}
