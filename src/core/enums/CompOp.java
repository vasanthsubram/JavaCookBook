package core.enums;

public enum CompOp {

	LT, GT, LTE, GTE, EQ;
	
	public boolean isLT(){
		return this== LT;
	}
	
	public boolean isGT(){
		return this== GT;
	}
	
	public boolean isLTE(){
		return this== LTE;
	}
	
	public boolean isGTE(){
		return this== GTE;
	}
	
	public boolean isEQ(){
		return this== EQ;
	}
}
