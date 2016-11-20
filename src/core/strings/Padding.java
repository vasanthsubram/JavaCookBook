package core.strings;

/**
 *
 * @author vsubramanian
 */
public class Padding {

    public static final int LENGTH=10;
    public static void main(String[] args) {
        //left pad a number with 0 and upto 5 places
        System.out.println(String.format("%0"+LENGTH+"d", 123));

      //left pad a string with BLANKs and upto 5 places
        System.out.println(String.format("%5s", "abc"));
        
    }
}
