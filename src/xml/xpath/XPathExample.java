package xml.xpath;

import java.io.IOException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import javax.xml.xpath.*;

public class XPathExample {

    public static void main(String[] args)
            throws ParserConfigurationException, SAXException,
            IOException, XPathExpressionException {

        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true); // never forget this!
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = builder.parse("src/xml/xpath/books.xml");

        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();

         String query="//book";
        execute(xpath, doc,query);

        query="//book[author='Neal Stephenson']";
        execute(xpath, doc,query);

         query="//book[author='Neal Stephenson']/title";
        execute(xpath, doc,query);

                //give me a list of books written by Neal Stephenson.
         query="//book[author='Neal Stephenson']/title/text()";
        execute(xpath, doc,query);
    }

    static void execute(XPath xpath, Document doc, String query) throws XPathExpressionException {
        XPathExpression expr = xpath.compile(query);
        Object result = expr.evaluate(doc, XPathConstants.NODESET);
        NodeList nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
             System.out.print(nodes.item(i));
             System.out.print("  =>  ");
            System.out.println(nodes.item(i).getNodeValue());
        }
    }
}
