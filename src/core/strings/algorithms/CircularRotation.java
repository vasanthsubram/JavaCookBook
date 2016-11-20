package core.strings.algorithms;

/**
 * A string s is a circular rotation of a string t if it matches when the characters are circularly shifted by any 
 * number of positions; e.g., ACTGACG is a circular shift of TGACGAC, and vice versa. 
 * Detecting this condition is important in the study of genomic sequences. 
 * 
 * This program that checks whether two given strings s and t are circular shifts of one another. 
 * 
 * @author subramav
 *
 */
public class CircularRotation {

	
	public static void main(String[] args) {
		
		String s = "ACTGACG";
		String t = "TGACGAC";
		
		if(s.length() == t.length() && (s.concat(s).indexOf(t) >= 0)){
			System.out.println("Yes, " + s + " is circular rotation of " + t);
		} else{
			System.out.println("No, " + s + " is not circular rotation of " + t);
		}
	}

}
