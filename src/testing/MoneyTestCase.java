package testing;

import org.junit.Test;

import junit.framework.TestCase;

public class MoneyTestCase extends TestCase {	
	
	public void runTest(){
		testAdd();
		testSubtract();
		testMultiplication();
		testDivision();
	}
	
	@Test 
	public void testAdd(){
		
		Money m1 = new Money("999.346");
		Money m2 = new Money("234.118");
		
		Money m3 = new Money(999.346);
		Money m4 = new Money(234.118);
		
		Money m5 = new Money(999.346f);
		Money m6 = new Money(234.118f);
		
		Money m7 = new Money(999);
		Money m8 = new Money(234);
		
		Money m9 = new Money(999L);
		Money m10 = new Money(234L);
		
		Money sum = new Money("1233.47");
		Money sum2 = new Money("1233");
		
		Money result = m1.add(m2);
		assertTrue(sum.equals(result));
	
		Money result2 = m3.add(m4);
		assertTrue(sum.equals(result2));
		
		Money result3 = m5.add(m6);
		assertTrue(sum.equals(result3));
		
		Money result4 = m7.add(m8);
		assertTrue(sum2.equals(result4));
		
		Money result5 = m9.add(m10);
		assertTrue(sum2.equals(result5));
		
		assertTrue(new Money(123.23).equals(new Money (123.23).add(new Money(0))));
		
	}

	@Test 
	public void testSubtract(){
		Money m1 = new Money("999.346");
		Money m2 = new Money("234.118");
		
		Money m3 = new Money(999.346);
		Money m4 = new Money(234.118);
		
		Money m5 = new Money(999.346f);
		Money m6 = new Money(234.118f);
		
		Money m7 = new Money(999);
		Money m8 = new Money(234);
		
		Money m9 = new Money(999L);
		Money m10 = new Money(234L);
		
		Money diff = new Money("765.23");
		Money diff2 = new Money("765");
		
		Money result = m1.subtract(m2);
		assertTrue(diff.equals(result));
		
		Money result2 = m3.subtract(m4);
		assertTrue(diff.equals(result2));
		
		Money result3 = m5.subtract(m6);
		assertTrue(diff.equals(result3));
		
		Money result4 = m7.subtract(m8);
		assertTrue(diff2.equals(result4));
		
		Money result5 = m9.subtract(m10);
		assertTrue(diff2.equals(result5));
		
		assertTrue(new Money(123.23).equals(new Money (123.23).subtract(new Money(0))));
	}

	public void testMultiplication(){
		
		Money m1 = new Money("999.346");
		Money m2 = new Money("234.118");
		
		Money m3 = new Money(999.346);
		Money m4 = new Money(234.118);
		
		Money m5 = new Money(999.346f);
		Money m6 = new Money(234.118f);
		
		Money m7 = new Money(999);
		Money m8 = new Money(234);
		
		Money m9 = new Money(999L);
		Money m10 = new Money(234L);
		
		Money prod = new Money("233967.82");
		Money prod2 = new Money("233766");
		
		Money result = m1.multiply(m2);
		printDetail("m1",m1);
		printDetail("m2",m2);
		printDetail("result",result);
		
		assertTrue(prod.equals(result));
		
		Money result2 = m3.multiply(m4);
		assertTrue(prod.equals(result2));
		
		Money result3 = m5.multiply(m6);
		assertTrue(prod.equals(result3));
		
		Money result4 = m7.multiply(m8);
		assertTrue(prod2.equals(result4));
		
		Money result5 = m9.multiply(m10);
		assertTrue(prod2.equals(result5));	
		
		assertTrue(new Money(0).equals(new Money (123.23).multiply(new Money(0))));
		
	}
	
	public void testDivision(){
		try{
			assertTrue(new Money(0).equals(new Money (123.23).divide(new Money(0))));
		}
		catch(ArithmeticException e){
			System.out.println("Arithmetic Exception");
		}
		
		Money m1 = new Money("999.346");
		Money m2 = new Money("0.118");
		
		Money m3 = new Money(999.346);
		Money m4 = new Money(0.118);
		
		Money m5 = new Money(999.346f);
		Money m6 = new Money(0.118f);
		
		Money m7 = new Money(999);
		Money m8 = new Money(234);
		
		Money m9 = new Money(999L);
		Money m10 = new Money(234L);
		
		Money quo = new Money("8327.92");
		Money quo2 = new Money("4.27");
		
		Money result = m1.divide(m2);
		printDetail("m1",m1);
		printDetail("m2",m2);
		printDetail("result",result);
		
		assertTrue(quo.equals(result));
	
		Money result2 = m3.divide(m4);
		assertTrue(quo.equals(result2));
		
		Money result3 = m5.divide(m6);
		assertTrue(quo.equals(result3));
		
		Money result4 = m7.divide(m8);
		assertTrue(quo2.equals(result4));
		
		Money result5 = m9.divide(m10);
		assertTrue(quo2.equals(result5));
	}
	
	private void printDetail(String name, Money m){
		System.out.println(name + " = "+ m);
		System.out.println(name + " scale  = " + m.getAmount().scale());
		System.out.println(name+ " precision = " + m.getAmount().precision());
		System.out.println(name + " unscaled value = " + m.getAmount().unscaledValue());
		System.out.println();
	}
}
