package core.numbers.issues;

public class TakeCareWithIntegerDivision {
	public static void main(String[] args) {
		System.out.println(1 / 2); // 0 integer division because the operands
									// are integers
		System.out.println(1.0 / 2.0); // 0.5
		
		System.out.println(1199/100);  //11   truncates the .99 to give an integer

	}

}
