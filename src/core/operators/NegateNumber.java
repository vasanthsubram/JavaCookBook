package core.operators;

public class NegateNumber {

	public static void main(String[] args) {
		int i = 1;

	    System.out.println("i=  "+i);
	    System.out.println("~i=  "+ ~i);
	    int j = ~i + 1;
	    System.out.println("~i+1 = "+j);

	    i = ~j + 1;
	    System.out.println(" ~(~i+1)+1 = " + i);

	}

}
