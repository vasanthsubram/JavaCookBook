package core.system;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 *
 * @author cuttle-fish
 */
public class ClassLoaderDemo {

    static String fileName = "C:/java/lib/jconsole.jar";

    public static void main(String[] args) throws Exception {

        ZipFile zipFile = new ZipFile(fileName);
        File file = new File(fileName);
        URL jarfile = new URL("jar", "", "file:" + file.getAbsolutePath() + "!/");
        URLClassLoader cl = URLClassLoader.newInstance(new URL[]{jarfile});
        
        Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>) zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            if (entry.getName().endsWith(".class")) {
                String className = entry.getName().replaceAll("/", "\\.").replace(".class", "");
                Class loadedClass = cl.loadClass(className);
                System.out.println(loadedClass.getName());
            }
        }
    }
}
