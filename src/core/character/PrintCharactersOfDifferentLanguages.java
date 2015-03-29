package core.character;

public class PrintCharactersOfDifferentLanguages {

	public static void main(String[] args) {
		System.out.println('\u03C1');

		// Greek
		for (int i = '\u0370'; i < '\u03FF'; i++) {
			System.out.print((char) i);
		}

		System.out.println();
		// Tamil
		for (int j = '\u0B80'; j < '\u0BFF'; j++) {
			System.out.print((char) j);
		}

		System.out.println();
		// Sanskrit
		for (int j = '\u0900'; j < '\u097f'; j++) {
			System.out.print((char) j);
		}
	}

}
