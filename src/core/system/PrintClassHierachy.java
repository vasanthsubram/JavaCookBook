/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.system;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 *
 * @author cuttle-fish
 */
public class PrintClassHierachy {

    public static void main(String args[]) throws Exception {
        ZipFile zipFile = new ZipFile("lib/stdlib.jar");
        List<String> classNames = new ArrayList<String>();
        Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>) zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            if (entry.getName().endsWith(".class")) {
                System.out.println("Found " + entry.getName().replaceAll("/", "\\.").replace(".class", ""));
                String className = entry.getName().replaceAll("/", "\\.").replace(".class", "");
                classNames.add(entry.getName().replaceAll("/", "\\.").replace(".class", ""));
                System.out.println(Class.forName(className).getSuperclass().getName());
            }
        }
    }
}
