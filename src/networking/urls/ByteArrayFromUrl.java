package networking.urls;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author vsubramanian
 */
public class ByteArrayFromUrl {
    public static void main(String[] args) {
        try {
            // Create a URL for the desired doc
            URL url = new URL("file:///c:/tmuninst.ini");
//            File f= new File("c:/rail.pdf");
//            f.toURI();
            // Read all the text returned by the server
            BufferedInputStream in = new BufferedInputStream(url.openStream());
           byte[] b=new byte[1024];
            while (in.read(b) != -1) {
                System.out.println(b);
                System.out.println(b.length);
            }
           for(int i=0;i<b.length;i++){
               System.out.println(b[i]);
           }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
