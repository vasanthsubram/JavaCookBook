package core.character;

/**
 * new char arrays are initialzied with ASCII NULL character  - \u0000
 * @author chq-vasanthakumars
 *
 */
public class CharArrayInitialization {
	public static void main(String[] args) {

		char[] charArr = new char[10];
		for (char c : charArr) {
			System.out.println(c);
		}
	}
}
