package core.character;
import java.nio.charset.*;

public class CharsetLister {
	public static void main(String[] args) {
		for (Charset cset : Charset.availableCharsets().values()) {
			System.out.println(cset + ": \t" + cset.aliases().toString());
		}

	}
}
