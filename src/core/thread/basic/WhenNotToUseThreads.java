package core.thread.basic;

import java.util.BitSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import algorithms.numbers.primes.detector.PrimeDetectorRoot;

public class WhenNotToUseThreads {
	static int THREAD_POOL_SIZE = 100;
	static int MAX = 10000;

	final static BitSet noThreadColl = new BitSet(MAX);
	final static BitSet threadColl = new BitSet(MAX);

	public static void main(String[] args) {

		long noThreadStart = System.currentTimeMillis();
		findPrimesNoThreads();
		long noThreadTime = System.currentTimeMillis() - noThreadStart;
		System.out.println("Time with no threads = " + noThreadTime);

		long threadStart = System.currentTimeMillis();
		findPrimesThreads();
		long threadTime = System.currentTimeMillis() - threadStart;
		System.out.println("Time with threads = " + threadTime);

		System.out.println("\nNo Thread");
		int numOfPrimesNoThreads = 0;
		for (int i = 0; i < MAX; i++) {
			if (noThreadColl.get(i)) {
				numOfPrimesNoThreads++;
			}
		}
		System.out.println("Number of primes = " + numOfPrimesNoThreads);

		System.out.println("\nThread");
		int numOfPrimesThreads = 0;
		for (int i = 0; i < MAX; i++) {
			if (threadColl.get(i)) {
				numOfPrimesThreads++;
			}
		}
		System.out.println("Number of primes = " + numOfPrimesThreads);
	}

	static void findPrimesNoThreads() {
		long noThreadStart = System.currentTimeMillis();
		for (int i = 2; i < MAX; i++) {
			if (PrimeDetectorRoot.isPrime(i)) {
				noThreadColl.set(i);
			}
		}
		long noThreadTime = System.currentTimeMillis() - noThreadStart;
		System.out.println("Time with no threads = " + noThreadTime);
	}

	static void findPrimesThreads() {
		ExecutorService executor = Executors
				.newFixedThreadPool(THREAD_POOL_SIZE);
		for (int i = 2; i < MAX; i++) {
			executor.execute(new FindPrimeThread(i));
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
	}

	static class FindPrimeThread implements Runnable {
		int num;

		public FindPrimeThread(final int num) {
			this.num = num;
		}

		public void run() {
			if (PrimeDetectorRoot.isPrime(num)) {
				threadColl.set(num);
			}
		}
	}
}