package core.thread.concurrency.raceCondition.bankExample;

public class Bank_synchronized  extends Bank{
	
	public Bank_synchronized(int n, int initialBalance) {
		super(n,initialBalance);
	}
	
	public synchronized void transfer(int from, int to, int amount) {
		try {
			while (accounts[from] < amount){
	            wait();
			}
			accounts[from] -= amount;
			System.out.printf(" %d from %d to %d \t", amount, from, to);
			accounts[to] += amount;
			System.out.printf(" Total Balance: %d%n", getTotalBalance());
			
			notifyAll();
		} catch(InterruptedException iex){
			iex.printStackTrace();
		}
	}
	
	// For each mutable state variable that may be accessed by more than one
	// thread, all accesses to that variable must be performed with the same
	// lock held. 
	// The 'accounts' is protected by the same lock and protected in two
	// methods - transfer() and getTotalBalance()
	
	public synchronized int getTotalBalance() {
		int sum = 0;

		for (int a : accounts)
			sum += a;

		return sum;
	}
}
