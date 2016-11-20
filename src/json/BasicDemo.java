package json;

import java.io.StringWriter;
import org.codehaus.jettison.AbstractXMLStreamWriter;
import org.codehaus.jettison.mapped.MappedNamespaceConvention;
import org.codehaus.jettison.mapped.MappedXMLStreamWriter;

public class BasicDemo {

    public static void main(String[] args) throws Exception {
        StringWriter strWriter = new StringWriter();

        // Mapped convention
        MappedNamespaceConvention con = new MappedNamespaceConvention();
        AbstractXMLStreamWriter w = new MappedXMLStreamWriter(con, strWriter);

        // BadgerFish convention
        // AbstractXMLStreamWriter w = new BadgerFishXMLStreamWriter(strWriter);

        w.writeStartDocument();
        w.writeStartElement("alice");
        w.writeCharacters("bob");
        w.writeEndElement();
        w.writeEndDocument();

        w.close();
        strWriter.close();
        System.out.println(strWriter.toString());
    }
}
