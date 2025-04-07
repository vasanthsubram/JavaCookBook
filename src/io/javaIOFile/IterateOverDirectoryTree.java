/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package io.javaIOFile;

import java.io.File;

/**
 *
 * @author vsubramanian
 */
public class IterateOverDirectoryTree {
    public static void main(String args[]) throws Exception{
         File dir = new File("C:/temp/swingset3/com/sun/swingset3/DemoSelectorPanel.java");         

         File parent=dir;
         while((parent=parent.getParentFile())!=null){
             System.out.println(parent);
             System.out.println(parent.exists());
         }
    }
}
