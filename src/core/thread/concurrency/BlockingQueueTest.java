package core.thread.concurrency;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

	BlockingQueue<Integer> queue=null;
	int COUNT = 10;
	int Q_SIZE=1;
	Random rand = new Random();
	
	public static void main(String[] args) {
		new BlockingQueueTest().execute();
	}

	public void execute(){
		queue = new ArrayBlockingQueue<Integer>(Q_SIZE);
		for(int i=0;i<COUNT;i++){
			(new Thread(new WriteTask(i))).start();
		}
		(new Thread(new ReadTask())).start();
	}
	
	private class WriteTask implements Runnable{
		int count;
		WriteTask(int count){
			this.count=count;
		}
		
		public void run() {
			try{
				queue.put(count);
				System.out.println("Write: " + count);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
	private class ReadTask implements Runnable{

		public void run() {
			try{
				for(int i=0;i<COUNT;i++){
					System.out.println("\t Read: " + queue.take());
				}
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
}
