package core.thread.concurrency.raceCondition.bankExample;

/**
 * This program shows data corruption when multiple threads access a data structure.
 * @version 1.30 2004-08-01
 * @author Cay Horstmann
 */
public class BankTest {
	public static final int NACCOUNTS = 5;
	public static final int INITIAL_BALANCE = 1000;

	public static void main(String[] args) throws Exception{
//		System.out.println("Unsynchronized Bank accounts ...............");
//		System.out.println();
//		new BankTest().testUnSynchedBank();
//		Thread.currentThread().sleep(5000);
//		
//		System.out.println();
//		System.out.println("Synchronized Bank accounts - using Locks...............");
//		System.out.println();
//		new BankTest().testBankSynchedByLock();
//		Thread.currentThread().sleep(5000);
		
		System.out.println();
		System.out.println("Synchronized Bank accounts - using Synchronized keyword...............");
		System.out.println();
		new BankTest().testBankSynchedBySynchronizedKeyWord();
	}

	public void testUnSynchedBank() {
		Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
		int i;
		for (i = 0; i < NACCOUNTS; i++) {
			TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
			Thread t = new Thread(r);
			t.start();
		}
	}
	public void testBankSynchedByLock() {
		Bank_lock b = new Bank_lock(NACCOUNTS, INITIAL_BALANCE);
		int i;
		for (i = 0; i < NACCOUNTS; i++) {
			TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
			Thread t = new Thread(r);
			t.start();
		}
	}
	
	public void testBankSynchedBySynchronizedKeyWord() {
		Bank_synchronized b = new Bank_synchronized(NACCOUNTS, INITIAL_BALANCE);
		int i;
		for (i = 0; i < NACCOUNTS; i++) {
			TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
			Thread t = new Thread(r);
			t.start();
		}
	}
}

 