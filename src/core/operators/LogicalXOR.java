package core.operators;
/*
 * A way of implementing LogicalXOR using the logical ==
 */
public class LogicalXOR {

	public static void main(String[] args) {
		int x = 1; //-1
		int y = 2; //-2
		if((x<0) == (y<0)){
			System.out.println("Both x and y are of the same sign");
		} else{
			System.out.println(" x and y are of different sign");
		}
	}
}
