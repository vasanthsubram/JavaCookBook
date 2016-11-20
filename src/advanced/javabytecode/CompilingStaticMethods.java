package advanced.javabytecode;

public class CompilingStaticMethods {

	public static void main(String[] args) {
		print();
		//new CompilingStaticMethods().printInstance();
	}

	static void print(){
		
	}
	
	void printInstance(){
		System.out.println(this);
	}
}
