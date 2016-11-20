package java8;

import java.util.ArrayList;
import java.util.List;

public class FunctionTest {

	private boolean hidden;
	private int value;
	
	public FunctionTest(boolean hidden, int value) {
		super();
		this.hidden = hidden;
		this.value=value;
	}

	public boolean isHidden(){
		return hidden;
	}
	
	public int getValue() {
		return value;
	}

	public static void main(String[] args) {
	
			List<FunctionTest> list = new ArrayList<FunctionTest>();
			list.add(new FunctionTest(false, -100));
			list.add(new FunctionTest(false, 1));
			list.add(new FunctionTest(true, 2));
			
			FunctionTest obj =list.stream().filter(FunctionTest::isHidden).findAny().get();
			System.out.println(obj.isHidden());
			System.out.println(obj.getValue());
			
	}
	
}
