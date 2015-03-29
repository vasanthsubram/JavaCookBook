package core.character;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class ConversionBetweenUnicodeAndOtherCharsets {

	public static void main(String[] argv) throws Exception {
		Charset charset = Charset.forName("ISO-8859-1");
		CharsetDecoder decoder = charset.newDecoder();
		CharsetEncoder encoder = charset.newEncoder();

		ByteBuffer bbuf = encoder.encode(CharBuffer.wrap("a string"));
		System.out.println(bbuf);
		CharBuffer cbuf = decoder.decode(bbuf);
		String s = cbuf.toString();
		System.out.println(s);
	}
}
