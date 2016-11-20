package core.thread.concurrency.raceCondition.bankExample;

public class TransferRunnable implements Runnable {
	private Bank bank;
	private int fromAccount;
	private int maxAmount;
	private int DELAY = 10;

	/**
	 * Constructs a transfer runnable.
	 * 
	 * @param b
	 *            the bank between whose account money is transferred
	 * @param from
	 *            the account to transfer money from
	 * @param max
	 *            the maximum amount of money in each transfer
	 */
	public TransferRunnable(Bank b, int from, int max) {
		bank = b;
		fromAccount = from;
		maxAmount = max;
	}

	public void run() {
		try {
			for(;;) {
				int toAccount = (int) (bank.getNumberOfAccounts() * Math.random());
				int amount = (int) (maxAmount * Math.random());
				bank.transfer(fromAccount, toAccount, amount);
				Thread.sleep((int) (DELAY * Math.random()));
			}
		} catch (InterruptedException e) {
		}
	}

}
