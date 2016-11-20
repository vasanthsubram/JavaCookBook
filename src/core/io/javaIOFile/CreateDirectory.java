package core.io.javaIOFile;

import java.io.File;

/**
 *
 * @author vsubramanian
 */
public class CreateDirectory {
    public static void main(String args[]) throws Exception{
         File dir = new File(System.getProperty("user.dir")+"/output/testDir/test.txt");
         System.out.println(dir.getParentFile().exists());
         if(!dir.exists()){
             //dir.createNewFile();
            // dir.getParentFile().createNewFile();
             System.out.println(dir.getParentFile());
             System.out.println(dir.getParentFile().mkdirs());
         }
    }

}
