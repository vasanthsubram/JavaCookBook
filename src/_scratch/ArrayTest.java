package _scratch;

import java.util.UUID;



public class ArrayTest {

	 // Static variable allocated in global area.
    static int b = 1;


    //                       NOTE: parameter variable argv

    public static void main (String[] argv)
    {// Pangram: a sentence with at least one occurence of each letter 'a' to 'z'.

        // Direct creation of String array with constants.
        String[] pangramWords = {"two", "driven", "jocks", "help", "fax", "my", "big", "quiz"};
        // Note: pangramWords is a pointer.

        // Count total length of all words.
        int totalChars = 0;
        for (int i=0; i < pangramWords.length; i++) {
            // Here we are using String's length() method.
            totalChars += pangramWords[i].length();
        }
        System.out.println ("Total #letters in pangram: " + totalChars);
        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString());
    }

    
}
