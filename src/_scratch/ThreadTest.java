package _scratch;

import java.io.IOException;

public class ThreadTest {

	public static void main(String[] args) throws Exception {
		for(int i=0;i<100;i++){
			new Thread1().start();
		}
		System.in.read();
	}

	static class Thread1 extends Thread{
		public void run(){
			try {
				System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
