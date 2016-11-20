package core.thread.concurrency.raceCondition.bankExample;

public class Bank {
	protected  int[] accounts;

	public Bank(int n, int initialBalance) {
		accounts = new int[n];
		for (int i = 0; i < accounts.length; i++)
			accounts[i] = initialBalance;
	}

	//Transfers money from one account to another.
	public  void transfer(int from, int to, int amount) {
		if (accounts[from] < amount)
			return;
		//System.out.print(Thread.currentThread());
		accounts[from] -= amount;
		System.out.printf(" %d from %d to %d \t", amount, from, to);
		accounts[to] += amount;
		System.out.printf(" Total Balance: %d%n", getTotalBalance());
	}

	public int getTotalBalance() {
		int sum = 0;

		for (int a : accounts)
			sum += a;

		return sum;
	}
	
	public int getNumberOfAccounts() {
		return accounts.length;
	}

}

