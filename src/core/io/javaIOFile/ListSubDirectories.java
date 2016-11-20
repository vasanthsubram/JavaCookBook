package core.io.javaIOFile;

import java.io.File;
import java.io.FileFilter;

public class ListSubDirectories {

    public static void main(String args[]) {
        File dir = new File("C:/swingset3/com/sun/swingset3/");
        // This filter only returns directories
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory();
            }
        };
        File[] subDirs = dir.listFiles(fileFilter);
        for (File f : subDirs) {
            System.out.println(f);
        }
    }
}
