package core.thread.concurrency.raceCondition.bankExample;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Bank_lock  extends Bank{
	ReentrantLock lock;
	private Condition sufficientFunds;
	
	public Bank_lock(int n, int initialBalance) {
		super(n,initialBalance);
		lock=new ReentrantLock();
		sufficientFunds = lock.newCondition();
	}
	
	
	public void transfer(int from, int to, int amount)  {
		try {
			lock.lock();
			while (accounts[from] < amount){
	            sufficientFunds.await();
			}

			accounts[from] -= amount;
			System.out.printf(" %d from %d to %d \t", amount, from, to);
			accounts[to] += amount;
			System.out.printf(" Total Balance: %d%n", getTotalBalance());
			
			sufficientFunds.signalAll();
		} catch(InterruptedException iex){
			iex.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	// For each mutable state variable that may be accessed by more than one
	// thread, all accesses to that variable must be performed with the same
	// lock held. 
	// The 'accounts' is protected by the same lock and protected in two
	// methods - transfer() and getTotalBalance()
	
	public int getTotalBalance() {
		int sum = 0;
		try {
			lock.lock();
			for (int a : accounts)
				sum += a;
		} finally {
			lock.unlock();
		}
		return sum;
	}
}
