package core.io.serialization.xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import utils.Employee;
import utils.Manager;
import core.io.FileUtil;

/**
 * XML serialization using java beans XML encoder and decoder The objects to be
 * persisted must be a bean - should have getters and setters for all public
 * variable and a public default constructor
 * 
 * @author chq-vasanthakumars
 * 
 */
public class XMLSerialization {

	public static void main(String args[]) throws Exception {

		String fileName = "output/xml_encodingTest.xml";
		XMLEncoder e = null;
		XMLDecoder d = null;
		Employee emp = new Employee("Sec", 4444, 1980, 1, 1);
		Employee emp1 = new Employee("Employee1", 1111, 1980, 1, 1);
		Employee emp2 = new Employee("Employee2", 2222, 1980, 1, 1);
		Employee emp3 = new Employee("Employee3", 3333, 1980, 1, 1);
		Manager manager = new Manager("Manager1", 0000, 1980, 1, 1);
		manager.addDirectRport(emp1);
		manager.addDirectRport(emp2);
		manager.addDirectRport(emp3);
		manager.setSecretary(emp);

		try {
			e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(
					fileName)));
			e.writeObject(manager);
			e.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		FileUtil.printTextFile(fileName);

		// try {
		// d = new XMLDecoder(new BufferedInputStream(new
		// FileInputStream(fileName)));
		// JButton button = (JButton) d.readObject();
		// System.out.println(button.getClass().getName());
		// System.out.println(button.getText());
		// d.close();
		// } catch (Exception ex) {
		// ex.printStackTrace();
		// }
	}
}
