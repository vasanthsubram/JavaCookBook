package xml.jaxb;


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class StringToDOM {

	static String quote = "\"";
	static String version = quote + "1.0" + quote;
	static String encoding = " encoding=" + quote + "UTF-8" + quote;
	static String xmlSource = "<?xml version=" + version + encoding + "?>"
			+ "<book> <name> Learning JAXB </name> </book>";

	public static void main(String args[]) throws SAXException,
			ParserConfigurationException, IOException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		File f = new File("c:/test.xml");
//		Document doc = builder.parse(new InputSource(
//				new StringReader(xmlSource)));
		Document doc = builder.parse(f);
		System.out.println(doc.getChildNodes().getLength());
		//System.out.println(doc.getTextContent());

	}

}