package core.thread.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// A shared variable is incremented and decremented between 0 and 1
public class LocksAndCondition {

	public static  int binary=0;
	
	static final ReentrantLock lock= new ReentrantLock();
	static final Condition incCondition=lock.newCondition();
	static final Condition decCondition=lock.newCondition();
	
	public static void main(String[] args) {

		Runnable incrementer = new Runnable(){
			
			public  void run(){
				try{
					lock.lock();
					while(binary==1){
						incCondition.await();
					}
					binary++;
					System.out.println("Inc " + binary);
					decCondition.signalAll();
				} catch(Exception e){
					e.printStackTrace();
				} finally{
					lock.unlock();
				}
			}
		};
		
		Runnable decrementer = new Runnable(){
			public  void run(){
				try{
					lock.lock();
					while(binary==0){
						decCondition.await();
					}
					binary--;
					System.out.println("Dec " + binary);
					incCondition.signalAll();
				} catch(Exception e){
					e.printStackTrace();
				} finally{
					lock.unlock();
				}
			}
		};
		
		System.out.println("Started......");
		while(true){
			new Thread(incrementer).start();
			new Thread(decrementer).start();
			
		}
	}

}
