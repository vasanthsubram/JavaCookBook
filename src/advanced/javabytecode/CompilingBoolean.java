package advanced.javabytecode;

public class CompilingBoolean {

	void methodA(){
		boolean b= false;
	}

	/*
	void methodA();
	  Code:
	   Stack=1, Locals=2, Args_size=1
	   0:   iconst_0
	   1:   istore_1
	   2:   return
	  LineNumberTable:
	   line 6: 0
	   line 7: 2
	  LocalVariableTable:
	   Start  Length  Slot  Name   Signature
	   0      3      0    this       Lsystem/CompilingBoolean;
	   2      1      1    b       Z
	*/
}
