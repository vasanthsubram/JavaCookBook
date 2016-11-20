package core.io.javaIOFile;

import java.io.File;

/**
 *
 * @author vsubramanian
 */
public class FileUtil {

    public static String getOsFileSeparator() {
        return (isWinOs() ? winFileSeparator() : linuxFileSeparator());
    }

    public static String winFileSeparator() {
        return "\\";
    }

    public static String linuxFileSeparator() {
        return "/";
    }

    public static boolean isWinOs() {
        String osName = System.getProperty("os.name");
        if (osName == null) {
            return false;
        }
        return (osName.toLowerCase().contains("windows"));
    }

    /**
     * Delete directory and everything under it
     * @param path
     */
    public static void deleteDirectoryTree(File path) {
        if (path.exists()) {
            File[] files = path.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    deleteDirectoryTree(files[i]);
                } else {
                    files[i].delete();
                }
            }
        }
        path.delete();
    }
}
