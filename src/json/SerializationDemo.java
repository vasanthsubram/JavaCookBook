package json;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import java.util.ArrayList;
import java.util.List;
import utils.Employee;

public class SerializationDemo {

    public static void main(String[] args) throws Exception {
//      demoSimpleObject();
        demoCollectionOfObjects();
    }

    public static void demoSimpleObject() throws Exception {
        Employee emp = new Employee("John Smith", 2300, 1, 1, 1);
        XStream xstream = new XStream(new JettisonMappedXmlDriver());
//        XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.alias("emp", Employee.class);

        String jsonString = xstream.toXML(emp);
        System.out.println(jsonString);

        Employee deserialized = (Employee) xstream.fromXML(jsonString);
        System.out.println(deserialized.getName());
    }

    public static void demoCollectionOfObjects() throws Exception {
        List<Employee> coll = new ArrayList<Employee>();
        Employee emp1 = new Employee("John Smith", 2300, 2010, 1, 1);
        Employee emp2 = new Employee("Jack Smith", 2400, 2010, 3, 3);
        coll.add(emp1);
        coll.add(emp2);
        XStream xstream = new XStream(new JettisonMappedXmlDriver());
//        XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
        xstream.setMode(XStream.NO_REFERENCES);
//        xstream.alias("emp", Employee.class);

        String jsonString = xstream.toXML(coll);
//        System.out.println(jsonString);

//        List<Employee> deserialized = (List<Employee>) xstream.fromXML(jsonString);
       Object obj =  xstream.fromXML(jsonString);
        System.out.println(obj);
    }
}
