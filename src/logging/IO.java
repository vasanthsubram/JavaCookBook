package logging;

import org.apache.log4j.*;

public class IO extends Thread {

   static String msg = "ABCDEGHIJKLMNOPQRSTUVWXYZabcdeghijklmnopqrstuvwxyz1234567890";
   static int BUF_SIZE = 1024*4;

   public static void main(String argv[]) throws Exception {

     // What is the length of the runs?
     long len = 10000;

     boolean buffered;
     boolean immediateFlush;
     IO io = null;


     // first test with unbuffered IO and immediate flushing
     buffered = false;
     immediateFlush = true;
     for(int i = 0; i < 5; i++) {
       io = new IO(buffered, immediateFlush, len);
       io.start();
     }

     // join the last created thread. It is likely to be the last
     // thread to finish, although that is not certain. We wait another
     // 5 secs just in case.
     io.join();
     Thread.currentThread().sleep(5000);

     // Second test with unbuffered IO and no immediate flushing
     buffered = false;
     immediateFlush = false;
     for(int i = 0; i < 5; i++) {
       io = new IO(buffered, immediateFlush, len);
       io.start();
     }
     io.join();
     Thread.currentThread().sleep(5000);

     // first test with buffered IO and no immediate flushing
     buffered = true;
     immediateFlush = false;
     for(int i = 0; i < 5; i++) {
       io = new IO(buffered, immediateFlush, len);
       io.start();
     }

     // There is no fourth test since buffered IO and immediate flushing do not make sense

   }

   long len;
   boolean buffered;
   boolean immediateFlush;

   public IO(boolean _buffered, boolean _immediateFlush, long _len) {
     this.len = _len;
     this.buffered = _buffered;
     this.immediateFlush = _immediateFlush;
   }

   public void run() {

     Logger logger = Logger.getLogger("logger-"+getName());

     // A FileAppender is created according to the buffering and
     // immediate flush setting of this IO instance.
     FileAppender fa = new FileAppender();
     fa.setLayout(new PatternLayout("%r %5p %c [%t] - %m%n"));
     fa.setFile(getName()+".log");
     fa.setAppend(false);
     fa.setImmediateFlush(immediateFlush);
     fa.setBufferedIO(buffered);
     fa.setBufferSize(BUF_SIZE);
     fa.activateOptions();
//     logger.setLevel(Level.ALL);
//     logger.addAppender(fa);

     long before = System.currentTimeMillis();

     for(int i = 0; i <len; i++) {
       logger.debug(msg);
     }

     double avg = ((System.currentTimeMillis() - before)*1000.0)/len;
     System.out.println("buffered: "+buffered+", immediateFlush: "+ immediateFlush + ", avg log time: "+avg +" in microseconds.");
   }
}
