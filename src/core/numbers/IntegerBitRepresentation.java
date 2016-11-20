package core.numbers;

public class IntegerBitRepresentation {
	public static void main(String[] args) {
		System.out.printf("Bit in 65535:	 %17s	\n", Integer.toBinaryString(65535));
		System.out.printf("Bit in 65536:	 %17s	\n",Integer.toBinaryString(65536));
		System.out.println("Num of bits set to 1 in 65535 = " + Integer.bitCount(65535));
		System.out.println("Num of bits set to 1 in 65536 = " + Integer.bitCount(65536));
		
		System.out.println("Highest bit set to 1 in 65535 = " + Integer.highestOneBit(65535));
		System.out.println("Highest bit set to 1 in 65536 = " + Integer.highestOneBit(65536));
		
		System.out.println("Hex " +Long.decode("0xABCD"));
		System.out.println("Octal value = "+Long.decode("0127"));
		System.out.println(Long.parseLong("ABCD",16));
		System.out.println(Long.parseLong("212"));
		
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println(Integer.rotateLeft(Integer.MAX_VALUE, 1));
		System.out.println(Integer.toBinaryString(Integer.rotateLeft(Integer.MAX_VALUE, 1)));
		System.out.println(Integer.rotateRight(Integer.MAX_VALUE, 1));
		System.out.println(Integer.toBinaryString(Integer.rotateRight(Integer.MAX_VALUE, 1)));
	}
}
