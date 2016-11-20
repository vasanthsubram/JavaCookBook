package cglib;

class TargetClass{
    
	public TargetClass(){}
	
	public void printSelf(){
		System.out.println(this.toString());
	}
	
	public String toString(){
		return "I am the real instance - aTargetClass";
	}
}