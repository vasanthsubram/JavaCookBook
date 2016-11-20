package core.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;

public class CloseStreams {

    public static void main(String[] args) throws Exception{
       ByteArrayInputStream bis = new ByteArrayInputStream(new byte[3]);
       ByteArrayOutputStream bos = new ByteArrayOutputStream();
        closeStreams(bis,bos);
    }

   static void closeStreams(Closeable... streams) throws IOException{
    for(Closeable c: streams){
        c.close();
        System.out.println("closing "+ c.getClass().getName().toString() );
    }
   }
}
