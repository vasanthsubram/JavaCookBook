package core.strings;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.util.Charsets;

public class CharsetTest {
	
	public static void main(String[] args) throws IOException {
		InputStream input = IOUtils.toInputStream("测试 hello", "UTF-8");
		System.out.println(IOUtils.readLines(input));
		
	}

}
