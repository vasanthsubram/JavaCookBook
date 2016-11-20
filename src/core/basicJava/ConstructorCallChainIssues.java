package core.basicJava;

public class ConstructorCallChainIssues {

	//A call from constructor to constructor, cannot include a call to instance method
	//In this constructor, the getMessage() cannot be called
	//To fix it, make the getMessage(), a static
	public ConstructorCallChainIssues(String msg){
		//this("boo", getMessage());
	}
	
	public ConstructorCallChainIssues(String msg, String msg2){
	}
	
	private  String getMessage(){
		return "Message";
	}
	public static void main(String[] args) {
		new ConstructorCallChainIssues("boo");

	}

}
