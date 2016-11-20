package xml.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * SAX parser use callback function (org.xml.sax.helpers.DefaultHandler) to informs clients of the XML document structure.
 *
 * startDocument() and endDocument() – Method called at the start and end of an XML document.
 * startElement() and endElement() – Method called at the start and end of a document element.
 * characters() – Method called with the text contents in between the start and end tags of an XML document element.
 *
 * @author vsubramanian
 */
public class SimpleSAXParserDemo {

    public static void main(String argv[]) {

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            //Implement the handler
            DefaultHandler handler = new DefaultHandler() {

                boolean fname = false;
                boolean lname = false;
                boolean salary = false;

                public void startElement(String uri, String localName, String qName,
                        Attributes attributes) throws SAXException {

                    System.out.println("Start Element :" + qName);

                    if (qName.equalsIgnoreCase("FIRSTNAME")) {
                        fname = true;
                    }
                    if (qName.equalsIgnoreCase("LASTNAME")) {
                        lname = true;
                    }
                    if (qName.equalsIgnoreCase("SALARY")) {
                        salary = true;
                    }
                }

                public void endElement(String uri, String localName,
                        String qName) throws SAXException {

                    System.out.println("End Element :" + qName);

                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    if (fname) {
                        System.out.println("First Name : " + new String(ch, start, length));
                        fname = false;
                    }
                    if (lname) {
                        System.out.println("Last Name : " + new String(ch, start, length));
                        lname = false;
                    }
                    if (salary) {
                        System.out.println("Salary : " + new String(ch, start, length));
                        salary = false;
                    }
                }
            };
            saxParser.parse("src/xml/sax/sample.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
