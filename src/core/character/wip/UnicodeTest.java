package core.character.wip;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class UnicodeTest {

	public static void main(String[] args) throws Exception {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Writer out = new OutputStreamWriter(baos, "UTF8");
		//out.write(new String("\u65e5\u672c\u8a9e\u6587\u5b57\u5217"));
		out.write(new String("\u0065\u0067\u0370"));
		out.close();

		StringBuffer buffer = new StringBuffer();

		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(
				baos.toByteArray()), "UTF8");
		Reader in = new BufferedReader(isr);
		int ch;
		while ((ch = in.read()) > -1) {
			buffer.append((char) ch);
		}
		in.close();

		 new ShowString(buffer.toString(), "Conversion Demo");
	}
}
