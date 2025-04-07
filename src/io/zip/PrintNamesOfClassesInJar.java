/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io.zip;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class PrintNamesOfClassesInJar {

    public static void main(String args[]) throws Exception {
        String jarName = "C:/java/lib/jconsole.jar";
        JarInputStream jarFile = new JarInputStream(new FileInputStream(jarName));
        JarEntry jarEntry;

        while (true) {
            jarEntry = jarFile.getNextJarEntry();
            if (jarEntry == null) {
                break;
            }
            if (jarEntry.getName().endsWith(".class")) {
                System.out.println("Found " + jarEntry.getName().replaceAll("/", "\\."));
            }
        }
    }
}
