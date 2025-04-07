package io.serialization.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import utils.Employee;
import utils.Manager;

/**
 * @version 1.10 17 Aug 1998
 * @author Cay Horstmann
 */
class SimpleGraphStreamTest {
	public static void main(String[] args) {
		Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
		carl.setSecretary(harry);
		Manager tony = new Manager("Tony Tester", 40000, 1990, 3, 15);
		tony.setSecretary(harry);

		Employee[] staff = new Employee[3];

		staff[0] = carl;
		staff[1] = harry;
		staff[2] = tony;

		try {
			// save all employee records to the file employee.dat
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("output/SimpleGraphStreamTest.dat"));
			out.writeObject(staff);
			out.close();

			// retrieve all records into a new array
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					"output/SimpleGraphStreamTest.dat"));
			Employee[] newStaff = (Employee[]) in.readObject();
			in.close();

			// raise secretary's salary
			newStaff[1].raiseSalary(10);

			// print the newly read employee records
			for (Employee e : newStaff)
				System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}