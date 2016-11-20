/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core.strings;

import java.util.Arrays;

/**
 *
 * @author vsubramanian
 */
public class StringAndBytes {
    public static void main(String[] args) {

        byte[] b=new byte[]{'H','E','L','L','O',',','W','O','R','L','D'};
        StringBuilder builder=new StringBuilder();
        for(byte byt: b){
            builder.append(b);
        }
        for(byte byt: b){
            System.out.print(byt);
            System.out.print("\t");
        }
        byte[] b1= builder.toString().getBytes();
        System.out.println();

        for(byte byt: b1){
            System.out.print(byt);
            System.out.print("\t");

        }
        System.out.println();
        System.out.println(Arrays.equals(b, b1));

    }
}
