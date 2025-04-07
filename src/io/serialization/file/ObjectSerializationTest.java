package io.serialization.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import utils.Employee;

public class ObjectSerializationTest {
	public static void main(String[] args) throws Exception {
		// WRITE
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				"output/ObjectSerializationTest.dat"));
		out.writeObject(new Employee("Emp1", 50000, 1989, 11, 1));
		out.writeObject(new Employee("Emp2", 60000, 1987, 12, 1));
		out.close();

		// READ
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				"output/ObjectSerializationTest.dat"));
		System.out.println(in.readObject());
		System.out.println(in.readObject());
		in.close();
	}
}
