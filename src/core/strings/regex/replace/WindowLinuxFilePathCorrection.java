package core.strings.regex.replace;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author vsubramanian
 */
public class WindowLinuxFilePathCorrection {

    public static void main(String[] args) {

        //unix to windows
        Pattern unixToWin = Pattern.compile("/");
        //a unix path is converted to a win path
        System.out.println(unixToWin.matcher("/mnt/bora-bora").replaceAll("\\\\"));
        //a win path is unchanged
        System.out.println(unixToWin.matcher("\\mnt\\bora-bora").replaceAll("\\\\"));

        System.out.println();
        
         //windows to unix
        Pattern winToUnix=Pattern.compile("\\\\");
        //a win path is changed to unix path
        System.out.println(winToUnix.matcher("\\mnt\\bora-bora").replaceAll("/"));
        //a unix path is unchanged
        System.out.println(winToUnix.matcher("/mnt/bora-bora").replaceAll("/"));
    }
}
