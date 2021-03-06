package core.thread.threadpools;

import java.util.*;
import java.util.concurrent.*;

import utils.TestUtils;

public class CallableExample {

	public static class WordLengthCallable implements Callable<Integer> {
		private String word;

		public WordLengthCallable(String word) {
			this.word = word;
		}

		public Integer call() {
			System.out.println(word);
			return Integer.valueOf(word.length());
		}
	}

	public static void main(String args[]) throws Exception {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		Set<Future<Integer>> set = new HashSet<Future<Integer>>();

		for (int i = 0; i < 5; i++) {
			Callable<Integer> callable = new WordLengthCallable(TestUtils
					.getRandomString());
			Future<Integer> future = pool.submit(callable);
			set.add(future);
		}

		int sum = 0;
		for (Future<Integer> future : set) {
			sum += future.get();
		}
		System.out.println();
		System.out.println();
		System.out.printf("The sum of lengths is %s%n", sum);
		pool.shutdownNow();
	}
}
