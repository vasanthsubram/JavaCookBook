package core.numbers;

import java.util.Random;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class RandomNegativeNumber {

	private static int RND_NUM;
	
	private static int POSITIVE_LOWER_LIMIT=1000;
	private static int POSITIVE_UPPER_LIMIT = Integer.MAX_VALUE-POSITIVE_LOWER_LIMIT;
	public static Random randGen = new Random();
	
	/**
	 * This method is used to generate a random negative integer for use as id for database rows, for testing purposes.
	 * 
	 * The logic:
	 * Generate a number between POSITIVE_LOWER_LIMIT and POSITIVE_UPPER_LIMIT and return the negative of that number
	 * 
	 * The negative number would range between (Integer.MIN_VALUE + POSITIVE_LOWER_LIMIT) and negative(POSITIVE_LOWER_LIMIT).
	 * If the LOWER_LIMIT =1000, then the range is  -2147482648 and -1000
	 * 
	 * @return
	 */
	public static int getNegativeRandomID(){
		while(RND_NUM <= POSITIVE_LOWER_LIMIT || (RND_NUM >= POSITIVE_UPPER_LIMIT)){ 
			RND_NUM = randGen.nextInt(POSITIVE_UPPER_LIMIT);
		}
		RND_NUM = -RND_NUM;
		System.out.println(RND_NUM);
		return RND_NUM;
	}
	
	
	
	@Test
	public void testNegativeRandomID(){
		System.out.println("Smallest number = " + (Integer.MIN_VALUE + POSITIVE_LOWER_LIMIT));
		System.out.println("Biggest number = " + -(POSITIVE_LOWER_LIMIT));
		System.out.println();
		
		System.out.println("Lower than LOWER_LIMIT");
		RND_NUM=POSITIVE_LOWER_LIMIT-1;
		checkNumber(getNegativeRandomID());
		
		System.out.println("LOWER_LIMIT");
		RND_NUM=POSITIVE_LOWER_LIMIT;
		checkNumber(getNegativeRandomID());
		
		System.out.println("Higher than the LOWER_LIMIT");
		RND_NUM=POSITIVE_LOWER_LIMIT+1;
		checkNumber(getNegativeRandomID());
		
		System.out.println("Lower than the UPPER_LIMIT");
		RND_NUM=POSITIVE_UPPER_LIMIT - 1;
		checkNumber(getNegativeRandomID());
		
		System.out.println("UPPER_LIMIT");
		RND_NUM=POSITIVE_UPPER_LIMIT;
		checkNumber(getNegativeRandomID());
	
		System.out.println("Higher than the UPPER_LIMIT");
		RND_NUM=POSITIVE_UPPER_LIMIT+1;
		checkNumber(getNegativeRandomID());
		
		System.out.println("At zero");
		RND_NUM=0;
		checkNumber(getNegativeRandomID());
	}
	
	private void checkNumber(int num){
		assertTrue(num < -(POSITIVE_LOWER_LIMIT));
		assertTrue(num > -(POSITIVE_UPPER_LIMIT));
	}
	}