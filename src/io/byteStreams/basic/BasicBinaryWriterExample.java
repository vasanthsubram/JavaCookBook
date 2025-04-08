package io.byteStreams.basic;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BasicBinaryWriterExample {
    public static void main(String[] args) {

        try(FileOutputStream fos = new FileOutputStream("data.bin");
                DataOutputStream dos = new DataOutputStream(fos) ){
            // Writing binary data
            dos.writeInt(42);                   // 4 bytes
            dos.writeDouble(3.14159);           // 8 bytes
            dos.writeBoolean(true);             // 1 byte
            dos.writeUTF("Hello, binary file!");// UTF string
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(FileInputStream fio = new FileInputStream("data.bin");
                DataInputStream dio = new DataInputStream(fio)) {

            System.out.println(dio.readInt());
            System.out.println(dio.readDouble());
            System.out.println(dio.readBoolean());
            System.out.println(dio.readUTF());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
