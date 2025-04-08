package io.nio;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Override toString to display object details
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class NioSerializationExample {

    public static void main(String[] args) {
        // Create an object to serialize
        Person person = new Person("Alice", 30);

        // Step 1: Serialize the object using NIO
        Path path = Paths.get("person.ser");
        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(person);

            // Get the byte array from the ByteArrayOutputStream
            byte[] serializedData = byteArrayOutputStream.toByteArray();

            // Write the serialized object to the file
            ByteBuffer byteBuffer = ByteBuffer.wrap(serializedData);
            fileChannel.write(byteBuffer);

            System.out.println("Object has been serialized using NIO.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 2: Deserialize the object using NIO
        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)) {
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) Files.size(path));
            fileChannel.read(byteBuffer);
            byteBuffer.flip(); // Prepare the buffer for reading

            // Convert byte buffer back to byte array
            byte[] serializedData = new byte[byteBuffer.remaining()];
            byteBuffer.get(serializedData);

            // Deserialize the object from the byte array
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedData);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Person deserializedPerson = (Person) objectInputStream.readObject();

            System.out.println("Object has been deserialized: " + deserializedPerson);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
