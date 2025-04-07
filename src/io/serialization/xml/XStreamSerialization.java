package io.serialization.xml;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import utils.Employee;
import utils.Manager;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.xml.CompactWriter;
import com.thoughtworks.xstream.io.xml.XppReader;

public class XStreamSerialization {

	public static void main(String[] args) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		OutputStreamWriter out = new OutputStreamWriter(bos);
		CompactWriter writer = new CompactWriter(out);
		XStream xstream = new XStream();
		Employee emp = new Employee("Sec", 4444, 1980, 1, 1);
		Employee emp1 = new Employee("Employee1", 1111, 1980, 1, 1);
		Employee emp2 = new Employee("Employee2", 2222, 1980, 1, 1);
		Employee emp3 = new Employee("Employee3", 3333, 1980, 1, 1);
		Manager manager = new Manager("Manager1", 0000, 1980, 1, 1);
		manager.addDirectRport(emp1);
		manager.addDirectRport(emp2);
		manager.addDirectRport(emp3);
		manager.setSecretary(emp);
		xstream.marshal(manager, writer);
		System.out.println(bos.toString());

		HierarchicalStreamReader reader = new XppReader(new InputStreamReader(
				new ByteArrayInputStream(bos.toByteArray())));
		Manager result = (Manager) xstream.unmarshal(reader);
		System.out.println(result.getName());
		for (Employee e : result.getDirectReports()) {
			System.out.println(e.getName());
		}
		System.out.println(manager.getSecretary().getName());
	}
}
