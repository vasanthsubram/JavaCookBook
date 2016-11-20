package core.io.serialization.externalizable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import utils.ExternalizableEntity;

public class ExternalizableTest {

	public static void main(String[] args) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("output/externalizable.txt"));
			ExternalizableEntity entity = new ExternalizableEntity();
			entity.setX(-10);
			entity.setY(100);
			//not persisted
			entity.setDontPersist(1); 
			out.writeObject(entity);
			entity=null;
			out.close();

			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					"output/externalizable.txt"));
			ExternalizableEntity entity2 = (ExternalizableEntity) in
					.readObject();

			System.out.println(entity2.getX());
			System.out.println(entity2.getY());
			System.out.println(entity2.getDontPersist());
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}


